package ch01.cycle;

public class Car {

	public Car() {
		System.out.println("Car's Constructor...");
	}

	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("[car]setBrand...");
		this.brand = brand;
	}

	public void init_by_chenfu() {
		System.out.println("[car]init...");
	}

	public void destory_by_chenfu() {
		System.out.println("[car]destory...");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}

}
