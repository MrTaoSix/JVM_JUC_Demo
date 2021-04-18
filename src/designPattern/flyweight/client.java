package designPattern.flyweight;

/**
 * @author mrtao
 * @date 2021/4/13 4:37 下午
 * @Description：
 */
public class client {


    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight f1 = factory.getFlyweight("a");
        Flyweight f2 = factory.getFlyweight("a");
        Flyweight f3 = factory.getFlyweight("a");
        Flyweight f11 = factory.getFlyweight("b");
        Flyweight f12 = factory.getFlyweight("b");
        f1.operation(new UnsharedConcreateFlyweight("第1次调用a。"));
        f2.operation(new UnsharedConcreateFlyweight("第2次调用a。"));
        f3.operation(new UnsharedConcreateFlyweight("第3次调用a。"));
        f11.operation(new UnsharedConcreateFlyweight("第1次调用b。"));
        f12.operation(new UnsharedConcreateFlyweight("第2次调用b。"));

    }

}
