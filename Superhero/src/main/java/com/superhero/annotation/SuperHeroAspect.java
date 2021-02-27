package com.superhero.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SuperHeroAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(SuperHeroAspect.class);

	@Around("@annotation(LogTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
	
	    Object proceed = joinPoint.proceed();
	
	    long executionTime = System.currentTimeMillis() - start;
	
	    logger.info(joinPoint.getSignature()+ " executed in " + executionTime + " ms");
	    return proceed;
	}
}
