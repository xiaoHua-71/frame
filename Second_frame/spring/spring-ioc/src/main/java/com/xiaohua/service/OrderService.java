package com.xiaohua.service;

import com.xiaohua.listener.Order;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 15:36
 **/

//<bean class="com.com.xiaohua.com.com.xiaohua.service.OrderService"/>
//`@Component` 是任何spring管理组件的通用注解。
@Service
public class OrderService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    public void aaa(){

        Order order = new Order("","");


        applicationEventPublisher.publishEvent(this);

    }
}
