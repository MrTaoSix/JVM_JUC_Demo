package designPattern.state;

/**
 * @author mrtao
 * @date 2021/4/14 5:43 下午
 * @Description：
 */
public class StatePattern {

    public static void main(String[] args) {
        Context context = new Context();    //创建环境
        context.Handle();    //处理请求
        context.Handle();
        context.Handle();
        context.Handle();
    }
}
