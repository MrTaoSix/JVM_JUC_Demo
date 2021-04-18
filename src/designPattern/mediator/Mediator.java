package designPattern.mediator;

/**
 * @author mrtao
 * @date 2021/4/16 5:21 下午
 * @Description： 抽象中介者
 */
abstract class Mediator {

    public abstract  void register(Colleague colleague);

    public abstract void relay(Colleague cl);//转发

}
