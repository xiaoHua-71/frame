package com.xiaohua.client;

import com.xiaohua.spring.api.ApplicationContext;
import com.xiaohua.spring.api.ApplicationContextAware;
import com.xiaohua.spring.api.BeanFactoryPostProcessor;
import com.xiaohua.spring.api.BeanPostProcessor;
import com.xiaohua.spring.api.impl.ClassPathXmlApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 12:43
 **/

public class D implements ApplicationContextAware, BeanFactoryPostProcessor, BeanPostProcessor {


    public D() {
        System.out.println(" d is created");
    }

    @Override
    public void BeanFactoryPostProcessor(ConcurrentHashMap beanFactory) {
        System.out.println(beanFactory +"-----------BeanFactoryPostProcessor");
    }

    @Override
    public void beforeInitialization(Object bean) {
        System.out.println(bean+"-----------beforeInitialization");
    }

    @Override
    public void afterInitialization(Object bean) {
        System.out.println(bean+"-----------afterInitialization");

    }

    @Override
    public void setApplicationContextAware(ClassPathXmlApplicationContext classPathXmlApplicationContext) {
        System.out.println(classPathXmlApplicationContext+"-----------applicationContext");
    }
}
