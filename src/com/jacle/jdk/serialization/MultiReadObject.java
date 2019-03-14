package com.jacle.jdk.serialization;


import java.io.*;

/**
 * 测试读取多个序列化对象
 */
public class MultiReadObject
{
    public static void main(String[] args) throws IOException {
        MultiReadObject multiReadObject=new MultiReadObject();
//        multiReadObject.writeObjects();

        //无法直接的给序列化文件追加序列化对象
        multiReadObject.addSerializationObjects();
        multiReadObject.readObjects();
    }


    /**
     * 追加写入序列化对象
     * @throws IOException
     */
    public void addSerializationObjects() throws IOException {

        File file=new File("./Indiviuals.out");
        FileOutputStream fileOutputStream=new FileOutputStream(file,true);
        ObjectOutputStream objectoutputstream=new ObjectOutputStream(fileOutputStream);

        if(file.exists())
        {
            //判断是否有内容
            long pos=fileOutputStream.getChannel().position();
            if(pos>4)
            {
                //截取Header
                fileOutputStream.getChannel().truncate(pos-4);
            }
        }


        for(int i=99;i<120;i++)
        {
            Individual person=new Individual();
            person.setName("jacle"+i);
            person.setAge(23+i);

            objectoutputstream.writeObject(person);
        }

        objectoutputstream.close();

    }

    public void writeObjects() throws IOException {
        ObjectOutputStream objectoutputstream=new ObjectOutputStream(new FileOutputStream("./Indiviuals.out"));
        for(int i=0;i<19;i++)
        {
            Individual person=new Individual();
            person.setName("jacle"+i);
            person.setAge(23+i);

            objectoutputstream.writeObject(person);
        }

        objectoutputstream.close();
    }


    /**
     * 读取多个序列化对象
     * @throws IOException
     */
    public void readObjects() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("./indiviuals.out");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        try {
            while(fileInputStream.available()>0)
            {
                Individual de_indiviual=(Individual) objectInputStream.readObject();
                System.out.println(de_indiviual);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        fileInputStream.close();
        objectInputStream.close();

    }
}
