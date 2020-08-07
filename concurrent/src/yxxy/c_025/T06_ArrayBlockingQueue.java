package yxxy.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

//有界阻塞队列
public class T06_ArrayBlockingQueue {
    static BlockingQueue<String> strs=new ArrayBlockingQueue<>(10);

    static Random r=new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a"+i);
        }

        //strs.put("aaa");  //满了就会等待，程序阻塞
        //strs.add("aaa");  //满了会报错
        //strs.offer("aaa");//满了会返回false，不会报错
        boolean aaa = strs.offer("aaa", 1, TimeUnit.SECONDS);//1秒之内加不上数据就不加了
        System.out.println(aaa); //false

        System.out.println(strs); //[a0, a1, a2, a3, a4, a5, a6, a7, a8, a9]
    }
}
