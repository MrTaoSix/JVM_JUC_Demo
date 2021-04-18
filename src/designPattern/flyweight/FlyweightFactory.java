package designPattern.flyweight;

import java.util.HashMap;

/**
 * @author mrtao
 * @date 2021/4/13 4:32 下午
 * @Description：享元工厂
 */
public class FlyweightFactory {

    private HashMap<String, Flyweight> flyweightHashMap = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweightHashMap.get(key);
        if (flyweight != null) {
            System.out.println("具体享元" + key + "已经存在，被成功获取！");
        } else {
            flyweight = new ConcreateFlyweight(key);
            flyweightHashMap.put(key, flyweight);
        }
        return flyweight;
    }

}
