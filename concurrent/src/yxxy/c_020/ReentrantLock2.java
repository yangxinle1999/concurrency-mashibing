package yxxy.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock用于替代synchronized
 *
 * 需要注意的是，必须要手动释放锁
 * 使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 */
class ReentrantLock2 {
    Lock lock=new ReentrantLock();

    void m1(){
        /**
         * 在 try-finally 外加锁的话，如果因为发生异常导致加锁失败
         * try-finally 块中的代码不会执行
         * 相反，如果在 try{ } 代码块中加锁失败，finally 中的代码无论如何都会执行
         * 但是由于当前线程加锁失败并没有持有 lock 对象锁，程序会抛出异常
         *
         * 详情参考 https://blog.csdn.net/u013568373/article/details/98480603
         */
        lock.lock();    //相当于synchronized(this)
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2(){
        lock.lock();
        try {
            System.out.println("m2....");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock2 r1=new ReentrantLock2();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }
}
