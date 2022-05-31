package com.dynamic;

public class AImpl implements A {

    int age;

    public AImpl(int age) {
        this.age = age;
    }

    @Override
    public void print_a() {
        System.out.println('a');
    }

    @Override
    public void print_name(String name) {
        System.out.println(name + ": age=" + this.age);
    }

    @Override
    public int return_number() {
        return 999;
    }
}
