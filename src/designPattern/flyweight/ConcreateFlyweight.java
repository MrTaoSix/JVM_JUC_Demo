package designPattern.flyweight;

/**
 * @author mrtao
 * @date 2021/4/13 4:19 下午
 * @Description：
 */
public class ConcreateFlyweight implements  Flyweight {

    private String key;

    public ConcreateFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建！");
    }



    @Override
    public void operation(UnsharedConcreateFlyweight flyweight) {
        System.out.print("具体享元" + key + "被调用，");
        System.out.println("非享元信息是:" + flyweight.getInfo());
    }
}
