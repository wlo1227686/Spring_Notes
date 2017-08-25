package spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	public void BeforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());

		System.out.println("The method " + methodName + " begins with" + args);
	}

	public void AfterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());

		System.out.println("The method " + methodName + " ends");
	}

	public void AfterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());

		System.out.println("The method " + methodName + " ends with " + result);
	}

	public void AfterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();

		System.out.println("The method " + methodName + " occurs excetion: " + ex);

	}

	public Object AroundMethod(ProceedingJoinPoint pjd) {
		Object result = null;
		String methodName = pjd.getSignature().getName();

		try {
			// 前置通知
			System.out.println("The method " + methodName + " begins with" + Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
			// 返回通知
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			// 異常通知
			System.out.println("The method " + methodName + " occurs excetion: " + e);
			throw new RuntimeException(e);
		}
		// 後置通知
		System.out.println("The method " + methodName + " ends");
		return result;
	}

}
