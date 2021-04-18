package designPattern.strategy;

/**
 * @author mrtao
 * @date 2021/4/14 11:36 上午
 * @Description：
 */
public class Context implements Strategy{
    Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void strategyMethod() {
        strategy.strategyMethod();
    }
}
