package com.mysql;

import com.xiaohua.Driver;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-26 17:39
 **/

public class MysqlDriver implements Driver {
    @Override
    public void gerConnection() {
        System.out.println("this is mysql");
    }
}
