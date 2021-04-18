package designPattern.memento;

import java.util.Objects;

/**
 * @author mrtao
 * @date 2021/4/17 3:20 下午
 * @Description：
 */
public class client {
    public static void main(String[] args) {
        Originator or = new Originator();
        Caretaker cr = new Caretaker();
        or.setState("help");
        System.out.println("初始状态:" + or.getState());
        cr.setMemento(or.createMemento());
        or.setState("sq");
        System.out.println("初始状态:" + or.getState());
        or.restoreMemento(cr.getMemento());
        System.out.println("初始状态:" + or.getState());
    }
}
