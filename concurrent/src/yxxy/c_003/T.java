package yxxy.c_003;

//如果一个方法从开始就要得到锁的话，可以直接将synchronized写到方法上
class T {
    private int count=10;
    public synchronized void m(){
        count--;
        System.out.println(Thread.currentThread().getName()+" count = "+count);
    }
}
