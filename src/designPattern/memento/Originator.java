package designPattern.memento;

/**
 * @author mrtao
 * @date 2021/4/17 3:16 下午
 * @Description：发起人
 */
public class Originator {

    private  String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return new Memento(state);
    }

    public void restoreMemento(Memento m) {
         this.setState(m.getState());
    }


}
