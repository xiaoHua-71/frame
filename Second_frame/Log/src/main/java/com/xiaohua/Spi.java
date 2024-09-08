package com.xiaohua;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-26 17:33
 **/

public class Spi {
    public static void main(String[] args) {
        ServiceLoader<Driver> load = ServiceLoader.load(Driver.class);
        //获取查找到的第一个driver。实例
        Optional<Driver> first = load.findFirst();
        //如果找到了就调用getConnection方法
        first.ifPresent(Driver::gerConnection);
    }
}
