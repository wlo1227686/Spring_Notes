package spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//將該Class宣告為一個類別: 
//1.需要把該class放入ioc容器
//2.在宣告這個class為一個切面

//可以使用order來指定該切面的優先順序,值越小代表該切面的優先順序越大
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	// 前置通知:在目標方法開始之前執行
	@Before("execution(public int spring.aop.ArithmeticCalculator.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());

		System.out.println("The method " + methodName + " begins with" + args);
	}

	// 後置通知:在目標方法執行後(無論是否發生例外事件)才執行
	// 在後置通知中,無法取得目標方法執行完的結果值
	@After("execution(public int spring.aop.ArithmeticCalculator.*(..))")
	public void AfterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());

		System.out.println("The method " + methodName + " ends");
	}

	// 返回通知:在目標方法執行完後(不可以發生例外)才執行
	// 可以取得該方法的返回值
	@AfterReturning(value = "execution(public int spring.aop.ArithmeticCalculator.*(..))", returning = "result")
	public void AfterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());

		System.out.println("The method " + methodName + " ends with " + result);
	}

	// 異常通知:在目標方法執行發生異常時,才執行
	// 可以區分各種不同例外事件,所要顯示不同的通知
	@AfterThrowing(value = "execution(public int spring.aop..ArithmeticCalculator.*(..))", throwing = "ex")
	public void AfterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " occurs excetion: " + ex);

	}

	// 環繞通知:類似一個動態代理的全過程(前置,後置,返回,異常)
	// 要攜帶ProceedingJoinPoint類型的參數
	// 必須要有個返回值,該值為目標方法的返回值
	// @Around("execution(public int spring.aop.ArithmeticCalculator.*(..))")
	// public Object AroundMethod(ProceedingJoinPoint pjd) {
	// Object result = null;
	// String methodName = pjd.getSignature().getName();
	//
	// try {
	//
	// // 前置通知
	// System.out.println("The method " + methodName + " begins with" +
	// Arrays.asList(pjd.getArgs()));
	//
	// result = pjd.proceed();
	//
	// // 返回通知
	// System.out.println("The method " + methodName + " ends with " + result);
	//
	// } catch (Throwable e) {
	// // 異常通知
	// System.out.println("The method " + methodName + " occurs excetion: " +
	// e);
	// throw new RuntimeException(e);
	// }
	//
	// // 返回通知
	// System.out.println("The method " + methodName + " ends");
	// return result;
	// }

}
