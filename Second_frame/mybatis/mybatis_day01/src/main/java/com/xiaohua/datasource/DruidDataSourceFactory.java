package com.xiaohua.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-31 14:21
 **/

public class DruidDataSourceFactory implements DataSourceFactory {

    private Properties properties;
    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource druiddataSource = new DruidDataSource();
        druiddataSource.configFromPropety(properties);
        return druiddataSource;
    }
}
