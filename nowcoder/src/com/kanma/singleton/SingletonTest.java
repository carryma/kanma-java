package com.kanma.singleton;

/**
 * @ Desc   ：测试双检锁单例的线程安全性
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/24 13:50
 */
public class SingletonTest implements Runnable {
    @Override
    public void run() {
        DCLSingleton myInstance = DCLSingleton.getInstance();
        System.out.println(myInstance);
    }

    public static void main(String[] args) {
        //DCLSingleton的测试
        DCLSingleton myInstance1 = DCLSingleton.getInstance();
        DCLSingleton myInstance2 = DCLSingleton.getInstance();
        System.out.println(myInstance1==myInstance2);
        //多线程
        Thread t1 = new Thread(new SingletonTest());
        Thread t2 = new Thread(new SingletonTest());
        t1.start();
        t2.start();
    }
}
