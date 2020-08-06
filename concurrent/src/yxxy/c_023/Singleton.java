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
    private Singleton() {
        super();
        System.out.println("single");
    }

    private static class Inner{
        private static Singleton s=new Singleton();
    }

    public static Singleton getSingle(){
        return Inner.s;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                Singleton single = Singleton.getSingle();
                System.out.println(single.hashCode());
            }).start();
        }
    }
}
//结果是：
//single
//1923132015
//1923132015
//1923132015
//1923132015
//1923132015
