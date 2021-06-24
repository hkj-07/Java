package SynchronizedTest;
/**
 *@Author Hkj
 *@Date 2021/5/25
 * Sychronized关键字测试
 */
//@Slf4j
//@Logger
public class SychronizedTest {

    public synchronized void fun1Syn() throws InterruptedException {
        System.out.println("加锁普通方法1开始执行");
        Thread.sleep(10000);
        System.out.println("加锁普通方法1执行成功");
    }
    public synchronized void fun2Syn() throws InterruptedException {
        System.out.println("加锁普通方法2开始执行");
        Thread.sleep(10000);
        System.out.println("加锁普通方法2执行成功");
    }
    public synchronized static void fun3SynStatic() throws InterruptedException {
        System.out.println("加锁静态方法3开始执行");
        System.out.println(Thread.currentThread()+"得到锁");
        Thread.sleep(2000);
        System.out.println("加锁静态方法3执行成功");
    }
    public synchronized static void fun4SynStatic() throws InterruptedException {
        System.out.println("加锁静态方法4开始执行");
        System.out.println(Thread.currentThread()+"得到锁");
        Thread.sleep(2000);
        System.out.println("加锁静态方法4执行成功");
    }
    private static SychronizedTest objStaticTest=new SychronizedTest();
    //测试偏向锁
    static A l=new A();

    public static void main(String[] args){

        SychronizedTest obj1=new SychronizedTest();
        SychronizedTest obj2=new SychronizedTest();
        
        //偏向锁
//        log.debug("线程还未启动----无锁");
        /**两个线程同时调用同一个对象的不同普通锁方法块
         *同一个对象在两个线程中访问该对象的两个同步实例方法，
         *是顺序执行，因为锁针对的是对象，同一个对象，
         */
//        new Thread(()->{
//            try {
//                obj1.fun1Syn();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            try {
//                obj1.fun2Syn();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
        /**
         * 两个不同对象分别在两个线程中调用同一个实例方法
         * 同步执行，因为普通方法锁针对的是对象，不同对象不公用非静态锁
         */
//        new Thread(()->{
//           try{
//               obj1.fun1Syn();
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }
//        }).start();
//        new Thread(()->{
//            try{
//                obj2.fun1Syn();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
        /**
         * 同一个对象在两个线程访问该对象的两个不同的静态方法
         * 产生互斥
         * 静态方法的加锁，实际是对类加锁，类中的静态方法共用一个锁
         */
//        new Thread(()->{
//            try {
//
//                SychronizedTest.fun3SynStatic();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            try {
//
//                SychronizedTest.fun4SynStatic();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
        /**
         * 用类的静态对象在两个线程中调用同步静态方法
         * 产生互斥
         * 与上一个本质相同，本质上还是对类的加锁
         */
//        new Thread(()->{
//            try {
//                objStaticTest.fun3SynStatic();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            try {
//                objStaticTest.fun4SynStatic();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
        /**
         * 一个对象在两个线程分别调用静态方法和静态方法
         * 不互斥
         * 虽然是一个对象调用，但是两个方法的锁类型不同，调用静态方法实际上是对类对象在调用，
         * 而调用实例方法实际上是对实例对象在调用。因为这两个方法并不是一个对象锁，因为不会互斥，会并发执行
         */
        new Thread(()->{
            try {
                objStaticTest.fun1Syn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                objStaticTest.fun4SynStatic();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
class  A{}
