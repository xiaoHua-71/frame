package com.xiaohua.spring.api;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 09:58
 **/

public interface BeanPostProcessor {
    void beforeInitialization(Object bean);
    void afterInitialization(Object bean);
}
