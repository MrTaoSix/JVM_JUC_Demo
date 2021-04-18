package designPattern.visitor;

/**
 * @author mrtao
 * @date 2021/4/17 3:01 下午
 * @Description：
 */
public class main {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitorA();
        os.accpt(visitor);
        System.out.println("------------------------");
        visitor = new ConcreteVisitorB();
        os.accpt(visitor);
    }
}
