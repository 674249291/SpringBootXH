package com.xj.shejimoshi.decorator;

/**
 * 装饰器模式的应用场景：

 1、需要扩展一个类的功能。

 2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）

 缺点：产生过多相似的对象，不易排错！
 * Created by xiong on 2018/3/7.
 */
public class TestDecorator {

    public static void main(String[] args) {
        Source source = new Source();
        SourceAble decorator = new Decorator(source);
        decorator.method1();
    }
}
