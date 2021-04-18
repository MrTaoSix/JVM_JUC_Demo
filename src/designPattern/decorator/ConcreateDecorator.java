package designPattern.decorator;

/**
 * @author mrtao
 * @date 2021/4/13 11:13 上午
 * @Description：
 */
public class ConcreateDecorator extends Decorator {
    public ConcreateDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    public void addedFunction() {
        System.out.println("增加了额外功能");
    }
}
