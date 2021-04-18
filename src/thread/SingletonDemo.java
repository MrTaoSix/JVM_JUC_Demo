package thread;

import java.awt.image.ShortLookupTable;

/**
 * @author mrtao
 * @date 2021/3/18 3:51 下午
 * @Description：
 */
public class SingletonDemo {

    private  static SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t被调用了");
    }
    public static SingletonDemo getInstance(){
        if(instance==null){
            instance = new SingletonDemo();
        }
        return instance;
    }
    
    
    public static void main(String[] args) {

        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());


    }

}
