package com.kanma;

import java.util.Scanner;

/**
 * @ Desc   ：简单错误记录
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/11 17:33
 */
public class MainErrorRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String path = sc.next();
            int rowNum = sc.nextInt();
            System.out.println(path + " " + rowNum);
        }
    }
}
