package designPattern.proxy;

/**
 * @author mrtao
 * @date 2021/4/12 5:04 下午
 * @Description：
 */
public class JdkProxyClient {



    public static void main(String[] args) {

        JdkProxy jdkProxy = new JdkProxy();
        Subject instance = jdkProxy.getInstance(new RealSubject());
        instance.request();

    }

}
