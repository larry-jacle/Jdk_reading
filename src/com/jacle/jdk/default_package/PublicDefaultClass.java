package com.jacle.jdk.default_package;

/**
 *class加上了final无法被继承
 */
public final class PublicDefaultClass implements  DefaultInterface
{
    public static void main(String[] args)
    {
        int result=new PublicDefaultClass().testDefaultDecoration();
        System.out.println(result);
    }

}
