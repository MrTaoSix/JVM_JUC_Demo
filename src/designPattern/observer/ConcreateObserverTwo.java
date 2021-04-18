package designPattern.observer;

/**
 * @author mrtao
 * @date 2021/4/15 4:35 下午
 * @Description：具体观察者一
 */
public class ConcreateObserverTwo implements Observer {
    @Override
    public void response() {
        System.out.println("观察者二收到通知！");
    }
}
