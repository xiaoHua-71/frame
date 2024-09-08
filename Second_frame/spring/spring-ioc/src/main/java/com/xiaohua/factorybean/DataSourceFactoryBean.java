package com.xiaohua.factorybean;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.FactoryBean;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 18:18
 **/

public class DataSourceFactoryBean implements FactoryBean<Object> {

    @Override
    public DataSource getObject() throws Exception {
        //实例化一个bean交给容器管理，这个创建的过程是复杂的，甚至我们连类都不知道
        Class<?> aClass = Class.forName("com.alibaba.druid.pool.DruidDataSource");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();

        return (DataSource) declaredConstructor.newInstance();
    }

    @Override
    public Class<?> getObjectType() {

        try {
            return Class.forName("com.alibaba.druid.pool.DruidDataSource");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
