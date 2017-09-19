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
	 * ��ȡspringContext����
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			throw new RuntimeException("spring�����Ļ���δ��ʼ��");
		}
		return applicationContext;
	}

	/**
	 * ��ȡ�����Ļ����е�bean
	 * @param <T>
	 */

	public static <T> T getBean(String name, Class<T> clz) {
		if (applicationContext == null) {
			throw new RuntimeException("spring�����Ļ���δ��ʼ��");
		}
		T bean = applicationContext.getBean(name, clz);
		return bean;
	}

}
