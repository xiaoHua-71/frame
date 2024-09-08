package com.xiaohua;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-05 15:58
 **/
@Configurable
@ComponentScan(value = "com.xiaohua",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes ={A.class, B.class} )
)

public class AppConfig {
}
