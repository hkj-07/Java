import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/*
@author :HKJ
@time:2021.3.24
线程使用测试
 */
//第一种方法，继承线程类Thread
class MyThread01 extends Thread{
    public MyThread01(String name){
        super(name);
    }
    @Override
    public  void run(){
        System.out.println(Thread.currentThread().getName()+",开始干活");
        System.out.println("Hello world");
    }
}
class MyThread02 implements Callable<String> {

    @Override
    public String call() throws Exception {

        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + ", 开始工作");
        return "Hello, World!";
    }
}
class MyThread03 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ", 开始工作");
        System.out.println("Hello, World!");
    }
}


public class ThreadTest{
    public static void main(String[] args){

        MyThread01 myThread = new MyThread01("AAA");//实例化线程，创建线程对象
        myThread.start();
        Instant inst1 = Instant.now();  //当前的时间
        FutureTask<String> futureTask = new FutureTask<>(new MyThread02());
        Thread t1 = new Thread(futureTask, "BBB");
        t1.start();
        Instant inst2 = Instant.now();  //当前的时间
        System.out.println(Duration.between(inst1, inst2).getSeconds());
//        //会被阻塞，而且futureTask只能被执行一次，因为执行完一次后，会被标识为完成。
//        String str = futureTask.get();
//        System.out.println(str);
//        new Thread(new MyThread03(),"CCC").start();
    }

}
