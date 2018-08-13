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
    // 被代理的对象(委托类
    // )
    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     *
     * @param target
     * @return Object
     */
    Object getInstance(Object target) {
        this.target = target;
        // 取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;
        System.out.println("方法调用前操作..");
        // 执行被调用方法主体
        result = method.invoke(target, args);
        System.out.println("方法调用后操作..");
        return result;
    }

}

public class DynamicProxyJDKDemo {
    public static void main(String[] args) {
        AnimalProxy proxy = new AnimalProxy();
        Animal dogProxy = (Animal) proxy.getInstance(new Dog());
        Animal catProxy = (Animal) proxy.getInstance(new Cat());
        dogProxy.makeSound("Tom");
        dogProxy.makeSound("XiaoTianXin");
    }
}