package com.xiaohua.service.impl;

import com.xiaohua.dao.IUserDao;
import com.xiaohua.dao.impl.UserDao;
import com.xiaohua.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiaohua.service.IUserService;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 22:25
 **/
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public User selectById() {
        return userDao.selectById();
    }
}
