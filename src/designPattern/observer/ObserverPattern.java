package designPattern.observer;

/**
 * @author mrtao
 * @date 2021/4/15 4:37 下午
 * @Description：
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new ConcreateSubject();
        Observer observerOne = new ConcreateObserverOne();
        Observer observerTwo = new ConcreateObserverTwo();
        subject.addObservers(observerOne);
        subject.addObservers(observerTwo);
        subject.notifyObserver();
    }
}
