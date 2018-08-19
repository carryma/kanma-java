package com.kanma.concurrency;

/**
 * @ Desc   ：理解线程类的创建,执行等
 * 线程Thread1不涉及资源共享,创建的每一个线程对象都有自己独立的运行栈和程序计数器PC
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/19 2:09
 */
public class Thread1 extends Thread {
    private String name;

    Thread1(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 1; i < 5; i++) {
            System.out.println("子线程" + name + "运行 : " + i);
            try {
                sleep((int) Math.random() * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }

}
