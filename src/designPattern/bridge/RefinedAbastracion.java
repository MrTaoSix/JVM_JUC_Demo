package designPattern.bridge;

/**
 * @author mrtao
 * @date 2021/4/13 10:29 上午
 * @Description：
 */
public class RefinedAbastracion  extends  Abastraction {
    public RefinedAbastracion(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        implementor.operationImpl();
    }
}
