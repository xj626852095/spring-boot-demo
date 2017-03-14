package com.example.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.example.annotation.Action;

@Aspect
@Component
public class LogAspect {
	
	@Pointcut("@annotation(com.example.annotation.Action)")
	public void annotationPointCut(){};
	
	@Before("annotationPointCut()")
	public void before(JoinPoint joinPoint){
		MethodSignature signature =  (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println( "获取到拦截的方法名： " + method.getName() );
	}
	
	
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint){
		MethodSignature signature =  (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println( "获取到拦截的信息： " + action.name() );
	}
	
	
	
	
}
