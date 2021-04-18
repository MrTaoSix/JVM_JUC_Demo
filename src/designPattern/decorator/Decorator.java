package designPattern.decorator;

/**
 * @author mrtao
 * @date 2021/4/13 11:12 上午
 * @Description：抽象装饰角色
 */
abstract class Decorator implements Component {


    Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
