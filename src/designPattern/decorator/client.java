package designPattern.decorator;

/**
 * @author mrtao
 * @date 2021/4/13 11:15 上午
 * @Description：
 */
public class client {

    public static void main(String[] args) {
        Component component = new ConcreateComponent();
        component.operation();
        System.out.println("------功能增强后------");
        Component decorator = new ConcreateDecorator(component);
        decorator.operation();

    }
}
