package yxxy.c_016;

import java.util.concurrent.TimeUnit;

/**
 * 同步代码块中的语句越少越好
 * 比较m1和m2
 */
class T {
    int count=0;

    synchronized void m1(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //业务逻辑中只有下面这句需要syn，这时不应给整个方法上锁
        count++;

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();

    }

    void m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 业务逻辑中只有下面这句需要syn，这时不应给整个方法上锁
         * 采用细粒度的锁，可以使线程争用时间变短，从而提高效率
         */
        synchronized (this){
            count++;
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
    }

}
