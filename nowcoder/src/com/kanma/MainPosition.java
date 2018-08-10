package com.kanma;

import java.util.Scanner;

/**
 * @ Desc   ：坐标移动
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/11 3:17
 */
public class MainPosition {
    public static void main(String[] args) {
        //java中数组的初始化,要给定大小,用new创建并初始化,数组是在堆上创建的对象
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = 0, y = 0;
            String inputStr = new String(sc.nextLine());
            //以";"为分割标志,将字符串分成字符串数组
            String[] steps = inputStr.split("\\;");
            for (String s : steps) {
                if (s.length() == 3) {
                    if (s.charAt(1) >= '0' && s.charAt(1) <= '9' && s.charAt(2) >= '0' && s.charAt(2) <= '9') {
                        if (s.charAt(0) == 'A') {
                            x -= Integer.parseInt(s.substring(1));
                        }
                        if (s.charAt(0) == 'D') {
                            x += Integer.parseInt(s.substring(1));
                        }
                        if (s.charAt(0) == 'W') {
                            y += Integer.parseInt(s.substring(1));
                        }
                        if (s.charAt(0) == 'S') {
                            y -= Integer.parseInt(s.substring(1));
                        }
                    }
                }
            }
            System.out.println(x + "," + y);
        }

    }
}
