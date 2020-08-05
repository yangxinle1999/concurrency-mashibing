package yxxy.c_002;

//使用this关键字，锁定调用者对象本身，不用new了，方便很多
class T {
    private int count=10;
    public void m(){
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+" count = "+count);
        }
    }
}
