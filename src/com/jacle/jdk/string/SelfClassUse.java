package com.jacle.jdk.string;

/**
 * 关于定义一个类，本身调用自己
 * 此种情况参照java.lang.String
 */
public class SelfClassUse
{
    private int selfVar;
    //变量为基本类型final，本身不能改变
    public final int var1=0;
    //变量为final引用变量，本身是可以改变的
    public final int[] arr1=new int[9];

    //返回的对象类型跟输入参数的对象类型一致，此时如果都是定义在此类型内
    //都是可以分此类对象的私有的变量、方法
    //方法的参数类型 跟定义类类型相同
    public SelfClassUse newInstance(SelfClassUse instance)
    {
        this.selfVar=instance.selfVar;
        return null;
    }

    public SelfClassUse()
    {

    }

    public SelfClassUse(int[] a)
    {
        arr1[0]=1;
    }

    public static void main(String[] args)
    {
       SelfClassUse selfClassUse=new SelfClassUse();
//       selfClassUse.var1=1;
       int[] arr={1,2,3};
       selfClassUse.arr1[0]=2;
    }

}
