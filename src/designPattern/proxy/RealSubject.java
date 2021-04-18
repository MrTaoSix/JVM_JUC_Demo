package designPattern.proxy;

/**
 * @author mrtao
 * @date 2021/4/12 4:42 下午
 * @Description：
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("请求了");
    }
}
