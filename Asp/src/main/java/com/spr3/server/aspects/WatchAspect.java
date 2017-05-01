package com.spr3.server.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class WatchAspect {

	@Around("execution(* com.spr3.server.service..*.*(..))")
	public void profile(ProceedingJoinPoint joinPoint) throws Throwable
	{
		System.out.println("Start:"+System.currentTimeMillis());
		try{
			joinPoint.proceed();
			System.out.println("End:"+System.currentTimeMillis());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
