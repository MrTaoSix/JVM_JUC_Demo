package designPattern.bridge;

/**
 * @author mrtao
 * @date 2021/4/13 10:26 上午
 * @Description：
 */
public class ConcreateImplementorA implements Implementor {


    @Override
    public void operationImpl() {
        System.out.println("具体实现化角色被访问");
    }
}
