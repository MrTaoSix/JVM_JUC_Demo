package designPattern.adaptor;

/**
 * @author mrtao
 * @date 2021/4/12 5:40 下午
 * @Description：
 */
public class ClassAdaptorClient {
    public static void main(String[] args) {
        Target target = new ClassAdaptor();
        target.request();

        Adaptor adaptor = new Adaptor();
        Target target1 = new ObjectAdaptor(adaptor);
        target1.request();

    }
}
