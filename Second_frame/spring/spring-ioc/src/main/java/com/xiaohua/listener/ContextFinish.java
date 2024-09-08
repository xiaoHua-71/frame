package com.xiaohua.listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 22:17
 **/
public class ContextFinish {
    @EventListener
    public void load(ContextRefreshedEvent event){
        System.out.println("容器加载完了开始数据预热！");

    }
}
