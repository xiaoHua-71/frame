package com.xiaohua.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 16:30
 **/
@Configuration
@ComponentScan("com.xiaohua")
@EnableAspectJAutoProxy
public class AppConfig {
}
