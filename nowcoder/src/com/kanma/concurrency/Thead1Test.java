package com.kanma.concurrency;

/**
 * @ Desc   ：测试线程类Thread1
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/19 2:16
 */
public class Thead1Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
        Thread t1 = new Thread1("A");
        Thread t2 = new Thread1("B");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
        /*
         * Java线程具有五中基本状态
         * (1)新建状态（New）：当线程对象对创建后，即进入了新建状态，如：Thread t = new MyThread();
         * (2)就绪状态（Runnable）：当调用线程对象的start()方法（t.start();），线程即进入就绪状态。
         *                       处于就绪状态的线程，只是说明此线程已经做好了准备，随时等待CPU调度执行，
         *                       并不是说执行了t.start()此线程立即就会执行；
         * (3)运行状态（Running）：当CPU开始调度处于就绪状态的线程时，此时线程才得以真正执行，即进入到运行状态。
         *                      注：就绪状态是进入到运行状态的唯一入口，也就是说，线程要想进入运行状态执行，首先必须处于就绪状态中；
         * (4)阻塞状态（Blocked）：处于运行状态中的线程由于某种原因，暂时放弃对CPU的使用权，停止执行，此时进入阻塞状态，
         *                      直到其进入到就绪状态，才 有机会再次被CPU调用以进入到运行状态。根据阻塞产生的原因不同，阻塞状态又可以分为三种：
         *      1.等待阻塞 -- 运行的线程执行wait()方法，JVM会把该线程放入等待池中(等待队列)。(wait会释放持有的锁)
         *      2.同步阻塞 -- 运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。
         *      3.其他阻塞 -- 运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。
         *                    当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。
         *                    （注意,sleep是不会释放持有的锁）
         * (5)死亡状态（Dead）：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。
         */
    }
}
