package designPattern.flyweight;

/**
 * @author mrtao
 * @date 2021/4/13 4:18 下午
 * @Description： 抽象享元角色
 */
 interface Flyweight {
    public void operation(UnsharedConcreateFlyweight flyweight);
}
