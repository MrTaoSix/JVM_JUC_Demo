package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author mrtao
 * @date 2021/3/23 4:25 下午
 * @Description：自旋锁演示
 */
public class SpinLockDemo {

    AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();

    public void lock(){

        Thread thread = Thread.currentThread();
        while (!threadAtomicReference.compareAndSet(null,thread)){
            System.out.println(Thread.currentThread().getName()+"/t 尝试中。。。。");
        }
        System.out.println(Thread.currentThread().getName()+"/t 获得了锁");
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        threadAtomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {

        SpinLockDemo demo1 = new SpinLockDemo();

        new Thread(()->{
            demo1.lock();
            try { TimeUnit.SECONDS.sleep(1);    }catch (Exception e){    e.printStackTrace();  }
            demo1.unlock();
            System.out.println(Thread.currentThread().getName()+"/t 完成任务");
        },"T1").start();

        new Thread(()->{
            demo1.lock();
            try { TimeUnit.SECONDS.sleep(1);    }catch (Exception e){    e.printStackTrace();  }
            demo1.unlock();
            System.out.println(Thread.currentThread().getName()+"/t 完成任务");
        },"T2").start();

    }

}
