package com.xiaohua.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 16:21
 **/

public interface IOrderService {
    /**
     * 下单*
     */
    void order(Integer money);

}
