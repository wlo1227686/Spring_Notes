package ch01.factory;

import java.util.HashMap;
import java.util.Map;

//靜態工廠方法:值接取用某一個類的靜態方法就可以返回Bean的實例

public class StaticCarFactory {

	private static Map<String, Car> cars = new HashMap<String, Car>();

	static {
		cars.put("audi", new Car("audi", 1500000));
		cars.put("ford", new Car("ford", 2000000));
	}

	// 靜態工廠方法
	public static Car getCar(String name) {
		return cars.get(name);
	}
}
