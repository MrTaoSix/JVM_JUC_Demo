package designPattern.interpreter;

/**
 * @author mrtao
 * @date 2021/4/17 3:38 下午
 * @Description：环境类
 */
public class Context {

    private AbstractExpression exp;
    public Context() {
        //数据初始化
    }
    public void operation(String info) {
        //调用相关表达式类的解释方法
    }
}
