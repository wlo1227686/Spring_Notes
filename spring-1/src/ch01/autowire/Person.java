package ch01.autowire;

public class Person {
	private String name;
	private Address Address;
	private Car car;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address address) {
		Address = address;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", Address=" + Address + ", car=" + car + "]";
	}

}
