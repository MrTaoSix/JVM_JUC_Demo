package designPattern.visitor;

/**
 * @author mrtao
 * @date 2021/4/17 2:52 下午
 * @Description：
 */
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public String operationB() {
        return "具体元素B的操作。";
    }

}
