package yxxy.c_013;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized
 */
class T {
    volatile int count=0;
    void m(){
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T t=new T();

        List<Thread> threads=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"thread-"+i)); //创建10个线程
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();  //join主要的作用就是让主线程等待子线程执行完毕之后，才让主线程继续执行。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count); //结果是9172，说明volatile不是原子操作
    }
}
