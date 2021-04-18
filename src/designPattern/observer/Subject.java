package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mrtao
 * @date 2021/4/15 4:31 下午
 * @Description：抽象目标
 */
abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();

    public void removeObservers(Observer observer) {
        observers.remove(observer);
    }

    public void addObservers(Observer observer) {
        this.observers.add(observer);
    }

    public  abstract void notifyObserver();//通知观察者方法

}
