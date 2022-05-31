package com.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyTest {
    public static void main(String[] args) {
        Object proxy = getProxy(new AImpl(10));
        A a = (A) proxy;
        a.print_a();

        Object proxy1 = getProxy(new BImpl());
        B b = (B) proxy1;
        b.print_b();
    }

    private static Object getProxy(final Object a) {
        return Proxy.newProxyInstance(A.class.getClassLoader(), a.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("调用前, 可以打印日志1");
                Object invoke = method.invoke(a, args);
                System.out.println("调用后, 可以打印日志2");
                return invoke;
            }
        });
    }
}
