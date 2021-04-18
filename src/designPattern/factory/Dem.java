package designPattern.factory;

/**
 * @author mrtao
 * @date 2021/4/10 6:47 下午
 * @Description：
 */
public class Dem {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String name = "designPattern.factory.ConcreteFactory1";
        Class<?> c = Class.forName(name);



        AbstractFactory abstractFactory = (AbstractFactory) c.newInstance();
        Product1 product1 = abstractFactory.newProduct1();
        Product2 product2 = abstractFactory.newProduct2();
        product1.show();
        product2.show();


    }
}
