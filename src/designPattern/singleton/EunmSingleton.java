package designPattern.singleton;

/**
 * @author mrtao
 * @date 2021/4/9 5:36 下午
 * @Description：
 */



public enum  EunmSingleton {
    INSTANCE;
    public void doSomething(){
        System.out.println("我被调用类");
    }
}
