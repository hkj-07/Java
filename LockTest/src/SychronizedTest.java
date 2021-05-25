/**
 *@Author Hkj
 *@Date 2021/5/25
 * Sychronized关键字测试
 */

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
        Thread.sleep(2000);
        System.out.println("加锁静态方法3开始执行");
    }
    public synchronized static void fun4SynStatic() throws InterruptedException {
        System.out.println("加锁静态方法4开始执行");
        Thread.sleep(2000);
        System.out.println("加锁静态方法4开始执行");
    }
    public static void main(String[] args){
        SychronizedTest obj1=new SychronizedTest();
        SychronizedTest obj2=new SychronizedTest();
        /**两个线程同时调用同一个对象的不同普通锁方法块
         *同一个对象在两个线程中访问该对象的两个同步实例方法，
         *是顺序执行，因为锁针对的是对象，同一个对象，
         */
        new Thread(()->{
            try {
                obj1.fun1Syn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                obj1.fun2Syn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        /**
         * 两个不同对象分别在两个线程中调用同一个实例方法\
         * 同步执行，因为普通方法锁针对的是对象，不同对象有自己的栈
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
    }
}
