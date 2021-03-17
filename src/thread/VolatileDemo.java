package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author mrtao
 * @date 2021/3/17 9:08 上午
 * @Description：Volatile 可见性代码演示
 */


class MyData{
    volatile int number = 0;

    public void chageNumber(){
        number = 60;
    }


}

public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();

        new Thread(() ->{
            try { TimeUnit.SECONDS.sleep(3);}catch (InterruptedException e){ e.printStackTrace();   }
            myData.chageNumber();
            System.out.println(Thread.currentThread().getName()+"/t update number value:"+myData.number);
        },"AAA").start();

        while (myData.number==0){

        }
        System.out.println(Thread.currentThread().getName()+"/t mission is over,main get number value:"+myData.number);
    }
}
