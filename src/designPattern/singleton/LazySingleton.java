package designPattern.singleton;

/**
 * @author mrtao
 * @date 2021/4/9 2:47 下午
 * @Description：懒汉式单例模式
 */
public class LazySingleton {

    //声明一个自己的实例
    private  static volatile LazySingleton instance = null;

    //构造方法私有化
    private LazySingleton() {
    }

    //只有在第一次调用的才创建实例
    public static  synchronized  LazySingleton getInstance(){
        if(instance==null){
            instance = new LazySingleton();
        }
        return instance;
    }
    //优点是没有调用的时候不会创建实例，节省系统资源
    //缺点是为了线程安全加了锁，性能会下降
}
