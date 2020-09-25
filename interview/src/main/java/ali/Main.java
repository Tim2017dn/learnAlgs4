package ali;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 顺序递增打印正整数，从1开始打印到100，中间换行分隔。不允许重复打印出相同的数字，比如打印结果里出现2个5，3个6之类的。
 *
 * 要求如下：
 * 1、使用三个线程A、B、C，其中线程A打印3的倍数，B打印5的倍数，C打印其他数字。
 * 2、不使用IDE，直接在页面作答。
 * 3、允许有不影响代码设计上的小的编译错误
 * 以你自己最高水准来编写代码，包括不限使用合理的设计，命名，换行等
 */


public class Main{


    static int cur =0;

    static ReentrantLock t= new ReentrantLock();

    public static void main(String[] args){

        Thread A =  new Thread(()->{

            for(int i=1;i<100;i++){
                print3(i);
            }
        },"A");
        A.start();


        Thread B = new Thread( () -> {
            for(int i=1;i<100;i++){
                print5(i);
            }

        },"B");
        B.start();



        Thread C =new Thread( () -> {

            for(int i=1;i<100;i++){
                printOther(i);
            }

        },"C");
        C.start();

    }



    public static void print3(int i){

            if(i%3==0){
                while(true){
                t.lock();
                if(cur == i-1){
                    System.out.println(i);
                    cur++;
                    t.unlock();
                    break;
                }else{
                    t.unlock();
                    if(cur==i-1){
                        break;
                    }
                }

            }
        }

    }

    public static void print5(int i){

            if (i % 5 == 0) {
                while(true) {
                t.lock();
                if (cur == i - 1) {
                    System.out.println(i);
                    cur++;
                    t.unlock();
                    break;
                }else{
                    t.unlock();
                    if(cur==i-1){
                        break;
                    }

                }

            }
        }
    }


    public static void printOther(int i){


            if ((i % 3 != 0) && (i % 5 != 0)) {
                while(true) {
                t.lock();
                if (cur == i - 1) {
                    System.out.println(i);
                    cur++;
                    t.unlock();
                    break;
                }else{
                    t.unlock();
                }


            }
        }
    }





}