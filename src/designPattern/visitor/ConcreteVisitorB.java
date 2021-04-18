package designPattern.visitor;

/**
 * @author mrtao
 * @date 2021/4/17 2:51 下午
 * @Description：具体访问者A
 */
public class ConcreteVisitorB implements Visitor {

    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者B访问-->" + element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者B访问-->" + element.operationB());
    }
}
