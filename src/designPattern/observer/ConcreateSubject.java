package designPattern.observer;

/**
 * @author mrtao
 * @date 2021/4/15 4:37 下午
 * @Description：
 */
public class ConcreateSubject extends Subject {
    @Override
    public void notifyObserver() {
        for (Object obs : observers) {
            ((Observer) obs).response();
        }
    }
}
