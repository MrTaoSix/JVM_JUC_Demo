package designPattern.strategy;

/**
 * @author mrtao
 * @date 2021/4/14 11:37 上午
 * @Description：
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context c = new Context();
        Strategy s = new ConcreateStrategy1();
        c.setStrategy(s);
        c.strategyMethod();
        System.out.println("-----------------");
        s = new ConcreateStrategy2();
        c.setStrategy(s);
        c.strategyMethod();
    }
}
