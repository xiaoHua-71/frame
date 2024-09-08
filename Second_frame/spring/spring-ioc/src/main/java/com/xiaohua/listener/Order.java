package com.xiaohua.listener;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 22:05
 **/

public class Order {
    private String OrderId;

    private String username;

    public Order(String orderId, String username) {
        OrderId = orderId;
        this.username = username;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
