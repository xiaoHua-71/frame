package com.xiaohua.client;

import com.xiaohua.spring.api.ApplicationContext;
import com.xiaohua.spring.api.ApplicationContextAware;
import com.xiaohua.spring.api.impl.ClassPathXmlApplicationContext;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 12:47
 **/

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.properties");
        Object d = applicationContext.getBean("d");
        System.out.println(d);
    }
}
