package designPattern.chainOfResponsibility;

/**
 * @author mrtao
 * @date 2021/4/14 4:59 下午
 * @Description：
 */
public class ConcreateHandlerOne extends  Handler {


    @Override
    public void handleRequest(String request) {

        if (request.equals("one")) {
            System.out.println("处理器一处理了！");
        }else{
            if (getNext() != null) {
                getNext().handleRequest(request);
            }else{
                System.out.println("没有处理器处理");
            }
        }

    }
}
