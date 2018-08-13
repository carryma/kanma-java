package com.kanma.reflects;

/**
 * @ Desc   ：在运行时获取对象完整的包名和类名
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/13 23:16
 */
public class ReflectTest1 {
    public static void main(String[] args) {
        //ReflectTest1 reflectTest1 = new ReflectTest1();
        //System.out.println(reflectTest1.getClass().getName());
        System.out.println(ReflectTest1.class.getName());
        //result: com.kanma.reflects.ReflectTest1
    }
}
