package yxxy.c_020;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock还可以指定公平锁，哪个线程等的时间长给哪个线程锁
 */
public class ReentrantLock5 extends Thread {
    private static ReentrantLock lock=new ReentrantLock(true);//参数为true表示为公平锁，请对比输出结果

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            lock.lock(); //得到锁
            try {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"获得锁");
            } finally {
                lock.unlock(); //释放锁
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 r1=new ReentrantLock5();
        Thread th1=new Thread(r1);
        Thread th2=new Thread(r1);
        th1.start();
        th2.start();
    }
}
//结果是：
//        Thread-1获得锁
//        Thread-2获得锁
//        Thread-1获得锁
//        Thread-2获得锁
//        Thread-1获得锁
//        Thread-2获得锁
//        Thread-1获得锁
//        Thread-2获得锁
//        Thread-1获得锁
//        Thread-2获得锁
