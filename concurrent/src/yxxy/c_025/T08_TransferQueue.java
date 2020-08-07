package yxxy.c_025;

import java.util.concurrent.LinkedTransferQueue;

public class T08_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs=new LinkedTransferQueue<>();

        Thread thread = new Thread(() -> { //先起消费者线程等待
            try {
                String take = strs.take();
                System.out.println(take); //阻塞等待,aaa
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(2000);
        int waitingConsumerCount = strs.getWaitingConsumerCount();//等待在strs队列中的消费者线程个数
        System.out.println(waitingConsumerCount);//1

        strs.transfer("aaa");
        //strs.put("aaa");

        /*new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/
    }
}
