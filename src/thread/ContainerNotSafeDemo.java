package thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author mrtao
 * @date 2021/3/22 4:34 下午
 * @Description：容器不安全实例
 */
public class ContainerNotSafeDemo {


    public static void main(String[] args) {

        Set<String> stringSet = new CopyOnWriteArraySet<>();

        List<String> integers = new CopyOnWriteArrayList<String>();

        for (int i = 0; i < 300; i++) {

            new Thread(()->{
                integers.add(UUID.randomUUID().toString().substring(0,8));
            },i+"-Thread").start();

        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(integers);

    }

}
