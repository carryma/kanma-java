### ClassLoader的问题
不同classloader装载的类不能互相访问？
```java
public class CLTest {
    public void parse(String s){
    System.out.println(s);
    }
    public static void main(String[] args) {
    String str = new String("ok");  //String 类是又启动类装载器装载的
    CLTest test = new CLTest();     //CLTest类是有系统类装载器装载的
    test.parse(str);                //这叫做互相访问吗？
    }
}
```
### 解释:
一，有两个术语，一个叫“定义类加载器”，一个叫“初始类加载器”。
比如有如下的类加载器结构：
bootstrap
  ExtClassloader
    AppClassloader
    -自定义clsloadr1
    -自定义clsloadr2 
如果用“自定义clsloadr1”加载java.lang.String类，那么根据双亲委派最终bootstrap会加载此类，那么bootstrap类就叫做该类的“定义类加载器”，
而包括bootstrap的所有得到该类class实例的类加载器都叫做“初始类加载器”。

二，所说的“命名空间”，是指jvm为每个类加载器维护的一个“表”,这个表记录了所有以此类加载器为“初始类加载器”（而不是定义类加载器，
所以一个类可以存在于很多的命名空间中）加载的类的列表，所以，题目中的问题就可以解释了：
CLTest是AppClassloader加载的，String是通过加载CLTest的类加载器也就是AppClassloader进行加载，但最终委派到bootstrap加载的（当然，
String类其实早已经被加载过了，这里只是举个例子）。所以，对于String类来说，bootstrap是“定义类加载器”，AppClassloader是“初始类加载器”。
根据刚才所说，String类在AppClassloader的命名空间中（同时也在bootstrap，ExtClassloader的命名空间中，因为bootstrap，ExtClassloader也是String的
初始类加载器），所以CLTest可以随便访问String类。这样就可以解释“处在不同命名空间的类，不能直接互相访问”这句话了。

三，一个类，由不同的类加载器实例加载的话，会在方法区产生两个不同的类，彼此不可见，并且在堆中生成不同Class实例。

四，那么由不同类加载器实例（比如-自定义clsloadr1，-自定义clsloadr2）所加载的classpath下和ext下的类，也就是由我们自定义的类加载器委派给
AppClassloader和ExtClassloader加载的类，在内存中是同一个类吗？
所有继承ClassLoader并且没有重写getSystemClassLoader方法的类加载器，通过getSystemClassLoader方法得到的AppClassloader都是同一个AppClassloader实例，
类似单例模式。
在ClassLoader类中getSystemClassLoader方法调用私有的initSystemClassLoader方法获得AppClassloader实例，在initSystemClassLoader中：
sun.misc.Launcher l = sun.misc.Launcher.getLauncher();
。。。
scl = l.getClassLoader();
AppClassloader是sun.misc.Launcher类的内部类，Launcher类在new自己的时候生成AppClassloader实例并且放在自己的私有变量loader里：
loader = AppClassLoader.getAppClassLoader(extclassloader);
值得一提的是sun.misc.Launcher类使用了一种类似单例模式的方法，即既提供了单例模式的接口getLauncher()又把构造函数设成了public的。
但是在ClassLoader中是通过单件模式取得的Launcher 实例的，所以我们写的每个类加载器得到的AppClassloader都是同一个AppClassloader类实例。
这样的话得到一个结论，就是所有通过正常双亲委派模式的类加载器加载的classpath下的和ext下的所有类在方法区都是同一个类，堆中的Class实例也是同一个。