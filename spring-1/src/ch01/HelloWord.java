package ch01;

public class HelloWord {
	private String name;

	public void setName(String name) {
		System.out.println("Step_2 setName: " + name);
		this.name = name;
	}

	public void hello() {
		System.out.println("Hello: " + name);
	}

	public HelloWord() {
		System.out.println("Step_1 Helloword form constructor");
	}

}
