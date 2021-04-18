package designPattern.command;

/**
 * @author mrtao
 * @date 2021/4/14 3:33 下午
 * @Description：
 */
public class YouTiao implements Breakfast {

   private   YouTiaoChef youTiaoChef;

    public YouTiao() {
        this.youTiaoChef = new YouTiaoChef();
    }

    @Override
    public void cooking() {
        youTiaoChef.cooking();
    }
}
