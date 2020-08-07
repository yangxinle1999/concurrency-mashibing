package yxxy.c_026;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class T14_ParallelStreamApi {

    public static void main(String[] args) {
        List<Integer> nums=new ArrayList<>();
        Random r=new Random();
        for (int i = 0; i < 10000; i++) {
            nums.add(1000000+r.nextInt(1000000));
        }

        //System.out.println(nums);

        long start=System.currentTimeMillis();
        nums.forEach(v->isPrime(v));
        long end=System.currentTimeMillis();
        System.out.println(end-start); //2126

        //使用parallel stream api

        start=System.currentTimeMillis();
        nums.stream().forEach(T14_ParallelStreamApi::isPrime); //单管道
        end=System.currentTimeMillis();
        System.out.println(end-start); //2111

        start=System.currentTimeMillis();
        nums.parallelStream().forEach(T14_ParallelStreamApi::isPrime);  //多管道
        end=System.currentTimeMillis();

        System.out.println(end-start); //390
    }

    //判断一个数是不是质数
    private static boolean isPrime(Integer num) {
        for (int i = 2; i < num/2; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
