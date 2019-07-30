package com.dianju.myproxy;

import java.lang.reflect.Method;

/***
 * 自己写的代理接口
 */
public interface MyInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
