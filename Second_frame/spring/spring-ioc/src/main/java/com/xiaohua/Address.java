package com.xiaohua;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-04 11:50
 **/

public class Address implements InitializingBean, DisposableBean {

    private String name;



    public void setName(String name) {
        System.out.println("set name");
        this.name = name;
    }

    public Address() {
        System.out.println("add is init");
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
