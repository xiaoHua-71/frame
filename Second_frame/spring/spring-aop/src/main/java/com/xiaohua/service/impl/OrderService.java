package com.xiaohua.service.impl;

import com.xiaohua.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 16:23
 **/
@Service
public class OrderService implements IOrderService {
    Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Override
    public void order(Integer money) {
        logger.info("这是订单的方法");


    }
}
