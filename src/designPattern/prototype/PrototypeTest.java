package designPattern.prototype;

/**
 * @author mrtao
 * @date 2021/4/10 4:33 下午
 * @Description：测试方法
 */
public class PrototypeTest {



  

    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype obj1 = new Realizetype();
        Realizetype obj2 = (Realizetype) obj1.clone();
        System.out.println("相等吗"+(obj1==obj2));
    }

}
