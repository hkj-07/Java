import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HKJ
 * @create 2020-08-16
 * - sync、wait、notify：原来线程的机制
 * - lock、await、Singal：新的lock机制
 * 传统模式
 */

class Test {
    //ReentrantLock默认非公平锁
    static ReentrantLock reentrantLock = new ReentrantLock(true);
    public static void main(String[] args) {
        Thread t1 = new Thread(Test::testSync , "t1");
        Thread t2 = new Thread(Test::testSync, "t2");
        Thread t3 = new Thread(Test::testSync, "t3");
        Test t=new Test();
        testSync();

        t1.start();
        t2.start();
        t3.start();
    }

    public static void testSync() {
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获得锁");

            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

}
class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() throws Exception {
        lock.lock();
        try {
            //使用while，防止虚假唤醒
            //在多线程得情况下，（两个以上）如果使用if，可能存在虚假唤醒情况，
            //就是唤醒得不是目标线程，而是不满足条件的线程（CAS机制）
            while (number != 0) {
                //等待
                condition.await();
            }
            this.number++;
            System.out.println(Thread.currentThread().getName() + "完成操作" + number);
            condition.signalAll();
//            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
//            condition.signalAll();
        }
    }

    public void decrement() throws Exception {

        lock.lock();
        try {
            //使用while，防止虚假唤醒
            while (number == 0) {
                //等待
                condition.await();
            }
            this.number--;
            System.out.println(Thread.currentThread().getName() + "完成操作" + number);
            condition.signalAll();
//            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
//            condition.signalAll();
        }
    }
}

public class ReentrantLockTest {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AAA").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BBB").start();
    }
}
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HKJ
 * @create 2020-07-29
 * 可重入锁
 */
class Test02 {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(Test02::test01, "t1");
        Thread t2 = new Thread(Test02::test01, "t2");

        t1.start();
        t2.start();
    }

    public static void test01() {
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获得锁，test01");
            test02();
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放锁，test01");
            reentrantLock.unlock();
        }
    }

    public static void test02() {
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获得锁，test02");

            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放锁，test02");
            reentrantLock.unlock();
        }
    }

}