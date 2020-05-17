package com.itheima.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyangjie
 * @createTime 2020-03-25 16:16
 */
public class TestA {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("0");
        list.add("1");
        executeObj(list);
        list.add("2");
        System.out.println(list);
        String num = "10";
        executeInt(num);
        System.out.println(num);
    }

    private static void executeObj(List<String> list){
        list.add("end");
    }

    private static void executeInt(String num){
        num = "100";
    }
}
