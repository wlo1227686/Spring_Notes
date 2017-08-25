package spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class ValidationAspect {
	@Before("execution(public int spring.aop.ArithmeticCalculator.*(..))")
	private void vlidationAspect(JoinPoint joinPoint) {
		System.out.println("-->validate:" + Arrays.asList(joinPoint.getArgs()));
	}
}
