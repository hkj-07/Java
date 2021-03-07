import java.util.concurrent.*;
/*
线程池使用
 */
public class ThreadPool {
        public static void mainmian(){
            ExecutorService service=new ThreadPoolExecutor(5,10,60L,
                    TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5), Executors.defaultThreadFactory());

            for(int  i=0;i<100;i++){
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("running");
                    }
                });
            }

    }

}
