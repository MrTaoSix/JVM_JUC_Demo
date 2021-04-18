package designPattern.bridge;

/**
 * @author mrtao
 * @date 2021/4/13 10:27 上午
 * @Description：
 */
abstract class Abastraction {
    protected Implementor implementor;

    public Abastraction(Implementor implementor) {
        this.implementor = implementor;
    }
    public abstract void operation();
}
