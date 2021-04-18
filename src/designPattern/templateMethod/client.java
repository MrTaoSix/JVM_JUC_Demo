package designPattern.templateMethod;

/**
 * @author mrtao
 * @date 2021/4/14 10:59 上午
 * @Description：
 */
public class client {


    public static void main(String[] args) {

        AbstractClass abstractClass1 = new ConcreateClass();
        abstractClass1.templateMethod();

        abstractClass1 = new ConcreateClass2();
        abstractClass1.templateMethod();

    }

}
