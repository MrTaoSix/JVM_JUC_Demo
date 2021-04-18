package designPattern.factory;

/**
 * @author mrtao
 * @date 2021/4/10 5:14 下午
 * @Description：简单工厂模式
 */

public class SimpleFactory {

    //抽象产品
    public  interface Product{
        void show();
    }
    //具体的产品类
    public class ConcreateProduct1 implements Product{
        @Override
        public void show() {
            System.out.println("具体的产品1");
        }
    }
    public class ConcreateProduct2 implements Product{
        @Override
        public void show() {
            System.out.println("具体的产品2");
        }
    }
    final  class  Const{
        static final  int PRODUCT_A = 0;
        static final  int PRODUCT_B = 1;
        static final  int PRODUCT_C = 2;
    }

    public Product makeProduct(int kind){
        switch (kind){
            case Const.PRODUCT_A:
                return new ConcreateProduct1();
            case Const.PRODUCT_B:
                return new ConcreateProduct2();
            default:
                return  null;
        }
    }


}

