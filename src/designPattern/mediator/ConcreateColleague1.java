package designPattern.mediator;

/**
 * @author mrtao
 * @date 2021/4/16 5:24 下午
 * @Description：
 */
public class ConcreateColleague1 extends  Colleague {
    @Override
    public void receive() {
        System.out.println("具体同事类1收到请求。");
    }

    @Override
    public void send() {
        System.out.println("具体同事类1发出请求。");
        mediator.relay(this); //请中介者转发
    }
}
