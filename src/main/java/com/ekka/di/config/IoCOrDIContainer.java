package com.ekka.di.config;

import java.util.HashMap;
import java.util.Map;

public abstract class IoCOrDIContainer {

    protected Bound registry;

    protected abstract void configure();

    public void runTest() {
        this.registry = new Bound();
        this.configure();
    }

    protected class Bound {

        private Map<Class<?>, Class<?>> mappingContainer;
        private Class<?> from;
        private Class<?> to;

        public Bound(){
            this.mappingContainer = new HashMap<>();
            this.from = null;
            this.to = null;
        }

        // temporary only for testing purpose
        public void printMappingContainer(){
            this.mappingContainer.keySet()
                    .forEach(cls ->
                            System.out.println(cls.toString() + " --> " + this.mappingContainer.get(cls).toString())
                    );
        }

        public BoundTo from(Class<?> cls){
            return new BoundFrom().from(cls);
        }

        private void pushMapping(){
            if(this.from != null && this.to != null)
                this.mappingContainer.put(this.from, this.to);
            else
                throw new RuntimeException("the pair (from, to) should be different of null !!");
        }

        public class BoundFrom {
            public BoundTo from(Class<?> cls){
                from = cls;
                return new BoundTo();
            }
        }
        public class BoundTo {
            public BoundAnd to(Class<?> cls){
                to = cls;
                pushMapping();
                return new BoundAnd();
            }
        }

        public class BoundAnd {
            public BoundFrom and(){
                return new BoundFrom();
            }
        }

    }


}
