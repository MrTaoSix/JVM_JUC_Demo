package designPattern.visitor;

/**
 * @author mrtao
 * @date 2021/4/17 2:52 下午
 * @Description：
 */
public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "具体元素A的操作。";
    }
}
