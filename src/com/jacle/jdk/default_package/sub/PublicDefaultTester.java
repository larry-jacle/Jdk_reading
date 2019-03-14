package com.jacle.jdk.default_package.sub;

import com.jacle.jdk.default_package.PublicDefaultClass;

public class PublicDefaultTester
{
    public static void main(String[] args)
    {
        int flag=new PublicDefaultClass().testDefaultDecoration();
        System.out.println(flag);
    }
}
