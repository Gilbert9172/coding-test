package map;

import java.util.*;

public class TreeMapEx {

    public static void main(String[] args) {

        Man man = new Man();
        man.method1();

        Woman woman = new Woman();
        woman.method1();
    }


}

class Man extends Person {
    @Override
    void method1() {
        System.out.println(getClass());
    }
}

class Woman extends Person {
    @Override
    void method1() {
        System.out.println(getClass());
    }
}

abstract class Person {
    abstract void method1();
}

