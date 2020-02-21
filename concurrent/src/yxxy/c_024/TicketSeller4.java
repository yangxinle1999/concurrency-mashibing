package yxxy.c_024;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
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
public class TicketSeller4 {
    static Queue<String> tickets=new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号："+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
               while (true){
                   String s=tickets.poll();

                   if (s==null){
                       break;
                   }else{
                       System.out.println(Thread.currentThread().getName()+"销售了--"+s);
                   }
               }
            },"窗口"+i).start();
        }
    }
}
