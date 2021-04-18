package designPattern.flyweight;

/**
 * @author mrtao
 * @date 2021/4/13 4:21 下午
 * @Description：
 */
public class UnsharedConcreateFlyweight {

    private  String info;

    public UnsharedConcreateFlyweight(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
