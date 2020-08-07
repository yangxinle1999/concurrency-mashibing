package yxxy.c_026;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//WorkStealingPool：是工作窃取线程池，每一个线程都维护自己的一个队列，
// 每个队列都积累各自的任务，当一个线程的队列任务执行完之后，会主动去别的线程的任务队列中找任务干。
// WorkStealingPool中的线程都是精灵线程(守护线程、后台线程)，主线程结束之后，他可能不会结束。
// 他的底层是ForkJoinPool。
public class T11_WorkStealingPool {
    public static void main(String[] args) throws IOException {
        ExecutorService service= Executors.newWorkStealingPool();

        System.out.println(Runtime.getRuntime().availableProcessors());

        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));

        //由于产生的精灵线程(守护线程、后台线程)，主线程不阻塞的话，看不到输出
        System.in.read();
    }

    static class R implements Runnable{

        int time;

        R(int t){
            this.time=t;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(time+" "+Thread.currentThread().getName());
        }
    }
}
