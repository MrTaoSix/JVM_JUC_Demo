package designPattern.proxy;

/**
 * @author mrtao
 * @date 2021/4/12 4:46 下午
 * @Description：
 */
public class client {

    public static void main(String[] args) {
        Proxy proxy = new Proxy();

        proxy.request();
    }
}
