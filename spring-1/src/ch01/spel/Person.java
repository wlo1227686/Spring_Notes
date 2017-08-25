package ch01.spel;

public class Person {
	private String name;
	private Car car;

	// 引用address bean 的city屬性
	private String city;
	// 根據car的price來決定info的內容:當car的price>=1500000 金領，否則為白領
	private String info;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + ", city=" + city + ", info=" + info + "]";
	}

}
