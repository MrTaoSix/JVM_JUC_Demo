package designPattern.factory;

/**
 * @author mrtao
 * @date 2021/4/10 6:43 下午
 * @Description：
 */
public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product1 newProduct1() {
        return new ConcreteProduct1();
    }

    @Override
    public Product2 newProduct2() {
        return new ConcreteProduct2();
    }
}
