package br.com.danfe.soap;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.danfe.fundacao.service.ServiceException;
import br.com.danfe.servicos.persistencia.SrvDanfe;
import br.com.danfe.soap.parse.Parse;
import br.com.danfe.soap.parse.Sim;
import br.com.danfe.soap.reader.Reader;
import br.com.danfe.soap.service.DanfeService;
import br.com.danfe.soap.util.DanfeServiceLocator;

/**
 * @author andersonsilva-tool
 * 
 */
public class Initialize extends Thread {

	protected static final Log log = LogFactory.getLog(Initialize.class);

	private static Integer THREAD = 10;
	private static Integer FREQUENCY = 2500;

	private Reader reader = null;

	@Override
	public void run() {
		try {
			reader.read();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		DanfeServiceLocator.init();

		while (true) {
			
			List<SrvDanfe> danfes = findDanfes(DanfeServiceLocator.getInstance().getDanfeService());
			
			if (danfes.size() > 0) {
				work(Sim.class, danfes);
			}
			
			try {
				Thread.sleep(FREQUENCY);
			} catch (Exception e) {
			}
		}
	}

	private static void work(Class<?> concreteWorkerClass, List<SrvDanfe> danfes) {

		log.debug("Iniciando MAIN thread:" + Thread.currentThread().getId());

		int resto = (danfes.size() % THREAD);
		int interaction = (danfes.size() / THREAD);

		int start = 0;
		int end = interaction;
		int thread = interaction > 0 ? THREAD : interaction;
		
		CyclicBarrier barrier = null;
		
		if(thread > 0) {
			barrier = new CyclicBarrier(THREAD + 1);
		} else {
			barrier = new CyclicBarrier(2);
		}

		for (int i = 0; i < thread; i++) {
			Initialize initialize = new Initialize();
			Reader reader = createConcreteClass(Parse.class);
			reader.setBarrier(barrier);
			reader.setService(DanfeServiceLocator.getInstance().getDanfeService());
			reader.setList(danfes.subList(start, end));
			reader.setReader(createConcreteClass(concreteWorkerClass));
			initialize.setReader(reader);
			initialize.start();
			start += interaction;
			end += interaction;
		}

		if (resto > 0) {
			Initialize initialize = new Initialize();
			Reader reader = createConcreteClass(Parse.class);
			reader.setBarrier(barrier);
			reader.setService(DanfeServiceLocator.getInstance().getDanfeService());
			reader.setList(danfes.subList(start, (start + resto)));
			reader.setReader(createConcreteClass(concreteWorkerClass));
			initialize.setReader(reader);
			initialize.start();
		}

		try {
			barrier.await(2000, TimeUnit.SECONDS);
		} catch (Throwable e) {
		}
		
		log.debug("Finalizando MAIN thread:" + Thread.currentThread().getId());
	}

	private static Reader createConcreteClass(Class<?> concreteWorkerClass) {
		Object concreteWorker = null;
		try {
			concreteWorker = concreteWorkerClass.newInstance();
			return (Reader) concreteWorker;
		} catch (Exception e) {
			return null;
		}
	}

	private static List<SrvDanfe> findDanfes(DanfeService service) throws ServiceException {
		List<SrvDanfe> danfes = service.findByDanfes();
		for (SrvDanfe srvDanfe : danfes) {
			srvDanfe.setDhIniConsulta(new Date());
		}
		return danfes;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}
}