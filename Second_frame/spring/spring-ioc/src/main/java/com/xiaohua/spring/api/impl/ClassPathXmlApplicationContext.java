package com.xiaohua.spring.api.impl;

import com.xiaohua.client.D;
import com.xiaohua.spring.api.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 10:02
 **/

public class ClassPathXmlApplicationContext implements ApplicationContext {

    public ConcurrentHashMap<String,Object> beansFactory;
    public ConcurrentHashMap<String, BeanFactoryPostProcessor> beansFactoryPostProcessor = new ConcurrentHashMap<>(64);
    public ConcurrentHashMap<String, BeanPostProcessor> beansPostProcessor = new ConcurrentHashMap<>(64);;
    public Map<Object, Object> beanDefinition = new ConcurrentHashMap<Object, Object>();


    public ClassPathXmlApplicationContext(String config) {
        InputStream inputStream = reaXml(config);
        Properties properties = new Properties();
        try {
            //加载bean的定义
            properties.load(inputStream);
            beanDefinition.putAll(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //刷新工厂
        refresh();
    }

    private void refresh() {
        //1准备环境
        prepareRefresh();
        //2创建门面
        beansFactory = new ConcurrentHashMap<>(64);

        //3准备工作
        prepareBeanFactory(beansFactory);

        try {
            // Allows post-processing of the bean factory in context subclasses.
            postProcessBeanFactory(beansFactory);

            // bean工厂已经基本好了，后置处理器
            invokeBeanFactoryPostProcessors(beansFactory);

            // Register All bean processors
            registerBeanPostProcessors(beansFactory);

            // 完成实例化
            finishBeanFactoryInitialization(beansFactory);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    private void finishBeanFactoryInitialization(ConcurrentHashMap<String, Object> beansFactory) {

       for (Map.Entry<Object, Object> entry: beanDefinition.entrySet()){
           String className = (String) entry.getValue();
           Constructor<?> declaredConstructor = null;
           try {

               //创建
               Class<?> aClass = Class.forName(className);
               declaredConstructor =aClass.getDeclaredConstructor();
               Object bean = declaredConstructor.newInstance();
               //2、依赖注入、属性填充

               //3、init
               if (bean instanceof ApplicationContextAware){
                   ApplicationContextAware applicationContextAware = (ApplicationContextAware)bean;
                   applicationContextAware.setApplicationContextAware(this);

               }

               for (Map.Entry<String , BeanPostProcessor> entry1:beansPostProcessor.entrySet()){
                   entry1.getValue().beforeInitialization(bean);
               }

               //beforeInit

               if (bean instanceof Init){
                   Init init = (Init)bean;
                   init.init();

               }
               //afterInit

               for (Map.Entry<String , BeanPostProcessor> entry1:beansPostProcessor.entrySet()){
                   entry1.getValue().afterInitialization(bean);
               }

               //4、销毁

               beansFactory.put((String) entry.getKey(),bean);
           } catch (NoSuchMethodException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           } catch (InvocationTargetException e) {
               e.printStackTrace();
           } catch (InstantiationException e) {
               e.printStackTrace();
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           }

       }

    }

    private void registerBeanPostProcessors(ConcurrentHashMap<String, Object> beansFactory) {
        beansPostProcessor.put("d",new D());
    }

    private void invokeBeanFactoryPostProcessors(ConcurrentHashMap<String, Object> beansFactory) {

        //1找到所有的BeanFactoryPostProcessors
        for (Map.Entry<String,BeanFactoryPostProcessor> entry:beansFactoryPostProcessor.entrySet()){
            entry.getValue().BeanFactoryPostProcessor(beansFactory);

        }
        //2调用方法
    }

    private void postProcessBeanFactory(ConcurrentHashMap<String, Object> beansFactory) {
        beansPostProcessor.put("d",new D());


    }
    private void prepareBeanFactory(ConcurrentHashMap<String, Object> beansFactory) {
        beansFactoryPostProcessor.put("c",new ConfigBeanFactoryPostProcessor());
    }

    private void prepareRefresh() {
        System.out.println("对环境进行一些检查，日志的配置，看看是不是适合买蛋糕");
    }


    @Override
    public Object getBean(String name) {
        return beansFactory.get(name);
    }

    @Override
    public InputStream reaXml(String config) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(config);
    }
}
