package com.xiaohua;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-04 13:04
 **/

public class A implements InitializingBean, DisposableBean {
    private B b;

    public A() {
    }

    public A(B b) {
        this.b = b;
    }

    public void setB(B b) {
        this.b = b;
    }


    public void init1(){
        System.out.println("xml init!");

    }

    public void destroy1(){
        System.out.println("xml destroy!");

    }
    @PostConstruct
    public void init2(){
        System.out.println("annotation init!");

    }
    @PreDestroy
    public void destroy2(){
        System.out.println("annotation destroy!");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");

    }
}
