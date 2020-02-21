package yxxy.c_010;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @create 2020/2/18 16:05
 * 一个同不方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁，
 * 也就是说synchronized获得的锁是可重入的
 * 这里是继承中可能发生的情形，子类调用父类方法
 */
class T {
    synchronized void m(){
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("m end");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}

class TT extends T{
    @Override
    synchronized void m(){
        System.out.println("child m start");
        super.m();
        System.out.println("chile m end");
    }
}
