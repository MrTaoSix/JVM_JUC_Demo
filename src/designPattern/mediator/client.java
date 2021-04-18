package designPattern.mediator;

/**
 * @author mrtao
 * @date 2021/4/16 5:28 下午
 * @Description：
 */
public class client {
    public static void main(String[] args) {
        Mediator md = new ConcreateMediator();
        Colleague c1, c2;
        c1 = new ConcreateColleague1();
        c2 = new ConcreateColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("-------------");
        c2.send();
    }

}
