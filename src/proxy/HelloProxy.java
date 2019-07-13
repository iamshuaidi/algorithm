package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloProxy implements InvocationHandler {
    private Hello hello;

    public HelloProxy(Hello hello) {
        this.hello = hello;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK 自带的动态代理");
        return method.invoke(hello, args);

    }

    public static void main(String[] args) {
        Hello hello = (Hello)Proxy.newProxyInstance(HelloProxy.class.getClassLoader(),
                new Class<?>[]{Hello.class},
                new HelloProxy(new HelloImp()));
        hello.sayHello("hah");
    }
}
