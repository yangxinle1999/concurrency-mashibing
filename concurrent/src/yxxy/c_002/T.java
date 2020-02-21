package yxxy.c_002;


class T {
    private int count=10;
    public void m(){
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+" count = "+count);
        }
    }
}
