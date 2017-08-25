package spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class VlidationAspect {
	
	private void vlidationAspect(JoinPoint joinPoint) {
		System.out.println("-->validate:" + Arrays.asList(joinPoint.getArgs()));
	}
}
