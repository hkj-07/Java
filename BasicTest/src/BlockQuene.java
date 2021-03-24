import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author HKJ
 * @create 2021-03-23
 * 使用阻塞队列
 */
class MyResource {
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.getClass().getName());
        this.blockingQueue = blockingQueue;
    }

    public void myProd() throws Exception {
        String data = null;
        boolean resValue;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            resValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (resValue) {
                System.out.println(Thread.currentThread().getName() + "生产蛋糕成功" + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "生产蛋糕失败" + data);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "生产结束");
    }

    public void myConsumer() throws Exception {
        String res = null;
        while (flag) {
            res = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (res == null || res.equals("")) {
                flag = false;
                System.out.println("超过2秒没有拿到蛋糕，自动退出");
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "拿到蛋糕" + res);
        }
    }

    public synchronized void setFlag() {
        this.flag = false;
    }
}

public class BlockQuene {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(5));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "生产线程开始执行");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Producer").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "消费线程开始执行");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println();
        System.out.println();
        myResource.setFlag();
    }
}