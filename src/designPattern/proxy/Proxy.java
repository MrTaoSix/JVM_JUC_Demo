package designPattern.proxy;

/**
 * @author mrtao
 * @date 2021/4/12 4:42 下午
 * @Description：代理类
 */
public class Proxy implements Subject {

    RealSubject realSubject;

    @Override
    public void request() {

        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }
    public void preRequest(){
        System.out.println("预先处理");
    }

    public void postRequest(){
        System.out.println("后、处理");
    }
}
