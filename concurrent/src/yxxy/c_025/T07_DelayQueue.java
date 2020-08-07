package yxxy.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

//无界计时队列
public class T07_DelayQueue {
    static BlockingQueue<MyTask> tasks=new DelayQueue<>();

    static class MyTask implements Delayed{

        long runningTime;

        MyTask(long rt){
            this.runningTime=rt;
        }

        @Override
        public long getDelay(TimeUnit unit) {

            return unit.convert(runningTime-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS)<o.getDelay(TimeUnit.MILLISECONDS)){
                return -1;
            }else if (this.getDelay(TimeUnit.MILLISECONDS)>o.getDelay(TimeUnit.MILLISECONDS)){
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return ""+runningTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now=System.currentTimeMillis();
        MyTask t1=new MyTask(now+1000); //创建任务，表示该任务1s之后可以被消费
        MyTask t2=new MyTask(now+2000); //创建任务，表示该任务2s之后可以被消费
        MyTask t3=new MyTask(now+1500); //创建任务，表示该任务1.5s之后可以被消费
        MyTask t4=new MyTask(now+2500); //创建任务，表示该任务2.5s之后可以被消费
        MyTask t5=new MyTask(now+500); //创建任务，表示该任务0.5s之后可以被消费

        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);
        tasks.put(t5);

        System.out.println(tasks);//[1596696855825, 1596696856325, 1596696856825, 1596696857825, 1596696857325]

        for (int i = 0; i < 5; i++) {
            System.out.println(tasks.take());
            //结果是：
//            1596696855825
//            1596696856325
//            1596696856825
//            1596696857325
//            1596696857825
        }
    }
}
