package ch02.aop.helloword;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//動態代理的方式
public class ArithmeticCalculatorLoggingProxy {
	// 受代理的對象
	private ArithmeticCalculator target;

	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}

	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy = null;

		// 代理對象由哪一個類加載器負責
		ClassLoader loader = target.getClass().getClassLoader();
		// 代理對象的類型，即其中有哪些方法
		Class[] interfaces = new Class[] { ArithmeticCalculator.class };
		// 當調用代理對象其中的方法時，該執行的代碼
		InvocationHandler h = new InvocationHandler() {
			// proxy: 正在返回的那個代理對象，一般情況下，在invoke方法中都不使用該對象
			// method: 正在被調用的方法
			// args:調用方法時傳入的參數
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				String methodName = method.getName();

				// 日誌
				System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));

				// 執行方法
				Object result = method.invoke(target, args);

				// 日誌
				System.out.println("The method " + methodName + " ends with " + result);
				return result;
			}
		};
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);

		return proxy;
	}
}
