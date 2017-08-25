package ch02.aop.helloword;

public class Main {
	public static void main(String[] args) {
		// ArithmeticCalculator arithmeticCalculator = null;
		// arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();
		ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();

		System.out.println("-->" + arithmeticCalculator.add(10, 2));
		System.out.println("-->" + arithmeticCalculator.sub(10, 2));
		System.out.println("-->" + arithmeticCalculator.mul(10, 2));
		System.out.println("-->" + arithmeticCalculator.div(10, 2));

		// 動態代理方法
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		System.out.println(proxy.getClass().getName());
		System.out.println("-->" + proxy.add(10, 2));
		System.out.println("-->" + proxy.sub(10, 2));
		System.out.println("-->" + proxy.mul(10, 2));
		System.out.println("-->" + proxy.div(10, 2));
	}
}
