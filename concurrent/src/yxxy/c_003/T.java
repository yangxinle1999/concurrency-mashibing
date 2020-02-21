package yxxy.c_003;

/**
 * @version 1.0
 * @create 2020/2/18 14:19
 */
class T {
    private int count=10;
    public synchronized void m(){
        count--;
        System.out.println(Thread.currentThread().getName()+" count = "+count);
    }
}
