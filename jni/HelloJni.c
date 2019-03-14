#include <jni.h>
#include <stdio.h>
#include "com_jacle_jdk_helloNative.h"
#include "com_jacle_jdk_NativeWithParamWithoutReturn.h"

JNIEXPORT void JNICALL Java_com_jacle_jdk_HelloNative_sayHello(JNIEnv *env, jobject thisObject)
{
   printf("first jni");
   return;
}

//固定的有两个参数，其余的方法参数跟在后面
JNIEXPORT void JNICALL Java_com_jacle_jdk_NativeWithParamWithoutReturn_nativeWithParam
  (JNIEnv *env, jobject thisObject, jstring name, jint age)
  {
     //要对参数进行转码，防止出现乱码
    const char * words=(*env)->GetStringUTFChars(env,name,NULL);
    if(words==NULL)
    {
      return;
    }

     printf("%s  age is %d",words,age);
     (*env)->ReleaseStringUTFChars(env,name,words);
     return;
  }

 JNIEXPORT jstring JNICALL Java_com_jacle_jdk_NativeWithParamWithReturn_nativeWithParam(JNIEnv *env, jobject thisObject, jstring name , jint age)
{
    //创建不定长的数据，其实是通过指针来实现
    const char * words=(*env)->GetStringUTFChars(env,name,NULL);
    char buff[128]={0};
    if(words==NULL)
    {
      return NULL;
    }

     printf("%s  age is %d",words,age);
     sprintf(buff, "hello %s", words);
     (*env)->ReleaseStringUTFChars(env,name,words);
     return  (*env)->NewStringUTF(env,buff);
}


JNIEXPORT jintArray JNICALL Java_com_jacle_jdk_NativeWithParamWithReturn_nativeWithParamArr
  (JNIEnv *env, jobject thisObject, jstring name, jint age)
{
   /*jsize  jlength=9;
   jintArray intArr=(env)->NewIntArray(jlength);
   jsize size = (env)->GetArrayLength(intArr);

   jint *intArray = (*env)->GetIntArrayElements(intArray, JNI_FALSE);

   for(int i=0;i<size;i++)
   {
     intArray[i]=i+19;
   }
   //把jint指针中的元素设置到jintArray对象中
   jintArray newIntArray = *env->NewIntArray(size);
   *env->SetIntArrayRegion(newIntArray, 0, size, intArr);

   return newIntArray;*/
}

/*
JNIEXPORT jobject JNICALL Java_com_jacle_jdk_NativeWithParamWithReturn_nativeWithParamList
  (JNIEnv *, jobject, jstring, jint)
{



}
*/

