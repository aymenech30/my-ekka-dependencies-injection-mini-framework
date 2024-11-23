package com.ekka.di.test.classes;

import com.ekka.di.test.interfaces.InterfaceA;

public class ClassA implements InterfaceA {
    @Override
    public String sayHello() {
        return "Hello World !!!";
    }
}
