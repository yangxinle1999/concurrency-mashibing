package yxxy.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock用于替代synchronized
 *
 * 需要注意的是，必须要手动释放锁
 * 使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 *
 * 使用reentrantlock可以进行“尝试锁定”trylock，这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 */
class ReentrantLock3 {
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

    /**
     * 使用trylock进行尝试锁定，不管锁定与否，方法都将继续执行
     * 可以根据trylock的返回值来判断是否锁定
     * 也可以指定trylock的时间，由于trylock(time)抛出异常，所以要注意unlock的处理，必须方法finally中
     */
    void m2(){
        /*boolean locked=lock.tryLock();
        System.out.println("m2..."+locked);
        if (locked) lock.unlock();*/

        boolean locked=false;
        try {
            locked=lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2...."+locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked) lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock3 r1=new ReentrantLock3();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }
}
