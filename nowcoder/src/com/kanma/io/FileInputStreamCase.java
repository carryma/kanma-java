package com.kanma.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Desc   ：FileInputStream, FileOutputStream学习
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/29 22:21
 */
public class FileInputStreamCase {

    private static String readTxtFile(String filePath) throws IOException {
        /*
        * 1. 首先获得一个文件句柄。File file = new File(); file即为文件句柄。
        *    两人之间连通电话网络了。接下来可以开始打电话了。
        * 2. 通过这条线路读取甲方的信息：new FileInputStream(file) 目前这个信息已经读进来内存当中了。
        *    接下来需要解读成乙方可以理解的东西
        * 3. 既然你使用了FileInputStream()。那么对应的需要使用InputStreamReader()
        *    这个方法进行解读刚才装进来内存当中的数据
        * 4. 解读完成后要输出呀。那当然要转换成IO可以识别的数据呀。那就需要调用字节码读取的方法BufferedReader()。
        *    同时使用bufferedReader()的readline()方法读取txt文件中的每一行数据哈。
        * */
        File file = new File(filePath);
        //java IO 是以流为基础进行的
        //将读取的内容放入 流 中(内存中)
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bReader = new BufferedReader(isr);
        String line = null;
        //StringBuffer是线程安全的,StringBuil是线程不安全的,但是在单线程环境下效率高
        StringBuilder sb = new StringBuilder();
        while ((line = bReader.readLine()) != null) {
            //System.out.println(strInTxt);
            //sb.append(line + "\n");
            sb.append(line);
        }
        return sb.toString();
    }

    private static void outputWordAndCounts(String text) {
//        String[] words = text.split("[a-zA-Z]+");
        //把字符串中所有标点(, .)替换成空格字符
        String temp = text.replaceAll("\\pP", " ");
        //按照单个或者连续多个空格把字符串分割成纯单词数组
        String[] words = temp.trim().split(" +");
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (String key : map.keySet()) {
            if (key != null) {
                System.out.println(key + " " + map.get(key));
            }
        }
        // System.out.println(map.keySet() + ":" + map.values());
    }

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Projects\\kanma-java\\b.txt";
        String outStrings = readTxtFile(filePath);
        System.out.println(outStrings);
        outputWordAndCounts(outStrings);
    }
}
