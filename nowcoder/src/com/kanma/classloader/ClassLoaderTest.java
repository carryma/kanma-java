package com.kanma.classloader;

/**
 * @ Desc   ：测试启动类加载器, 扩展类加载器, 系统类加载器
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/15 10:53
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            //熟悉一下System类
            System.out.println(System.getProperty("java.class.path"));
            //加载Testbean,并创建对应的Class对象
            Class loadedClass = Class.forName("com.kanma.classloader.TestBean");
            //获取加载该类的类加载器
            System.out.println(loadedClass.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
