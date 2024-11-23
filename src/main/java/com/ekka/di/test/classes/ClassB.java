package com.ekka.di.test.classes;

import com.ekka.di.test.interfaces.InterfaceB;

public class ClassB implements InterfaceB {
    @Override
    public String sayGoodBye() {
        return "Bye Bye";
    }
}
