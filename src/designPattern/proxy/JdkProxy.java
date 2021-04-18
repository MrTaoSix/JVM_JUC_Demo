package designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author mrtao
 * @date 2021/4/12 5:00 下午
 * @Description：
 */
public class JdkProxy implements InvocationHandler {

    private Subject target;

    public Subject getInstance(Subject target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return (Subject) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        after();
        Object object = method.invoke(this.target, args);
        before();
        return object;
    }

    private void after() {
        System.out.println("前置操作");
    }

    private void before() {
        System.out.println("收尾操作");
    }

}
