package com.xiaohua.datasource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 20:22
 **/
@Configuration
public class DataSourceConfig {
    @Bean
    @Profile("prod")
    public DataSource ProDataSource(){
        return new ProdDataSource();

    }
    @Bean
    @Profile("dev")
    public DataSource DevDataSource(){
        return new DevDataSource();

    }
}
