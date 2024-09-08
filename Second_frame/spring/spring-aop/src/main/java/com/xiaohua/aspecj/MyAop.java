package com.xiaohua.aspecj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-07 13:54
 **/

public class MyAop {

//    @Pointcut("execution(public * com.com.xiaohua.service.impl.*.*(..))")
//    private void beforePointcut(){}
//
//
//    @Before("beforePointcut()")
//    private void beforeAdvice(JoinPoint jp) throws InvocationTargetException, IllegalAccessException {
//        //拿到方法，也能拿到方法的注解
//        MethodSignature signature = (MethodSignature) jp.getSignature();
//        Method method = signature.getMethod();
//        //调用方法的过程
//        method.invoke(jp.getTarget(),jp.getArgs());
//
//        System.out.println("this is before advice");
//    }
//
//
//    @AfterReturning("execution(public * com.com.xiaohua..order(..))")
//    private void afterReturningAdvice(){
//        System.out.println("this is before afterReturningAdvice");
//    }
//
//
//    @After("execution(public * com.com.xiaohua..order(..))")
//    private void afterAdvice(){
//        System.out.println("this is before afterAdvice");
//    }
//
//    @AfterThrowing(value ="execution(public * com.com.xiaohua..order(..))",throwing = "ex")
//    private void afterThrowing(ArithmeticException ex){
//        System.out.println("this is afterThrowing");
//        System.out.println("------" + ex);
//
//    }

    @Around("execution(public * com.com.xiaohua..order(..))")
    private void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("this is around1");
        //这里相当于调用了方法
        Object proceed = pjp.proceed();
        System.out.println("this is around2");
    }

}
