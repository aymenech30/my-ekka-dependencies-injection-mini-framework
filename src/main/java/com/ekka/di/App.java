package com.ekka.di;

import com.ekka.di.config.IoCOrDIContainer;
import com.ekka.di.test.classes.ClassA;
import com.ekka.di.test.classes.ClassB;
import com.ekka.di.test.interfaces.InterfaceA;
import com.ekka.di.test.interfaces.InterfaceB;

class MyIoCContainer extends IoCOrDIContainer {
    @Override
    protected void configure() {
        super.registry
                .from(InterfaceA.class)
                .to(ClassA.class)
                .and()
                .from(InterfaceB.class)
                .to(ClassB.class);
        super.registry.printMappingContainer();
    }
}

public class App {

    public static void main( String[] args ) {
        IoCOrDIContainer ioc = new MyIoCContainer();
        ioc.runTest();
    }
}
