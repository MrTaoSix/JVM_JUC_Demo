package designPattern.templateMethod;

/**
 * @author mrtao
 * @date 2021/4/14 10:53 上午
 * @Description：抽象模板
 */
abstract class AbstractClass {

    public void operation1(){
        System.out.println("这个人取号了");
    }

    //办理的具体业务
    public abstract  void operaction2();

    public  void operaction3(){
        System.out.println("评价走人！");
    }

    public void templateMethod(){
        operation1();
        operaction2();
        operaction3();
    }
}
