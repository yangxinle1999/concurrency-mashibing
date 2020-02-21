package yxxy.c_008;

import java.util.concurrent.TimeUnit;

/**
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题(dirtyRead)
 */
class Account {
    private String name;
    private double balance;

    public synchronized void set(String name,double balance){
        this.name=name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance=balance;
    }

    public synchronized double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Account a=new Account();
        new Thread(()->a.set("张三",100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("张三"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("张三"));

    }
}
