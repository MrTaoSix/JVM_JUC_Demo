package designPattern.singleton;

/**
 * @author mrtao
 * @date 2021/4/9 3:00 下午
 * @Description：饥饿单例模式
 */
public class HungrySingleton {

    private  static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }
    
    public static HungrySingleton getInstance(){
        return instance;
    } 
}
