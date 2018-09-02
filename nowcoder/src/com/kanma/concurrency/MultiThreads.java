package com.kanma.concurrency;


/**
 * @ Desc   ：多线程编程:顺序执行三个线程-----子线程的join()方法.
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/9/2 22:37
 */
public class MultiThreads {
    public static void main(String[] args) {
        System.out.println("----Main Thread Start----");
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        Thread t3 = new Thread(new MyThread());
        try {
            t1.start();
            t1.join();//主线程挂起,等待t1执行完毕
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("----Main Thread Start----");
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " start...");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThreadName + " end.");
    }
}
