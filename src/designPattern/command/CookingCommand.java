package designPattern.command;

/**
 * @author mrtao
 * @date 2021/4/14 3:39 下午
 * @Description：
 */
public class CookingCommand {

    public static void main(String[] args) {
        //此时一个大佬要来吃早餐
        //下面是菜单 相当于一个命令
        Breakfast baozi = new BaoZi(); //包子
        Breakfast youtiao = new YouTiao();//油条

        //下面是服务员来问大佬要吃啥
        Waiter waiter = new Waiter();

        //大佬说要吃包子 服务员接收到包子这个命令
        waiter.setBaozi(baozi);

        //选择包子
        waiter.chooseBaoZi();

    }

}
