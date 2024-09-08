package com.xiaohua.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 16:37
 **/
public class ProxyBeanPostProc implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //后置处理器
        Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");
                        try {
                            Object invoke = method.invoke(bean, args);
                            System.out.println("提交事务");
                            return invoke;
                        } catch (RuntimeException runtimeException) {
                            System.out.println("进行回滚");
                            throw new RuntimeException("出现异常了");
                        }
                    }
                });

        return proxy;
    }
}
