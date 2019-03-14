package com.jacle.jdk.jni;

import java.util.List;

/**
 * jdk源码中的native实例
 * <p>
 * java native其实就是java调用c，从而调用操作系统底层服务的方式
 */
public class NativeWithParamWithReturn {
    private native String nativeWithParam(String name, int age);

    private native int[] nativeWithParamArr(String name, int age);

    private native List<String> nativeWithParamList(String name, int age);

    static {
        System.loadLibrary("HelloJni");
    }

    public static void main(String[] args) {
       String returnStr= new NativeWithParamWithReturn().nativeWithParam("杰克", 23);
       System.out.println(returnStr);
    }

}
