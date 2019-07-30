package com.dianju.myproxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/***
 * 测试调用Man中的findObject方法
 */
public class Test {
    public static void main(String[] args) {
        Man  man = new Zhangfengzhe();
        ManHandler   manHandler = new ManHandler(man);
        //返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。
        Man  proxyMan = (Man) Proxy.newProxyInstance(man.getClass().getClassLoader(),new Class[]{Man.class},manHandler);
        System.out.println(proxyMan.getClass().getName());//生成的动态代理类
        proxyMan.findObject();
        //打印在jvm内存中生成的动态代理类
        createProxyClassFile(Man.class);
    }

    public  static   void   createProxyClassFile(Class  c){
        byte[]   data = ProxyGenerator.generateProxyClass("$Proxy0",new  Class[]{c});
        //写入文件中
        try{
            FileOutputStream   fileOutputStream = new FileOutputStream("$Proxy0.class");
            fileOutputStream.write(data);
            fileOutputStream.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
