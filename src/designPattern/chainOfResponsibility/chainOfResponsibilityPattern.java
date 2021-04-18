package designPattern.chainOfResponsibility;

/**
 * @author mrtao
 * @date 2021/4/14 5:04 下午
 * @Description：
 */
public class chainOfResponsibilityPattern {
    public static void main(String[] args) {
        ConcreateHandlerOne one = new ConcreateHandlerOne();
        ConcreateHandlerTwo two = new ConcreateHandlerTwo();
        one.setNext(two);
        one.handleRequest("one");
        one.handleRequest("two");
    }
}
