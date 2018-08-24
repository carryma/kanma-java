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
        //字符串"Aa"和"BB"的哈希码是相同的
        String str = "Aa";
        String str1 = "BB";
        System.out.println(str + " 的哈希码是:" + str.hashCode());
        System.out.println(str1 + " 的哈希码是:" + str1.hashCode());

        //HashMap如何解决哈冲突的? ===>链表法
        Map<String, String> map = new HashMap<>();
        map.put("Aa", "I am Aa");
        map.put("BB", "I am BB");
        System.out.println("Key:" + str + "  Value:"+map.get("Aa"));
        System.out.println("Key:" + str1 +"  Value:"+ map.get("BB"));
    }
}
