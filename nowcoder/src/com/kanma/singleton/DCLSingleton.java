package com.kanma.singleton;

/**
 * @ Desc   ：双检锁单例模式
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/24 13:25
 */
public class DCLSingleton {
    //1.私有的构造函数
    private DCLSingleton() {
    }

    //2.当前类永远持有同一个对象的引用
    private static volatile DCLSingleton instance;

    //3.通过当前类提供的静态方法发布出去
    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
