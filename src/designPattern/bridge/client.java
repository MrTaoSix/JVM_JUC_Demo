package designPattern.bridge;

import javax.swing.*;

/**
 * @author mrtao
 * @date 2021/4/13 10:29 上午
 * @Description：
 */
public class client {
    public static void main(String[] args) {
        Implementor implementor = new ConcreateImplementorA();
        Abastraction abstractAction = new RefinedAbastracion(implementor);
        abstractAction.operation();
    }
}
