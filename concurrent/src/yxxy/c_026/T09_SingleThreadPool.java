package yxxy.c_026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//线程池里面只有一个线程，可以保证任务是按照顺序执行的
public class T09_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service= Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j=i;
            service.execute(()->{
                System.out.println(j+" "+Thread.currentThread().getName());
            });
        }
    }
}

