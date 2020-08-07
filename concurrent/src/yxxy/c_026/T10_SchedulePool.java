package yxxy.c_026;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//任务放到了DelayedWorkQueue队列中，我们知道DelayedWorkQueue队列在放入任务是排好顺序的，
// 最先到期的任务放在最前面，线程最早调用，且线程池中的线程可以重复使用。
public class T10_SchedulePool {
    public static void main(String[] args) {
        ScheduledExecutorService service= Executors.newScheduledThreadPool(4);
        service.scheduleAtFixedRate(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        },0,500,TimeUnit.MILLISECONDS);
    }
}
