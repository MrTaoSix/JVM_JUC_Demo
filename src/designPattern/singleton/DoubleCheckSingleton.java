package designPattern.singleton;

/**
 * @author mrtao
 * @date 2021/4/9 4:08 下午
 * @Description：双重检查模式
 */
public class DoubleCheckSingleton {

    private static  DoubleCheckSingleton instance = null;

    private  DoubleCheckSingleton(){}

    public static DoubleCheckSingleton getInstance(){
        if(instance==null){
            synchronized(DoubleCheckSingleton.class){
                if(instance==null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
