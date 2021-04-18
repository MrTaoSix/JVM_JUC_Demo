package designPattern.state;

/**
 * @author mrtao
 * @date 2021/4/14 5:39 下午
 * @Description：上下文
 */
public class Context {

    private  State state;

    public Context() {
        state = new ConcreteState1();
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void Handle() {
        state.handler(this);
    }
}
