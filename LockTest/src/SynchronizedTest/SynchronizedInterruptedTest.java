package SynchronizedTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HKJ
 * @create 2021-04-04
 */
public class SynchronizedInterruptedTest {
    /**
     * 演示Lock的可中断和不可中断特性
     */
    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        test01();
//        test02();
    }
    public static void test02() throws InterruptedException {
        //验证可中断
        Runnable run = () -> {
            String name = Thread.currentThread().getName();
            boolean tryLock = false;
            try {
                tryLock = lock.tryLock(3, TimeUnit.SECONDS);
                if (tryLock) {
                    System.out.println(name + "获得锁，进入锁执行");
                    Thread.sleep(30000);
                } else {
                    System.out.println(name + "指定时间内没有获得锁，做其他任务");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (tryLock) {
                    lock.unlock();
                    System.out.println(name + "释放锁");
                }
            }
        };
        Thread t1 = new Thread(run);
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(run);
        t2.start();
    }

    public static void test01() throws InterruptedException {
        //验证不可中断
        Runnable run = () -> {
            String name = Thread.currentThread().getName();
            lock.lock();
            try {
                System.out.println(name + "获得锁，进入锁执行");
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(name + "释放锁");
            }
        };
        Thread t1 = new Thread(run);
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(run);
        t2.start();
        System.out.println("停止线程2前");
        t2.interrupt();
        System.out.println("停止线程2后");
        Thread.sleep(1000);
        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }
}