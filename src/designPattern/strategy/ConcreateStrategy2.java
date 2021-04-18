package designPattern.strategy;

/**
 * @author mrtao
 * @date 2021/4/14 11:35 上午
 * @Description：具体策略
 */
public class ConcreateStrategy2 implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("具体的策略2被调用");
    }
}
