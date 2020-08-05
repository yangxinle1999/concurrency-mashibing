package yxxy.c_004;

//静态方法锁的是Class，一个类加载到JVM之后只会有一个Class类
class T {
    private static int count=10;

    public synchronized static void m(){    //这里等同于synchronized(yxxy.c_001.T.class)
        count--;
        System.out.println(Thread.currentThread().getName()+" count = "+count);
    }

    public static void mm(){
        synchronized (T.class){ //这里写synchronized(this)是否可以?显然不可以，因为静态方法不属于某个对象，只属于这个类
            count--;
        }
    }
}
