package com.xiaohua.jul;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-24 08:59
 **/

public class JulTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("MyLogger");
        logger.info("信息");
        logger.warning("警告信息");
        logger.severe("严重信息");
    }

    @Test
    public void TestLogConfig() throws IOException {
        //创建日志对象
        Logger logger = Logger.getLogger("myLogger");
        //自定义日志级别
        //a，关闭系统默认配置
        logger.setUseParentHandlers(false);
        //b创建Handler对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //c创建formatter对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        //d进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);
        //e设置日志级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        //二输出到日志文件
        FileHandler fileHandler = new FileHandler("E:\\AAAJavaRoute\\Second_frame\\logs\\jul.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
        // 2.日志记录输出
        logger.severe("严重信息");
        logger.warning("警告信息");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");


    }

    @Test
    public void readConfig() throws IOException {
        LogManager manager = LogManager.getLogManager();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("logging.properties");
        manager.readConfiguration(in);

        Logger logger = Logger.getLogger(JulTest.class.getName());
        logger.finest("fine");
        logger.warning("is warning");

        try {
            int i = 1/0;

        }catch (ArithmeticException e){
            logger.throwing(JulTest.class.getName(),"readConfig",e);
        }


    }
}
