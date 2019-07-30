package com.dianju.myproxy;

import java.lang.reflect.Method;

public class MyHandler   implements  MyInvocationHandler {

    private  Man  man;

    public  MyHandler(Man  man){
        this.man = man;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(man,null);
        after();
        return object;
    }

    public   void  before(){
        System.out.println("before  find you , i  will  make  self  good.");
    }

    public   void  after(){
        System.out.println("after  find you , i  will  make  ourself  good.");
    }
}
