package com.jacle.jdk.string;

/**
 * 测试final修饰方法的时候
 */
public class Person
{
    private final void method1()
    {
        System.out.println("person final private");
    }

    public final void method2()
    {
        System.out.println("person final public");
    }

    public static void main(String[] args)
    {
        Person p=new Person();
        p.method1();

        Stu stu=new Stu();

        //定义的时候语法通过，但是调用的时候仍然认为是错误
//        stu.method1();

    }
}

class Stu extends Person
{
    private final void method12()
    {
        System.out.println("person final private");
    }

    //非private的final方法不能被重写
//    public final void method2()
//    {
//        System.out.println("person final public");
//    }
}
