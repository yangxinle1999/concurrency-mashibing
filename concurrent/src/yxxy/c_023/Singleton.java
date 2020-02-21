package yxxy.c_023;

/**
 *
 * 线程安全的单例模式
 *
 * 更好的是采用下面的方式，既不用加锁，也能实现懒加载
 *
 * 阅读文章：https://www.cnblogs.com/xudong-bupt/p/3433643.html
 *
 */
public class Singleton {
    public Singleton() {
        super();
        System.out.println("single");
    }

    private static class Inner{
        private static Singleton s=new Singleton();
    }

    private static Singleton getSingle(){
        return Inner.s;
    }

    public static void main(String[] args) {
        Thread[] ths=new Thread[200];
        for (int i = 0; i < ths.length; i++) {
            ths[i]=new Thread(()->{
               Singleton.getSingle();
            });
        }
    }
}
