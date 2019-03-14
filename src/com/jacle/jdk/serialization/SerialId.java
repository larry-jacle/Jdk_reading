package com.jacle.jdk.serialization;

import java.io.*;

/**
 * 对于每个序列化对象都有一个SerialId，对于这个id的作用如下
 */
public class SerialId
{
    public static void main(String[] args) throws IOException {
        //写对象
       /* ObjectOutputStream objectoutputstream=new ObjectOutputStream(new FileOutputStream("./unit.out"));
        for(int i=0;i<19;i++)
        {
            Unit unit=new Unit();
            unit.setSum(100);
            unit.setQuantiy(20);

            objectoutputstream.writeObject(unit);
        }

        objectoutputstream.close();
        */

        //读取序列化对象
        FileInputStream fileInputStream=new FileInputStream("./unit.out");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        try {
            while(fileInputStream.available()>0)
            {
                Unit de_indiviual=(Unit) objectInputStream.readObject();
                System.out.println(de_indiviual);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        fileInputStream.close();
        objectInputStream.close();

    }

}

class Unit implements Serializable
{
    //通过serialVersionUID来进行序列化版本的检查,通过设定这个常量，在改变类的时候，可以进行对序列化类的修改，否则会报不兼容的错误
    private static final long serialVersionUID = -1717099077946840145L;
    private int sum;
    private int quantiy;
    private int total;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(int quantiy) {
        this.quantiy = quantiy;
    }
}
