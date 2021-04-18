package designPattern.memento;

/**
 * @author mrtao
 * @date 2021/4/17 3:19 下午
 * @Description：
 */

public class Caretaker {

    private Memento memento;
    public void setMemento(Memento m){
        this.memento = m;
    }

    public Memento getMemento(){
        return  memento;
    }
}
