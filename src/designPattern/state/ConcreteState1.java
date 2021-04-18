package designPattern.state;

/**
 * @author mrtao
 * @date 2021/4/14 5:41 下午
 * @Description： 具体状态
 */
public class ConcreteState1 extends State {


    @Override
    public void handler(Context context) {
        System.out.println("当前状态是 1.");
        context.setState(new ConcreteState2());
    }
}
