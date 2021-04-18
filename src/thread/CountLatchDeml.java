package thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author mrtao
 * @date 2021/3/24 3:50 下午
 * @Description：
 */
public class CountLatchDeml {

    public static void main(String[] args)  {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{

                try {  Thread.sleep(Math.round(3000));   } catch (InterruptedException e) { e.printStackTrace();   }
                System.out.println(Thread.currentThread().getName()+"完成了任务");
                countDownLatch.countDown();

            },i+"").start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有人都完成了！");

    }

}
