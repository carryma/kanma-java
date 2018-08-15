package com.kanma.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class AnimalProxy2 implements InvocationHandler {
    // 要代理的对象
    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
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

public class DynamicProxyJDKDemo2 {
    public static void main(String[] args) {
        //两个代理对象
        AnimalProxy2 proxy1 = new AnimalProxy2();
        AnimalProxy2 proxy2 = new AnimalProxy2();
        Animal dogProxy = (Animal) proxy1.getInstance(new Dog());
        Animal catProxy = (Animal) proxy2.getInstance(new Cat());
        dogProxy.makeSound("Doggy");
        catProxy.makeSound("Catty");
    }
}