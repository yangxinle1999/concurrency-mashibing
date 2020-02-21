package yxxy.c_004;

/**
 * @version 1.0
 * @create 2020/2/18 14:25
 */
class T {
    private static int count=10;

    public synchronized static void m(){    //这里等同于synchronized(yxxy.c_001.T.class)
        count--;
        System.out.println(Thread.currentThread().getName()+" count = "+count);
    }

    public static void mm(){
        synchronized (T.class){ //这里写synchronized(this)是否可以?
            count--;
        }
    }
}
