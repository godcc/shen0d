package cc.shen0d.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextUtil.applicationContext = applicationContext;
	}

	/**
	 * 获取springContext环境
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			throw new RuntimeException("spring上下文环境未初始化");
		}
		return applicationContext;
	}

	/**
	 * 获取上下文环境中的bean
	 * @param <T>
	 */

	public static <T> T getBean(String name, Class<T> clz) {
		if (applicationContext == null) {
			throw new RuntimeException("spring上下文环境未初始化");
		}
		T bean = applicationContext.getBean(name, clz);
		return bean;
	}

}
