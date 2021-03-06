package designPattern.builder;

/**
 * @author mrtao
 * @date 2021/4/12 3:06 下午
 * @Description：产品本品
 */

public class Product {

    private String attr1;
    private String attr2;
    private String attr3;

    @Override
    public String toString() {
        return "Product{" +
                "attr1='" + attr1 + '\'' +
                ", attr2='" + attr2 + '\'' +
                ", attr3='" + attr3 + '\'' +
                '}';
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }
}
