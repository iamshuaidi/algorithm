package test;

import java.util.ArrayList;
import java.util.List;

// 可变对象
class Man {
}
public class Animal {
    private Man man = null;

    public Animal() {

    }

    public Animal(Man man) {
        this.man = man;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    // 测试
    public static void main(String[] agrs) {
        int k = 1;
        for (int i = 0; i < 20; i++) {
            k = k * 7;
            k = k % 100;
            System.out.println(k);
        }
    }
}
