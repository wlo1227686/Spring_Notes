package ch01.spel;

public class Car {
	private String brand;
	private double price;
	// 輪胎周長
	private double tyrePerimter;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", tyrePerimter=" + tyrePerimter + "]";
	}

	public Car() {
		System.out.println("Car's Constructor.....");
	}

	public double getTyrePerimter() {
		return tyrePerimter;
	}

	public void setTyrePerimter(double tyrePerimter) {
		this.tyrePerimter = tyrePerimter;
	}

}
