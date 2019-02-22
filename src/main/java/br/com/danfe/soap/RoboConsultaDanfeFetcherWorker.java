package br.com.danfe.soap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.danfe.commons.util.DateTimeUtil;
import br.com.danfe.fundacao.query.Condition;
import br.com.danfe.fundacao.query.SortingCondition;
import br.com.danfe.fundacao.query.operator.LessOperator;
import br.com.danfe.fundacao.service.Paginator;
import br.com.danfe.fundacao.service.ServiceException;
import br.com.danfe.servicos.persistencia.SrvDanfe;
import br.com.danfe.servicos.persistencia.TmpRoboDanfe;
import br.com.danfe.soap.service.DanfeService;

public class RoboConsultaDanfeFetcherWorker extends Thread {
	private static Integer FREQUENCY = 5000;
	private static Integer SIZE = 5;
	private static Integer FETCH_FOR_MORE_SIZE = 1;

	// logger
	protected static final Log log = LogFactory.getLog(RoboConsultaDanfeFetcherWorker.class);

	// flag para indicar se todos as threads liberaram os recursos
	static boolean cleaned;

	static DanfeService service;

	// flag para indicar foi detectado um timeout global
	static boolean timedOut;

	// flag para indicar se os recursos desta thread já foram liberados
	boolean resourcesFree = false;

	ConcurrentLinkedQueue<SrvDanfe> workingList;

	// contrutor padrão
	public RoboConsultaDanfeFetcherWorker(ConcurrentLinkedQueue<SrvDanfe> workingList) {
		this.workingList = workingList;
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (workingList.size() < FETCH_FOR_MORE_SIZE) {
					fetchForMore();
				}
				sleep(FREQUENCY);
			} catch (InterruptedException e) {
				log.error(e);
			} finally {
				// cleanUpResources();
			}
		}

	}

	private synchronized void fetchForMore() {
		// buscar novos registros no banco
		// prepara a busca das conditions
		Condition statusPronto = new Condition("status", RoboConsultaDanfe.STATUS_PRONTO);
		Condition ultimaAtualizacao = new Condition(new LessOperator(), "ultimaAtualizacao", DateTimeUtil.addSeconds(new Date(), RoboConsultaDanfe.TIMEOUT_CONSULTA));
		Condition statusEmConsulta = new Condition("status", RoboConsultaDanfe.STATUS_EM_CONSULTA);
		ultimaAtualizacao.addCondition(statusEmConsulta);
		statusPronto.addORCondition(ultimaAtualizacao);
		List<Condition> conditions = new ArrayList<Condition>(1);
		conditions.add(statusPronto);

		System.out.println(" === Buscando mais registros === " + DateTimeUtil.formatFullDateTime(new Date()) + " Tamanho Atual: " + workingList.size());
		List<SrvDanfe> listaRandom = new ArrayList<SrvDanfe>();

		try {
			Paginator<TmpRoboDanfe> registros = service.findByProperties(TmpRoboDanfe.class, conditions, 1, SIZE, new SortingCondition("ultimaAtualizacao"), new SortingCondition("id"));

			if (registros.getItemCount() == 0) {
				System.out.println("Nenhum item mais para tratar.");
				return;
			}

			System.out.println("Total de Registros = " + registros.getItemCount());
			// Block dos registros de trabalho
			List<TmpRoboDanfe> lista = registros.getList(1);
			for (TmpRoboDanfe tmpRoboDanfe : lista) {
				System.out.println(tmpRoboDanfe);
				tmpRoboDanfe.setStatus(RoboConsultaDanfe.STATUS_EM_CONSULTA);
				tmpRoboDanfe.setUltimaAtualizacao(new Date());
				service.update(tmpRoboDanfe);
				SrvDanfe obj = new SrvDanfe();
				obj.setId(tmpRoboDanfe.getId());
				listaRandom.add(obj);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		workingList.addAll(listaRandom);
	}

	private void returnToList(SrvDanfe workItem) {
		// TODO Auto-generated method stub
		// alterar o status no banco e sumir com o item
		System.out.println("Retornando para a lista");
		System.out.println(" ID =>> " + workItem.getId());
	}

	public void cleanUpResources() {
		System.out.println("Liberando recursos");
		SrvDanfe workItem = workingList.poll();
		while (workItem != null) {
			try {
				returnToList(workItem);
			} catch (Exception e) {
				log.error(e);
			} finally {
			}
			workItem = workingList.poll();
		}
	}

}
