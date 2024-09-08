package com.xiaohua;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 21:03
 **/
@Configuration
@PropertySource("classpath:config.properties")
public class MyConfig {

    @Value("${basePath}")
    private String basePath;

    @Override
    public String toString() {
        return "MyConfig{" +
                "basePath='" + basePath + '\'' +
                '}';
    }
}
