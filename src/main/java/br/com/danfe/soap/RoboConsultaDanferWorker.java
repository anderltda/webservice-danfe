package br.com.danfe.soap;

import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.danfe.fundacao.service.ServiceException;
import br.com.danfe.servicos.persistencia.SrvDanfe;
import br.com.danfe.servicos.persistencia.TmpRoboDanfe;
import br.com.danfe.soap.service.DanfeService;

public class RoboConsultaDanferWorker extends Thread implements Cloneable {
	protected static final Log log = LogFactory.getLog(RoboConsultaDanferWorker.class);
	protected SrvDanfe workItem = null;
	protected long startTime = 0;
	protected ConcurrentLinkedQueue<SrvDanfe> workingList;
	protected DanfeService service;
	protected int checkForFree = 0;

	public RoboConsultaDanferWorker(ConcurrentLinkedQueue<SrvDanfe> workingList, DanfeService service) {
		this.workingList = workingList;
		this.service = service;
	}

	public SrvDanfe getWorkItem() {
		return workItem;
	}

	public long getStartTime() {
		return startTime;
	}

	public ConcurrentLinkedQueue<SrvDanfe> getWorkingList() {
		return workingList;
	}

	public DanfeService getService() {
		return service;
	}

	public int getCheckForFree() {
		return checkForFree;
	}

	public void setCheckForFree(int checkForFree) {
		this.checkForFree = checkForFree;
	}

	@Override
	public void run() {
		try {
			while (!workingList.isEmpty() && !isInterrupted()) {
				workItem = workingList.poll();
				while (workItem != null && !isInterrupted()) {
					boolean consultado = false;
					try {
						consultarDanfe(workItem);
						consultado = true;
					} catch (Exception e) {
						log.error(e);
					} finally {
						if (!consultado) {
							clean(workItem);
							workItem = null;
						}
					}
					workItem = workingList.poll();
				}
			}
		} catch (Exception e) {
			if (workItem != null) clean(workItem);
		} finally {
		}
	}

	private void clean(SrvDanfe workItem2) {
		System.out.println("__________________________________" + workItem2.getId());
	}

	public void clean() {
		if (workItem != null) clean(workItem);
	}

	private void consultarDanfe(SrvDanfe workItem2) {
		startTime = System.currentTimeMillis();
		try {
			service.testeDemoraBanco(60);
			TmpRoboDanfe tmpRoboDanfe = service.getByID(TmpRoboDanfe.class, workItem.getId());
			tmpRoboDanfe.setStatus(RoboConsultaDanfe.STATUS_CONSULTADO);
			tmpRoboDanfe.setUltimaAtualizacao(new Date());
			tmpRoboDanfe.setChave("**" + tmpRoboDanfe.getChave());
			service.update(tmpRoboDanfe);
		} catch (ServiceException e) {
			e.printStackTrace();
			clean(workItem);
		} finally {
			startTime = 0;
		}
	}

	@Override
	protected RoboConsultaDanferWorker clone() {
		RoboConsultaDanferWorker newObj = new RoboConsultaDanferWorker(this.workingList, this.service);
		newObj.setName(getName());
		return newObj;
	}

}
