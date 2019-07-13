package proxy;

public class HelloImp implements Hello {
    @Override
    public void sayHello(String str) {
        System.out.println("HelloImp " + str );
    }
}
