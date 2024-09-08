package com.xiaohua.config;

import com.xiaohua.Address;
import com.xiaohua.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ListFactoryBean;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static java.util.List.*;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 16:34
 **/

public class MyConfiguration {

    @Bean
    @Qualifier("addr")
    public Address address(){
        return new Address();
    }

    @Bean
    public User user( @Qualifier("addr") Address address){
        User user = new User();
        user.setAddresses(List.of(address));
        return user;


    }
}
