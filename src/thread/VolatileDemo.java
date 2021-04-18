package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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

    public void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public synchronized void atomicAdd(){
        atomicInteger.getAndIncrement();
    }

}

/**
 *
 *
 *
 */
public class VolatileDemo {
    public static void main(String[] args) {


        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{

                for (int j = 1; j <= 1000; j++) {
                    myData.atomicAdd();
                }
            },"thread-"+i).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"\tfinally number value:"+myData.atomicInteger);
    }









    //Volatile可以保证可见性 及时通知其他线程，主物理内存的值已经修改
    private static void seeOkByVolatile() {
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
