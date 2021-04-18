package designPattern.visitor;

/**
 * @author mrtao
 * @date 2021/4/17 2:50 下午
 * @Description：
 */
public interface Element {
    void accept(Visitor visitor);
}
