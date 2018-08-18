package com.kanma.concurrency;

/**
 * @ Desc   ：Thread_main的实例在本类的main方法中创建,那么String name 是共享的吗??
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/19 2:09
 */
public class Thread1_main extends Thread {
    private String name;

    Thread1_main(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " 主线程运行" + i);
            try {
                sleep((int) Math.random() * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    * 你可以将main函数视为一个特殊的静态函数，当指定使用某个类作为java程序入口时，
    * java将会从这个类的main函数开始执行。* 除此之外它和其他的静态函数没有任何区别，
    * 你可以在其他地方把main函数当一个静态函数去调用，都是没有问题的。
    */

    /*看main()方法的时候,要跳出其所在的类,从JVM的角度去思考main()方法的行为
    * 所以,在main()中创建了线程tt1,tt2对变量String name都是独立一份,不存在共享
    * */
    public static void main(String[] args) {
        Thread tt1 = new Thread1_main("A");
        Thread tt2 = new Thread1_main("B");
        Thread tt3 = new Thread1_main("main_1");
        Thread tt4 = new Thread1_main("main_2");
        tt1.start();
        tt2.start();
        tt3.start();
        tt4.start();
    }

}
