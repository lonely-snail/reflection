package com.dianju.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ManHandler  implements InvocationHandler {

    private   Man   man;
    public   ManHandler(Man  man){
        this.man=man;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(man,null);
        after();
        return null;
    }

    /**
     * 前置通知
     */
    public   void  before(){
        System.out.println("没有找到你之前，要从内而外的做好自己");
    }

    /**
     * 后置通知
     */
    public   void  after(){
        System.out.println("找到你之后，要相亲相爱过一辈子");
    }
}
