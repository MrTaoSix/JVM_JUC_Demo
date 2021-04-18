package designPattern.chainOfResponsibility;

/**
 * @author mrtao
 * @date 2021/4/14 4:52 下午
 * @Description：抽象处理器
 */
abstract class Handler {

    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    //处理请求的方法
    public abstract void handleRequest(String request);
}
