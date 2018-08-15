package com.kanma;

/**
 * @ Desc   ：JDK动态代理,通用动态代理类，被调用对象方法前后增加特殊操作,一样的类都可用此类代理
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/8/13 16:45
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Animal {
    void makeSound(String name);
}

class Dog implements Animal {
    @Override
    public void makeSound(String name) {
        System.out.println("Hi," + name + ",wang,wang~~");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound(String name) {
        System.out.println("Hi," + name + ",miao,miao~~");
    }
}

//通用动态代理类，被调用对象方法前后增加特殊操作,一样的类都可用此类代理
class AnimalProxy implements InvocationHandler {
    // 被代理的对象(委托类)
    private Object target;

    public AnimalProxy(Object target) {
        super();
        this.target = target;
    }


    /**
     * 在代理实例上处理方法调用并返回结果
     *
     * @param proxy  代理类
     * @param method 被代理的方法
     * @param args   该方法的参数数组
     */
    //要增强的方法写在invoke方法里
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        Object result = null;
        //调用之前
        doBefore();
        //调用原始对象的方法
        result = method.invoke(target, args);
        //调用之后
        doAfter();
        return result;
    }

    private void doBefore() {
        System.out.println("before method invoke");
    }

    private void doAfter() {
        System.out.println("after method invoke");
    }

}

public class DynamicProxyJDKDemo {
    public static void main(String[] args) {
        Animal dog = new Dog();
        AnimalProxy handler = new AnimalProxy(new Dog());
        //创建动态代理对象
        Animal proxy = (Animal) Proxy.newProxyInstance(
                dog.getClass().getClassLoader(),
                dog.getClass().getInterfaces(),
                handler);
        proxy.makeSound("Doggy");
        //catProxy.makeSound("Catty");
    }
}