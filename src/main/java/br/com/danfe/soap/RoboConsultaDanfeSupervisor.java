package br.com.danfe.soap;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RoboConsultaDanfeSupervisor extends Thread {
	private static Integer FREQUENCY = 5;
	private static long TIMEOUT_IN_MILLIS = 10000000;
	private static int WAIT_FOR_KILL = 25;

	List<RoboConsultaDanferWorker> workers;
	List<RoboConsultaDanferWorker> interruptedWorkes = new ArrayList<RoboConsultaDanferWorker>();

	// logger
	protected static final Log log = LogFactory.getLog(RoboConsultaDanfeSupervisor.class);

	// contrutor padrão
	public RoboConsultaDanfeSupervisor(List<RoboConsultaDanferWorker> workers) {
		this.workers = workers;
	}

	@Override
	public void run() {
		while (true) {
			try {
				processThreads();
				processInterruptedThreads();
				sleep(FREQUENCY);
			} catch (InterruptedException e) {
				log.error(e);
			} finally {
			}
		}

	}

	private void processThreads() {
		for (int i = 0; i < workers.size(); i++) {
			RoboConsultaDanferWorker worker = workers.get(i);
			State sit = worker.getState();
			if (sit == Thread.State.TERMINATED) {
				workers.set(i, worker.clone());
			} else {
				// para qq outro status diferente do terminated - verifica do
				// Thread.State.RUNNABLE / BLOCKED / WAITING / TIMED_WAITING
				long startTime = worker.getStartTime();
				if (startTime > 0 && ((System.currentTimeMillis() - startTime) > TIMEOUT_IN_MILLIS)) {
					System.out.println("Detectado timeout na Thread " + worker.getName() + " WorkItemId = " + worker.getWorkItem().getId());
					worker.interrupt();
					interruptedWorkes.add(worker);
					workers.set(i, worker.clone());
				}
			}
		}
	}

	private void processInterruptedThreads() {
		List<Integer> toRemove = new ArrayList<Integer>();
		for (int i = 0; i < interruptedWorkes.size(); i++) {
			RoboConsultaDanferWorker worker = interruptedWorkes.get(i);
			if (worker.getState() == Thread.State.TERMINATED || worker.getCheckForFree() >= WAIT_FOR_KILL) {
				toRemove.add(i);
			} else
				worker.setCheckForFree(worker.getCheckForFree() + 1);
		}
		for (int i = (toRemove.size() - 1); i >= 0; i--) {
			RoboConsultaDanferWorker workerToRemove = interruptedWorkes.get(i);
			workerToRemove.clean();
			toRemove.remove(i);
		}
	}
}
