package com;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 10:42
 **/

public class ResourceTest {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("jdbc.properties");

        System.out.println(resource.getFilename());
    }
}
