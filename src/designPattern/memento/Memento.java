package designPattern.memento;

/**
 * @author mrtao
 * @date 2021/4/17 3:15 下午
 * @Description： 备忘录
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
