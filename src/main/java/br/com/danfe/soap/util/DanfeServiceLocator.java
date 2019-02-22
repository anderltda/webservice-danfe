package br.com.danfe.soap.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.danfe.soap.service.DanfeService;

public class DanfeServiceLocator {

	private static DanfeServiceLocator instance;

	private static ClassPathXmlApplicationContext ctx;

	private DanfeServiceLocator() {
		init();
	}

	public static void init() {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		}
		br.com.danfe.fundacao.service.ServiceLocator.getInstance().setApplicationContext(ctx);
	}

	public static DanfeServiceLocator getInstance() {
		if (instance == null) {
			instance = new DanfeServiceLocator();
		}
		return instance;
	}

	public DanfeService getDanfeService() {
		if (ctx == null) {
			return null;
		}
		DanfeService service = (DanfeService) ctx.getBean("serviceDanfeService");
		return service;
	}

	public void printBeans() {
		if (instance == null) return;
		for (String beanName : ctx.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
	}
}
