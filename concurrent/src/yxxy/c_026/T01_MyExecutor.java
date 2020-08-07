package yxxy.c_026;

import java.util.concurrent.Executor;

/**
 * 认识Executor(接口中只有void execute(Runnable command);)
 */
public class T01_MyExecutor implements Executor {
    public static void main(String[] args) {
        new T01_MyExecutor().execute(()->{
            System.out.println("hello executor");
        });
    }

    @Override
    public void execute(Runnable command) {
       new Thread(command).start();
    }
}
