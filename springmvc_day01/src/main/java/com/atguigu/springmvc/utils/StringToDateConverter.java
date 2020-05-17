package com.atguigu.springmvc.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ouyangjie
 * @createTime 2020-02-27 14:48
 *字符串转日期
 */

public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if(null==source){
            throw new RuntimeException("请传入数据！");
        }
        DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
        try {
           return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换错误！");
        }
    }
}
