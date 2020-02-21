package yxxy.c_001;


class T {
    private int count =10;
    private Object o=new Object();

    public void m(){
        synchronized (o){   //任何线程要执行下面的代码，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName()+" count = "+count);
        }
    }
}
