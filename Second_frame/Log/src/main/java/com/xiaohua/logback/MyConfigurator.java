package com.xiaohua.logback;

import java.io.File;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-26 17:21
 **/

//public class MyConfigurator extends ContextAwareBase implements Configurator {
//
//    public MyConfigurator() {
//    }
//
//    public void configure(LoggerContext lc) {
//        addInfo("Setting up default configuration.");
//
//        ConsoleAppender<ILoggingEvent> ca = new ConsoleAppender<ILoggingEvent>();
//        ca.setContext(lc);
//        ca.setName("console");
//        LayoutWrappingEncoder<ILoggingEvent> encoder = new LayoutWrappingEncoder<ILoggingEvent>();
//        encoder.setContext(lc);
//
//
//
//        //rollingAppender
//
//        //构造一个FileAppender
//        FileAppender<ILoggingEvent> fa = new FileAppender<>();
//        fa.setContext(lc);
//        fa.setName("file");
//        fa.setFile("E:\\AAAJavaRoute\\Second_frame\\logback.log");
//        //构建一个FileEncoder
//        PatternLayoutEncoder ple = new PatternLayoutEncoder();
//        ple.setContext(lc);
//        ple.setPattern("%d{HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n");
//        fa.setEncoder(ple);
//        ple.start();
//        fa.start();
//
//
//        // same as
//         PatternLayout layout = new PatternLayout();
//         layout.setPattern("%d{HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n");
////        TTLLLayout layout = new TTLLLayout();
//
//        layout.setContext(lc);
//        layout.start();
//        encoder.setLayout(layout);
//
//        ca.setEncoder(encoder);
//        ca.start();
//
//        Logger rootLogger = lc.getLogger(Logger.ROOT_LOGGER_NAME);
//        rootLogger.addAppender(ca);
//        rootLogger.addAppender(fa);
//    }

//}
