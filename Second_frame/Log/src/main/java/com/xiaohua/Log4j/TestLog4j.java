package com.xiaohua.Log4j;

import com.xiaohua.MyAppender;
import com.xiaohua.jul.JulTest;
import org.apache.log4j.*;
import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;

import java.io.PrintWriter;


/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-25 18:25
 **/

public class TestLog4j {

    private static final Logger LOGGER = Logger.getLogger(TestLog4j.class);

    @Test
    public void testLog4j(){
        Logger rootLogger = Logger.getRootLogger();
        //构建一个consoleAppender
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setWriter(new PrintWriter(System.out));
        //需要一个layout
        Layout layout = new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN);
        consoleAppender.setLayout(layout);

        //将日志保存到数据库中
        JDBCAppender jdbcAppender = new JDBCAppender();
        jdbcAppender.setSql("INSERT INTO log(project_name,create_date,level,category,file_name,thread_name,line,all_category,message) values('ydlclass','%d{yyyy-MM-ddHH:mm:ss}','%p','%c','%F','%t','%L','%l','%m')");
        jdbcAppender.setUser("root");
        jdbcAppender.setPassword("root");
        jdbcAppender.setDriver("com.mysql.cj.jdbc.Driver");
        jdbcAppender.setURL("jdbc:mysql://localhost:3306/ydlclass?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");

        rootLogger.addAppender(jdbcAppender);
//        BasicConfigurator.configure();

        LOGGER.info("hello log4j");
        LOGGER.debug("hello debug");

        while (true){
            LOGGER.debug("hello debug");
        }

    }

    @Test
    public void testConfig(){


        LOGGER.info("hello log4j");
        LOGGER.debug("hello debug");


    }

}
