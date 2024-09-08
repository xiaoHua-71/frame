package com.xiaohua.service.impl;

import com.xiaohua.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 16:23
 **/
@Service
public class UserService implements IUserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public void resister() {
        logger.info("这是注册的方法");
    }
}
