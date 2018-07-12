package com.example.demo.logs;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspact {

	@Before(value="@annotation(LogCreate)")
	public void logBefore(JoinPoint joinPoint)throws Throwable{
		Object[] args = joinPoint.getArgs();
        Logger logger= LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        logger.info("Going for Save:{}",args[0].toString());
	}
	@AfterReturning(value="@annotation(LogCreate)")
	public void logAfterSuccess(JoinPoint joinPoint)throws Throwable{
		Object[] args = joinPoint.getArgs();
        Logger logger= LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
        logger.info("Saved:{}",args[0].toString());
	}
	@AfterThrowing(value="@annotation(LogCreate)",throwing="err")
	public void logAfterError(JoinPoint joinPoint,Throwable err)throws Throwable{
		Logger logger= LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
    	logger.info("Not Saved {{}}",err.getMessage());
	}
}
