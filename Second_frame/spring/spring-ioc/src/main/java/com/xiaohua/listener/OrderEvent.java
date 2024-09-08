package com.xiaohua.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 21:51
 **/

public class OrderEvent  extends ApplicationEvent {
    public OrderEvent(Object source) {
        super(source);
    }
}
