//package com.mk.testforfunction.volatiles;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author MengKai
 * @create 2020-04-20
 */

/**
 * volatile具有可见性，
 * 不保证原子性、
 * 1.可以使用synchronized加锁，保证
 * 2.使用JUC包下的原子类atomic
 */

class MyData {

    volatile int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addTo60() {
        //验证volatile的可见性
        this.number = 60;
    }

    public void addPlusPlus() {
        //验证volatile的不能保证原子性
        this.number++;
    }

    public void addMyAtomic() {
        atomicInteger.getAndIncrement();
    }
}

public class VolatileTest {
    private boolean flag = true;
    public static void main(String[] args) {
        //验证volatile的可见性
                seeOKByVolatile();
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {

            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }
        //等待其他线程运行完
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " finally number value：" + myData.number);
        System.out.println(Thread.currentThread().getName() + " finally number value：" + myData.atomicInteger.get());
    }

    private static void seeOKByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "执行开始" + myData.number);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "执行结束" + myData.number);
        }, "AAA").start();

        System.out.println(Thread.currentThread().getName() + "执行开始");
        while (myData.number == 0) {
            //循环等待
        }
        System.out.println(Thread.currentThread().getName() + "执行结束 " + myData.number);
    }
}