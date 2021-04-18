package designPattern.command;

/**
 * @author mrtao
 * @date 2021/4/14 3:28 下午
 * @Description：具体命令 包子早餐
 */
public class BaoZi implements Breakfast {
    private  BaoZiChef baoZiChef;

    public BaoZi() {
        this.baoZiChef = new BaoZiChef();
    }

    @Override
    public void cooking() {
        baoZiChef.cooking();
    }
}
