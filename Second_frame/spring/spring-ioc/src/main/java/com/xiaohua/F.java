package com.xiaohua;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 21:38
 **/

public class F {
    @Value("${basePath}")
    private String basePath;

    @Override
    public String toString() {
        return "F{" +
                "basePath='" + basePath + '\'' +
                '}';
    }
}
