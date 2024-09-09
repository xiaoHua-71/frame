package com.xiaohua;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-08 16:34
 **/
@Configuration
@EnableTransactionManagement
@ComponentScan("com.xiaohua")
@PropertySource("classpath:jdbc.properties")

public class AppConfig {

    //数据源
    @Bean
    public DataSource  dataSource(@Value("${Name}") String username,
                                  @Value("${password}") String password,
                                  @Value("${url}") String url,
                                  @Value("${driverName}") String driverName
                                  ){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(username);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverName);

        return dataSource;
    }
    @Bean
    public JdbcTemplate  jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
//
//    @Bean
//    public TransactionTemplate transactionTemplate(TransactionManager transactionManager){
//        TransactionTemplate transactionTemplate = new TransactionTemplate();
//        transactionTemplate.setTransactionManager((PlatformTransactionManager) transactionManager);
//        return transactionTemplate;
//    }






}
