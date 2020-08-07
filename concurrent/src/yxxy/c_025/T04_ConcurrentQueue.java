package yxxy.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> strs=new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
            strs.offer("a"+i); //队列满之后再加不会报错，会返回false
        }

        System.out.println(strs); //[a0, a1, a2, a3, a4, a5, a6, a7, a8, a9]

        System.out.println(strs.size()); //10

        System.out.println(strs.poll()); //a0
        System.out.println(strs.size()); //9

        System.out.println(strs.peek()); //a1
        System.out.println(strs.size()); //9

        //双端队列Deque
    }
}
