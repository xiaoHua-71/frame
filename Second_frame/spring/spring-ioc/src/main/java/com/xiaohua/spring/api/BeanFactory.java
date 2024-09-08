package com.xiaohua.spring.api;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 10:00
 **/

public interface BeanFactory {

    /**
     * 通过名字获取bean*
     * @param name
     * @return
     */
    Object getBean(String name);
}
