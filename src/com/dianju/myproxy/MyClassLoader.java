package com.dianju.myproxy;

import java.io.File;

/***
 * 自定义类加载器
 * 要知道，我们是想手写JDK动态代理，那么我们将自己在内存中生成动态代理类，那么我们如何加载呢？这时候，就可以利用自定义的类加载器做到！
 上述代码，重写了findClass方法，就是为了在指定路径下加载指定的字节码文件
 */
public class MyClassLoader extends   ClassLoader{
     //生成代理类加载路径
     private File   dir;

     private  String   proxyClassPackage;

     public  String  getProxyClassPackage(){
         return   proxyClassPackage;
     }

     public   File getDir(){
         return  dir;
     }

     public  MyClassLoader(String  path,String  proxyClassPackage){
         this.dir  =  new File(path);
         this.proxyClassPackage = proxyClassPackage;
     }
     @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
         if (dir != null) {
             File classFile = new File(dir, name + ".class");
             if (classFile.exists()) {
                /* try {
                     //生成class的二进制字节流
                     //byte[]   classBytes = Filec
                 } catch (Exception e) {
                     e.printStackTrace();
                 }*/

             }
         }
         return   null;
     }
}
