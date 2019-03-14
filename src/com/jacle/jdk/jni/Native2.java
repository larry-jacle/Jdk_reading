package com.jacle.jdk.jni;

import com.jacle.jdk.default_package.PublicDefaultClass;

/**
 * jdk源码中的native实例
 *
 * java native其实就是java调用c，从而调用操作系统底层服务的方式
 */
public class Native2
{
    private native void nativeHello();

    static
    {
//        System.loadLibrary("native2");
    }

    public static void main(String[] args)
    {
//       new Native2().nativeHello();
         int flag=new PublicDefaultClass().testDefaultDecoration();
         System.out.println(flag);
    }

}
