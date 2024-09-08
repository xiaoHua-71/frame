package com.xiaohua;

import com.xiaohua.config.AppConfig;
import com.xiaohua.service.IActivityService;
import com.xiaohua.service.IOrderService;
import com.xiaohua.service.IUserService;
import com.xiaohua.service.impl.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 16:31
 **/

public class App {
    public static void main(String[] args) {
        //启动容器
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        IOrderService iOrderService =  context.getBean(IOrderService.class);
//        IUserService iUserService =  context.getBean(IUserService.class);
        iOrderService.order(10000);
        IActivityService activityService = context.getBean(IActivityService.class);
        activityService.sendGift();


    }
}
