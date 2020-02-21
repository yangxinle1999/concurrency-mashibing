package yxxy.c_014;

import java.util.ArrayList;
import java.util.List;

/**
 * 对比上个程序，可以同synchronized解决，synchronized可以保证可见性和原子性，volatile只保证可见性
 */
class T {
    /*volatile*/ int count=0;
    synchronized void m(){
        for (int i = 0; i < 10000; i++) {
            count++;
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
