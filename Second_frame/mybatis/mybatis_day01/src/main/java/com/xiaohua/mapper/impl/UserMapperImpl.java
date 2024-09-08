package com.xiaohua.mapper.impl;

import com.xiaohua.entity.User;
import com.xiaohua.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-30 16:08
 **/

//public class UserMapperImpl implements UserMapper {
//    @Override
//    public List<User> selectAll() {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = null;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        //这个对象是核心一个工程的数据库相关的操作都是围绕sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
//
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            //接口的名字当作命名空间
//            List<Object> objects = session.selectList(UserMapper.class.getName() + "."+"selectAll");
//            System.out.println(objects);
//        }
//        return null;
//    }
//
//    @Override
//    public User selectUserOne(int id) {
//        UserMapper userMapper = new UserMapperImpl();
//        userMapper.selectUserOne(1);
//        return null;
//    }
//
////    public static void main(String[] args) {
////        UserMapper userMapper = new UserMapperImpl();
////        userMapper.selectAll();
////    }
//}
