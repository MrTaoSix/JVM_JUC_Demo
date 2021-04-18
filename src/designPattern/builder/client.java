package designPattern.builder;

/**
 * @author mrtao
 * @date 2021/4/12 3:14 下午
 * @Description：
 */
public class client {

    public static void main(String[] args) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        Director director = new Director(concreteBuilder);

        Product construct = director.construct();
        System.out.println(construct.toString());


    }
}
