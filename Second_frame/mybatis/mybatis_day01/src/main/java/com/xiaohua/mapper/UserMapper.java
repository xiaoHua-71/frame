package com.xiaohua.mapper;

import com.xiaohua.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-30 16:06
 **/

public interface UserMapper {
    List<User> selectAll();
    //传入的是形参
    User selectUserOne(int xx);

    User select(@Param("username") String username,@Param("password") String password);
    User selectByMap(Map<String,Object> map);

    /**
     * 模糊查询*
     */
    List<User> selectByUsername(String username);

    /**
     * 插入新增用户*
     * @param user
     * @return
     */

    int insert(User user);

    /**
     * 修改*
     * @param user
     * @return
     */

    int update(User user);

    int delete(int id);

    List<User> selectByUser(User user);


    /**
     * 根据id批量删除用户
     * * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") List<Integer> ids);

    List<User> selectByIds(@Param("ids") List<Integer> ids);

    /**
     * 批量插入*
     * @param users
     * @return
     */
    int batchInsert(@Param("users") List<User> users);

    int batchDeleteByIds(@Param("ids") List<Integer> ids);



}
