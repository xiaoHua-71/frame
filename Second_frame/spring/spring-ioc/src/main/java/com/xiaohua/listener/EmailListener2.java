package com.xiaohua.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 21:55
 **/
@Component
public class EmailListener2  {
    @EventListener
    public void sendEmail(OrderEvent event) {
        System.out.println("给" + ((Order)event.getSource()).getUsername() + "发Email，他的订单是" + ((Order)event.getSource()).getOrderId());
    }
}
