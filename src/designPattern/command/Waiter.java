package designPattern.command;

/**
 * @author mrtao
 * @date 2021/4/14 3:35 下午
 * @Description：调用者 服务员
 */
public class Waiter {
    private Breakfast baozi ,youTiao;

    public void setBaozi(Breakfast baozi) {
        this.baozi = baozi;
    }

    public void setYouTiao(Breakfast youTiao) {
        this.youTiao = youTiao;
    }

    public void chooseBaoZi() {
        baozi.cooking();
    }

    public void chooseYouTiao() {
        youTiao.cooking();
    }
}
