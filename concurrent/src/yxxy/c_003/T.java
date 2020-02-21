package yxxy.c_003;


class T {
    private int count=10;
    public synchronized void m(){
        count--;
        System.out.println(Thread.currentThread().getName()+" count = "+count);
    }
}
