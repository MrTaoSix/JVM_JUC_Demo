package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author mrtao
 * @date 2021/3/24 3:06 下午
 * @Description：读写锁Demo
 */
public class ReadWriteLockDemo {


    Map<String,String>  map = new HashMap<>();

    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key,String value){
        try {
            rwLock.writeLock().lock();
            System.out.println(key+"正在写入："+key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,value);
            System.out.println(key+"写入完成："+key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public String get(String key){
        try {
            rwLock.readLock().lock();
            System.out.println("\t \t\t\t\t\t"+key+"正在读取："+key);
            return map.get(key);
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();

        for (int i = 0; i < 5; i++) {
            final int tempint = i;
            new Thread(()->{
                readWriteLockDemo.put(tempint+"",tempint+"");
            },"Thread"+i).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempint = i;
            new Thread(()->{
                readWriteLockDemo.get(tempint+"");
            },"Thread"+i).start();
        }





    }


}
