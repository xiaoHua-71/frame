package com.xiaohua.aspecj;

import com.xiaohua.service.IActivityService;
import com.xiaohua.service.impl.ActivityService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MemberSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 17:45
 **/

//这个注解能够将这个类定义成一个切面
@Aspect
@Component
public class MyAspect {

    @DeclareParents(value="com.xiaohua.service.impl.OrderService",defaultImpl= ActivityService.class)
    public static IActivityService iactivityService;

    @Pointcut("execution(public * com.xiaohua.service.impl.*.*(..))")
    private void beforePointcut(){}


    @Before("beforePointcut()")
    private void beforeAdvice(JoinPoint jp) throws InvocationTargetException, IllegalAccessException {
        //拿到方法，也能拿到方法的注解
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        //调用方法的过程
        method.invoke(jp.getTarget(),jp.getArgs());

        System.out.println("this is before advice");
    }


    @AfterReturning("execution(public * com.xiaohua..order(..))")
    private void afterReturningAdvice(){
        System.out.println("this is before afterReturningAdvice");
    }


    @After("execution(public * com.xiaohua..order(..))")
    private void afterAdvice(){
        System.out.println("this is before afterAdvice");
    }

    @AfterThrowing(value ="execution(public * com.xiaohua..order(..))",throwing = "ex")
    private void afterThrowing(ArithmeticException ex){
        System.out.println("this is afterThrowing");
        System.out.println("------" + ex);

    }

//    @Around("execution(public * com.com.xiaohua..order(..))")
//    private void around(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("this is around");
//        //这里相当于调用了方法
//        Object proceed = pjp.proceed();
//        System.out.println("this is around");
//    }

//    @Before("execution(* com.com.xiaohua.service.impl.OrderService.*(..)) && args(money,..)")
//        public void validateAccount(Integer money){
//        System.out.println("before =====" +money);
//
//
//        }


}
