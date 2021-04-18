package designPattern.mediator;

/**
 * @author mrtao
 * @date 2021/4/16 5:21 下午
 * @Description：
 */
abstract class Colleague {

    protected Mediator mediator;

    public void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();
    public abstract  void send();



}
