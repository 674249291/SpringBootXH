package com.xj.xs.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiong on 2018/3/5.
 */
public class Demo1 {

    public static void main(String[] args) {
        //map的遍历 有以下4中形式来遍历
        Map<String, String> map = new HashMap<String, String>();
        map.put("a","xiong");
        map.put("b", "jun");
        //第一种，使用iterator来实现
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //第二种，使用 Set<Integer> set = map.keySet(); 得到所有key的集合
        Set<String> set = map.keySet();
        for (String str : set){
            System.out.println(str + ":" + map.get(str));
        }
        //第三种，推荐，尤其是容量大时
        for (Map.Entry<String,String> entry :map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //第四，通过Map.values()遍历所有的value，但不能遍历key
        for (String value : map.values()){
            System.out.println("value " + ": " + value);
        }
    }
}

