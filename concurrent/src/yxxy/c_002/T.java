package yxxy.c_002;

/**
 * @version 1.0
 * @create 2020/2/18 14:18
 */
class T {
    private int count=10;
    public void m(){
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+" count = "+count);
        }
    }
}
