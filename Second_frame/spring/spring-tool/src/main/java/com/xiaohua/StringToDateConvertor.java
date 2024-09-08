package com.xiaohua;

import org.springframework.core.convert.converter.Converter;

import javax.management.relation.RoleInfoNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-06 11:45
 **/

public class StringToDateConvertor implements Converter<String, Date> {


    @Override
    public Date convert(String s) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期类型转化失败");
        }
    }
}
