package yxxy.c_015;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决同样的问题的更高效的方法，使用AtomXXX类
 * AtomXXX类本身方法都是原子性的，但不能保证多个方法连续调用是原子性的
 */
class T {
    AtomicInteger count=new AtomicInteger(0);
    /*synchronized*/ void m(){
        for (int i = 0; i < 10000000; i++) {
            /*if (count.get()<1000000)*/
            count.incrementAndGet();    //替代count++的
        }
    }

    public static void main(String[] args) {
        T t=new T();

        List<Thread> threads=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"thread-"+i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
