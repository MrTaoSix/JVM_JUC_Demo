package designPattern.factory;

/**
 * @author mrtao
 * @date 2021/4/10 5:32 下午
 * @Description：工厂方法模式
 */
public class FacotryMethod {

    interface  Product{
        public void show();
    }

    class ConcreteProduct1 implements Product{
        @Override
        public void show() {
            System.out.println("具体的产品一");
        }
    }
    class ConcreteProduct2 implements Product{
        @Override
        public void show() {
            System.out.println("具体的产品二");
        }
    }
    interface AbstractFactroy{
        Product newProduct();
    }

    class ConcreteFactory1 implements AbstractFactroy{

        @Override
        public Product newProduct() {
            return new ConcreteProduct1();
        }
    }

    class ConcreteFactory2 implements AbstractFactroy{
        @Override
        public Product newProduct() {
            return new ConcreteProduct1();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String factoryName = "ConcreteFactory1";

        Class<?> c = Class.forName("ConcreteFactory1");

        FacotryMethod.AbstractFactroy o = (FacotryMethod.AbstractFactroy) c.newInstance();
        FacotryMethod.Product product = o.newProduct();
        product.show();

    }

}
