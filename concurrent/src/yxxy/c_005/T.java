package yxxy.c_005;

//被synchronized修饰的部分是原子操作，不被被ynchronized修饰的部分不是原子操作
class T implements Runnable {

    private int count=10;

    @Override
    public /*synchronized*/ void run() {
        count--; //不是原子操作
        System.out.println(Thread.currentThread().getName()+" count = "+count);
//        Thread0 count = 9
//        Thread4 count = 5
//        Thread3 count = 6
//        Thread2 count = 7
//        Thread1 count = 8

        //加上synchronized之后，一定是：
//        Thread0 count = 9
//        Thread1 count = 8
//        Thread2 count = 7
//        Thread3 count = 6
//        Thread4 count = 5
    }

    public static void main(String[] args) {
        T t=new T();
        for (int i = 0; i < 5; i++) {
            new Thread(t,"Thread"+i).start();
        }
    }
}
