package com.xiaohua.dao.impl;

import com.xiaohua.dao.IUserDao;
import com.xiaohua.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 22:40
 **/
@Repository
public class UserDao implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User selectById() {


        jdbcTemplate.query("select * from user where id = ?", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                while (rs.next()){
                    rs.getString("user_name");
                    rs.getString("password");

                }
            }
        }, 1);
        return null;
    }
}
