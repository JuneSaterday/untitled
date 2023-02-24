package org.example.one;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicProxy {


    public static void main(String[] args) {

        Hello helloImpl = new HelloImpl();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(helloImpl);


        Hello proxyHello = (Hello)Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),
                HelloImpl.class.getInterfaces(), myInvocationHandler);


        proxyHello.sayHello();



    }










}
