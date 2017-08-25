package ch01.factory;

import java.util.HashMap;
import java.util.Map;

//實例工廠方法:實例工廠的方法,需要先new工廠本身，再使用工廠的實例方法來返回bean的實例

public class InstanceCarFactory {
	private Map<String, Car> cars = null;

	public InstanceCarFactory() {
		cars = new HashMap<String, Car>();
		cars.put("Audi", new Car("Audi", 1600000));
		cars.put("Ford", new Car("Ford", 2100000));
	}

	public Car getCar(String brand) {
		return cars.get(brand);
	}
}
