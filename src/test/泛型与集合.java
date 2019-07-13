package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 泛型与集合 {
    public static void main(String[] args) {
        // 1、
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new String("a1"));
        a1.add(new Integer(1));
        // 编译不会出崔，如果把 List a1 改为 List<Object> 则会编译出错
        List<Integer> a2 = a1;
        // 编译会抛出 ClassCastException 异常
     /*   for (Integer a : a2) {
            System.out.println(a);
        }*/

        // 2、
//        List<Integer> t1 = new ArrayList<>();
//        // 编译通过
//        List t2 = t1;
//        //编译失败
//        List<Object> t3 = t1;
        List<Object> t1 = new ArrayList<>();
        List<?> t2 = t1;
        // 编译通过
        t2.remove(0);
        t2.clear();
        // 编译不通过

//        List<Animal> animals = new ArrayList<>();
//        List<Cat> cats = new ArrayList<>();
//        List<RedCat> redCats = new ArrayList<>();
//        // 可以通过编译
//        List<? extends  Cat> extendsCat = redCats;
//        // 不能通过编译，因为只能接受 Cat 及其子类的集合
//        extendsCat = animals;
//
//        // 重点注意：不能通过编译
//        extendsCat.add(new RedCat());
//        // 重点注意：可以通过编译
//        extendsCat.add(null);

        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<RedCat> redCats = new ArrayList<>();
        // 可以通过编译
        List<? super  Cat> superCat = animals;
        // 不能通过编译，因为只能接受 Cat 及其父类的集合
       // superCat = redCats;

        // 重点注意：不能通过编译,只能添加 Cat 及其 Cat 的子类
        //superCat.add(new Animal());
        // 重点注意，可以通过编译
        superCat.add(new Cat());
        superCat.add(new RedCat());
        superCat.add(null);

    }
}

class Cat extends Animal{

}

class RedCat extends Cat{

}