package com.xiaohua;

import com.xiaohua.config.AppConfig;
import com.xiaohua.service.IActivityService;
import com.xiaohua.service.IOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 16:31
 **/

public class AppByXml {
    public static void main(String[] args) {
        //启动容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
        IOrderService bean = ctx.getBean(IOrderService.class);
        bean.order(100);


    }
}
