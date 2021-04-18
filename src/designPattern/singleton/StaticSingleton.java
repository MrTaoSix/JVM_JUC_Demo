package designPattern.singleton;

/**
 * @author mrtao
 * @date 2021/4/9 5:25 下午
 * @Description：静态内部类
 */
public class StaticSingleton {

    private StaticSingleton(){}

    private  static class  StaticSingletonHolder{
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }
    public static  StaticSingleton getInstance(){
        return  StaticSingletonHolder.INSTANCE;
    }

}
