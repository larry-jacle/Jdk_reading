package com.jacle.jdk.jni;

/**
 * jdk源码中的native实例
 *
 * java native其实就是java调用c，从而调用操作系统底层服务的方式
 */
public class HelloNative
{
    public native void sayHello();

    static
    {
        System.loadLibrary("HelloJni");
    }

    public static void main(String[] args)
    {
       new HelloNative().sayHello();
    }

}
