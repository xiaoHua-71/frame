package com.xiaohua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-04 21:41
 **/

public class Boy {
    @Resource(name = "dog")
    private Pet pet;
    @Autowired
    private Address address;

    @Autowired
    private Map<String ,Pet> map;



    @Override
    public String toString() {
        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + "-" +entry.getValue());
        }

        return "Boy{" +
                "pet=" + pet +
                ", address=" + address +
                '}';
    }
}
