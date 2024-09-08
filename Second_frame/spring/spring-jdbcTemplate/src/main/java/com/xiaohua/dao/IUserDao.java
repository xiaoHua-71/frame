package com.xiaohua.dao;

import com.xiaohua.dao.impl.UserDao;
import com.xiaohua.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 22:40
 **/
@Repository
public interface IUserDao {
    /**
     * 根据id查询数据*
     * @return
     */

    User selectById();
}
