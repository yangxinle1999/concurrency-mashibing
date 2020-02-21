package yxxy.c_026;

import java.util.concurrent.Executor;

/**
 * @version 1.0
 * @create 2020/2/20 19:21
 * 认识Executor
 */
public class T01_MyExecutor implements Executor {
    public static void main(String[] args) {
        new T01_MyExecutor().execute(()->{
            System.out.println("hello executor");
        });
    }

    @Override
    public void execute(Runnable command){
        new Thread(command).run();
        //command.run();
    }
}
