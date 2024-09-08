package com.xiaohua;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-03 23:17
 **/
//这是一个UserService工厂，有两个不同的方法
public class UserService {
    private UserDao userDao;
    private AddressDao addressDao;

    public UserService() {
    }
    //通过构造器进行注入
    public UserService(UserDao userDao, AddressDao addressDao) {
        this.userDao = userDao;
        this.addressDao = addressDao;
    }
    //通过setter方法进行注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public static final UserService userService = new UserService();

    //静态方法
    public static UserService create(){
        return new UserService();
    }
    //实例方法
    public  UserDao create2(){
        return new UserDao();
    }
}
