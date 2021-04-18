package designPattern.adaptor;

/**
 * @author mrtao
 * @date 2021/4/12 5:41 下午
 * @Description：
 */
public class ObjectAdaptor implements Target {

    private Adaptor adaptor;

    public ObjectAdaptor(Adaptor adaptor){
        this.adaptor = adaptor;
    }

    @Override
    public void request() {
        adaptor.specificRequest();
    }
}
