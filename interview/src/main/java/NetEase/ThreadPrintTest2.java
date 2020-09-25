package NetEase;/*
顺序递增打印正整数，从1开始打印到100，中间换行分隔。不允许重复打印出相同的数字，比如打印结果里出现2个5，3个6之类的。
要求如下：
1、使用三个线程A、B、C，其中线程A打印3的倍数，B打印5的倍数，C打印其他数字。
 */

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 方法二
 */

public class ThreadPrintTest2 {

    // 计数
    static final AtomicInteger n = new AtomicInteger(1);

    // 信号量
    static Semaphore semaphore3 = new Semaphore(1);
    static Semaphore semaphore5 = new Semaphore(0);
    static Semaphore semaphoreOther = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> {
           while (true) {

               int current = n.get();
               System.out.println(current);
               if (current > 100) {
                   break;
               }
                semaphore3.acquireUninterruptibly();
//               if (current % 3 == 0) {
//                   System.out.println(current + "  by " + Thread.currentThread().getName());
                   n.getAndIncrement();
//               }
               semaphore5.release();
           }
        }, "Thread A").start();

        new Thread(() -> {
            while (true) {
                int current = n.get();
                System.out.println(current);
                if (current > 100) {
                    break;
                }
                semaphore5.acquireUninterruptibly();
//                if (current % 5 == 0) {
//                    System.out.println(current + "  by " + Thread.currentThread().getName());
                    n.getAndIncrement();
//                }
                semaphoreOther.release();
            }
        }, "Thread B").start();

        new Thread(() -> {
            while (true) {
                int current = n.get();
                System.out.println(current);
                if (current > 100) {
                    break;
                }
                semaphoreOther.acquireUninterruptibly();
//                if (current % 3 != 0 && current % 5 != 0) {
//                    System.out.println(current + "  by " + Thread.currentThread().getName());
                    n.getAndIncrement();
//                }
                semaphore3.release();
            }
        }, "Thread C").start();


        Thread t =new Thread();
    }

}
