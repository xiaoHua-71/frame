package com.xiaohua.slf4j;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-26 15:36
 **/

public class JUL {
    public void log(){
        System.out.println("log");

    }

    public static void main(String[] args) {
        Slf4j slf4j = new Slf_JUL();
        slf4j.myLog();
    }
}
