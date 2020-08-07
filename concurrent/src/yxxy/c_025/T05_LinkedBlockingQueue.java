package yxxy.c_025;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

//无界阻塞队列
public class T05_LinkedBlockingQueue {
    static BlockingQueue<String> strs=new LinkedBlockingQueue<>();

    static Random r=new Random();

    public static void main(String[] args) {
        new Thread(()->{ //起一个生产者
            for (int i = 0; i < 10; i++) {
                try {
                    strs.put("a"+i);    //如果队列满了，线程就会等待，这个一直会put，因为LinkedBlockingQueue无界
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"p1").start();

        for (int i = 0; i < 5; i++) { //5个消费者
            new Thread(()->{
                for (;;){
                    try {
                        System.out.println(Thread.currentThread().getName()+" take -"+strs.take()); //如果队列空了，线程就会等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"c"+i).start();
        }
    }
}
