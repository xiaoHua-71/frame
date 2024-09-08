package com.xiaohua;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-26 10:25
 **/

public class MyAppender extends AppenderSkeleton {
    @Override
    protected void append(LoggingEvent loggingEvent) {
        //使用jdbc输出
        System.out.println("from myAppender" +loggingEvent.getMessage());
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
