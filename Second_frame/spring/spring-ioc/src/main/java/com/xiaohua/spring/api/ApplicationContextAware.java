package com.xiaohua.spring.api;

import com.xiaohua.spring.api.impl.ClassPathXmlApplicationContext;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 10:00
 **/

public interface ApplicationContextAware {
    void setApplicationContextAware(ClassPathXmlApplicationContext classPathXmlApplicationContext);
}
