package designPattern.adaptor;

/**
 * @author mrtao
 * @date 2021/4/12 5:39 下午
 * @Description：
 */
public class ClassAdaptor extends Adaptor implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}
