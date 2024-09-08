package com.xiaohua;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-04 21:17
 **/

public class C implements BeanNameAware, ApplicationContextAware {

    private String name;

    private ApplicationContext applicationContext;

    public void printName(){
        System.out.println(name);
        System.out.println(applicationContext);

    }

//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        C bean = applicationContext.getBean(C.class);
        System.out.println(bean);
    }
}
