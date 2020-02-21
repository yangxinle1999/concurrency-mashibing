package yxxy.c_026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @create 2020/2/21 10:35
 */
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

