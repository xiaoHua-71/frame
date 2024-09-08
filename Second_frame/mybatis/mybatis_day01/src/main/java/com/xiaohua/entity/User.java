package com.xiaohua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-08-29 22:04
 **/

@Data
//有参构造器
@AllArgsConstructor
//无参构造
@NoArgsConstructor

public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String password;
}
