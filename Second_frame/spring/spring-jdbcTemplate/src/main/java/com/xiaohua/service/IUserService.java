package com.xiaohua.service;

import com.xiaohua.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User selectById();
}
