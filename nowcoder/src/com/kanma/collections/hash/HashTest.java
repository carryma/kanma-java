package com.kanma.collections.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Desc   ：测试hash函数(hash算法)
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/15 23:49
 */
public class HashTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Aa","I am Aa");
        map.put("BB","I am BB");
        System.out.println(map.get("Aa"));
        System.out.println(map.get("BB"));
//        String str = "Aa";
//        String str1 = "BB";
//        System.out.println(str+" 的哈希码是:" + str.hashCode());
//        System.out.println(str1+" 的哈希码是:" + str1.hashCode());

    }

}
