package com.kanma.io;

import java.io.*;

/**
 * @ Desc   ：FileInputStream, FileOutputStream学习
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/29 22:21
 */
public class FileInputStreamCase {
    public static void readTxtFile(String filePath) throws IOException{
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
        String strInTxt = null;
        while((strInTxt = bReader.readLine()) != null) {
            System.out.println(strInTxt);
        }
    }
    public static void main(String[] args) throws IOException {
        //String filePath = "C:\\Users\\kanma\\Desktop\\a.txt";
        String filePath = "D:\\Projects\\IdeaProjects\\kanma-java\\nowcoder\\a.txt";
        //String filePath = "a.txt";
        readTxtFile(filePath);
    }
}
