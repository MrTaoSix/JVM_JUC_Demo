package designPattern.decorator;

/**
 * @author mrtao
 * @date 2021/4/13 11:11 上午
 * @Description：
 */
public class  ConcreateComponent implements Component {


    public ConcreateComponent() {
        System.out.println("创建了具体构件");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构件的方法");
    }
}
