package designPattern.visitor;

/**
 * @author mrtao
 * @date 2021/4/17 2:51 下午
 * @Description：抽象访问者
 */
public interface Visitor {

    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}
