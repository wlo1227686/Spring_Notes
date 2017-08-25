package ch01.factorybean;

import org.springframework.beans.factory.FactoryBean;

//自訂義的FactoryBean 需要實現FactoryBean接口
public class CarFactoryBean implements FactoryBean<Car> {
	private String brand;

	public void setBrand(String brand) {
		this.brand = brand;
	}

	// 返回bean的對象
	@Override
	public Car getObject() throws Exception {
		return new Car(brand, 1500000);
	}

	// 返回的Bean的類別
	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
