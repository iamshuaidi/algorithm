package test;

import java.util.ArrayList;
import java.util.List;

public class GernerTypes {
//    public static void  method(List<Integer> list) {
//        System.out.println("List<Integer> list");
//    }
    public static void method(List<String> list) {
        System.out.println("List<String> list");
    }

    // 反编译之后的代码
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        System.out.println((Integer)list.get(0));
    }
}
