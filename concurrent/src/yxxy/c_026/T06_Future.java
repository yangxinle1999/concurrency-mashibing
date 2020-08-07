package yxxy.c_026;

import java.util.concurrent.*;

//用于接收返回值
public class T06_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task=new FutureTask<>(()->{ //接收一个Callable
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });

        new Thread(task).start(); //新起一个线程来执行任务

        System.out.println(task.get());//阻塞（1000）

        ExecutorService service= Executors.newFixedThreadPool(5);
        Future<Integer> f=service.submit(()->{ //往池子里面仍任务
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });

        System.out.println(f.get()); //1
        System.out.println(f.isDone()); //true

        service.shutdown(); //关闭线程池，不然程序不会结束

    }
}
