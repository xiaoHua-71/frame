package com.xiaohua.env;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.PropertySource;

import java.lang.annotation.Annotation;
import java.util.Properties;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 20:50
 **/

public class MyPropertySource extends PropertySource {

    private Properties properties = new Properties();

    public MyPropertySource(String name) {
        super(name);
        properties.put("hello","properties");
    }

    @Override
    public Object getProperty(String name) {
        return properties.get(name);
    }
}
