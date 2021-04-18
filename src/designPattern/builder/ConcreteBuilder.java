package designPattern.builder;

/**
 * @author mrtao
 * @date 2021/4/12 3:10 下午
 * @Description：
 */
public class ConcreteBuilder extends Builder {
    @Override
    void setAtt1() {
        product.setAttr1("1");
    }

    @Override
    void setAtt2() {
        product.setAttr1("2");
    }

    @Override
    void setAtt3() {
        product.setAttr1("3");
    }
}
