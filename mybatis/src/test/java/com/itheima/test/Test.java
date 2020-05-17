package com.itheima.test;

import java.util.*;

/**
 * @author ouyangjie
 * @createTime 2020-03-18 15:10
 */
public class Test {
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<10;i++){
            int r=(int)(Math.random()*100+1);
            System.out.print(r+",\t");
            set.add(r);
        }
        List<Integer> list=change(set);
        Collections.sort(list);
        for(int j=0;j<list.size();j++){
            System.out.print(list.get(j)+",");
        }
        System.out.println("answer:"+list.get(2));
    }

    public static List<Integer> change(Set set){
        List<Integer> list=new ArrayList<>();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
           list.add(i);
        }
        System.out.println(list.size());
        return list;
    }
}
