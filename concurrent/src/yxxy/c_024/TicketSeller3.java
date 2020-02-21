package yxxy.c_024;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 有n张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 *
 * 分析下面的程序可能会产生哪些问题？
 * 重复销售？超量销售？
 *
 */
public class TicketSeller3 {
    static LinkedList<String> tickets=new LinkedList<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号："+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
               while (tickets.size()>0){
                   synchronized (tickets){
                       if (tickets.size()<=0){
                           break;
                       }
                       try {
                           TimeUnit.MILLISECONDS.sleep(10);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println(Thread.currentThread().getName()+"销售了--"+tickets.remove(0));
                   }
               }
            },"窗口"+i).start();
        }
    }
}
