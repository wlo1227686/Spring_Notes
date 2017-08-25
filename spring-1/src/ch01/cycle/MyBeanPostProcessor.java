package ch01.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("[ProcessAfter]...." + bean + ", " + beanName);
		Car car = new Car();
		car.setBrand("Ford");
		return car;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("[ProcessBefore]...." + bean + ", " + beanName);
		if ("car".equals(beanName)) {
			// ...
		}
		return bean;
	}

}
