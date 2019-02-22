package br.com.danfe.soap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.danfe.commons.util.NumberUtil;
import br.com.danfe.commons.util.SetUtil;
import br.com.danfe.servicos.persistencia.SrvDanfe;
import br.com.danfe.soap.service.DanfeService;
import br.com.danfe.soap.util.DanfeServiceLocator;

public class RoboConsultaDanfe {
	public static final Byte STATUS_PRONTO = new Byte("1");
	public static final Byte STATUS_EM_CONSULTA = new Byte("2");
	public static final Byte STATUS_CONSULTADO = new Byte("3");
	public static final int TIMEOUT_CONSULTA = 60;
	public static final int FREQUENCY = 2500;
	public static final int THREADS = 1;

	SrvDanfe workItem = null;
	long startTime;

	// logger
	protected static final Log log = LogFactory.getLog(RoboConsultaDanfe.class);

	// flag para indicar foi detectado um timeout global
	static boolean timedOut;
	static ConcurrentLinkedQueue<SrvDanfe> workingList;

	static RoboConsultaDanfeFetcherWorker fetcher;
	static RoboConsultaDanfeSupervisor supervisor;
	static List<RoboConsultaDanferWorker> workers;

	static DanfeService service;

	public synchronized ConcurrentLinkedQueue<SrvDanfe> getWorkingList() {
		return workingList;
	}

	public static void main(String[] args) {
		// Quantidade de threads a serem criadas
		int parallelThreads = NumberUtil.intValue(System.getProperty("threads"));
		if (parallelThreads == 0) parallelThreads = THREADS;

		// criar uma thread para ficar supervisionando e buscando novos itens
		if (workingList == null) workingList = new ConcurrentLinkedQueue<SrvDanfe>();

		service = DanfeServiceLocator.getInstance().getDanfeService();
		if (service == null) {
			System.out.println("Erro ao buscar Service - saindo.");
			System.exit(1);
		}

		// cria a thread que alimenta a lista de trabalho
		if (fetcher == null) {
			fetcher = new RoboConsultaDanfeFetcherWorker(workingList);
			RoboConsultaDanfeFetcherWorker.service = service;
			fetcher.start();
		}

		// cria os trabalhadores
		workers = new ArrayList<RoboConsultaDanferWorker>(parallelThreads);
		for (int threadCount = 1; threadCount <= parallelThreads; threadCount++) {
			// prepara o produtor
			workers.add(new RoboConsultaDanferWorker(workingList, service));
		}

		// cria o supervisor
		if (supervisor == null) {
			supervisor = new RoboConsultaDanfeSupervisor(workers);
			supervisor.start();
		}

		// espera a ter primeira 'leva' de trabalho
		while (workingList.isEmpty()) {
			try {
				Thread.currentThread().sleep(FREQUENCY);
			} catch (Throwable e) {
			} finally {
			}
		}

		// fica processando la bagace
		while (true) {
			try {
				doWork(parallelThreads);
			} catch (Throwable e) {
			} finally {
			}
		}
	}

	private static void doWork(int parallelThreads) {
		// lista vazia, nada a fazer
		if (SetUtil.isEmpty(workingList)) {
			return;
		}
		for (int threadCount = 0; threadCount < parallelThreads; threadCount++) {
			// cria a thread
			RoboConsultaDanferWorker worker = workers.get(threadCount);
			if (worker.getState() == Thread.State.NEW) worker.start();
		}
	}

	public long getStartTime() {
		return startTime;
	}

	public SrvDanfe getWorkItem() {
		return workItem;
	}

	public static DanfeService getService() {
		return service;
	}

}
