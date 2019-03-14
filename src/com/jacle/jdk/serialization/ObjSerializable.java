package com.jacle.jdk.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * 测试序列化的对象，读取的时候是否执行构造方法
 */
public class ObjSerializable
{
    public static void main(String[] args) throws IOException {
       //测试序列化以及transient
   /*     Individual person=new Individual();
        person.setName("jacle");
        person.setAge(23);

        ObjectOutputStream objectoutputstream=new ObjectOutputStream(new FileOutputStream("./Indiviual.out"));
        objectoutputstream.writeObject(person);*/

        //读取序列化数据，重新生成对象
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("./indiviual.out"));
        try {
            Individual de_indiviual=(Individual) objectInputStream.readObject();
            System.out.println(de_indiviual);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        objectInputStream.close();

    }
}

//不能跟这个包下面的类重名
class Individual  implements Serializable
{
   private String name;
   private int age;
   private transient String desp;

   public Individual()
   {
       //序列化恢复成对象实例的时候，不会调用构造方法
       desp="use construct method";
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    @Override
    public String toString() {
        return name+","+age+","+(desp==null||desp.isEmpty()?"not set":desp);
    }
}
