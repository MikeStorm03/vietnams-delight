package com.msg.vietnamsdelight.multiloader_compat.fd_classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class FDClass {

    private final Class<?> clazz;

    public FDClass(String name){
        this.clazz = this.getClass(name);
    }

    private Class<?> getClass(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find " + name + " class", e);
        }
    }

    public Object getField(String field) {
        
        try {
            return this.clazz.getField(field).get(null);
        } catch (Exception e) {
            throw new RuntimeException("Cannot find " + field + " field", e);
        }
    }

    public class FDMethod {
        private final Method method;

        public FDMethod(String name, Class<?>... classes){
            this.method = this.getMethod(name, classes);
        }

        private Method getMethod(String method, Class<?>... classes) {
            
            try {
                return clazz.getMethod(method, classes);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot find " + method + " method", e);
            }
        }

        public Object get(Object... args) {
            try {
                if (Modifier.isStatic(this.method.getModifiers())) {
                    return this.method.invoke(null, args);
                }
                return this.method.invoke(clazz.getDeclaredConstructor().newInstance(), args);
            } catch (Exception e) {
                throw new RuntimeException("Cannot invoke " + this.method.getName() + " method", e);
            }
        }
    }
    public class FDConstructor {
        private final Constructor<?> constructor;

        public FDConstructor(Class<?>... classes){
            this.constructor = this.getConstructor(classes);
        }

        public Constructor<?> getConstructor(Class<?>... classes) {
            try {
                return clazz.getConstructor(classes);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot find " + clazz.getName() + " constructor", e);
            }
        }

        public Object newInstance(Object... args) {
            try {
                return this.constructor.newInstance(args);
            } catch (Exception e) {
                throw new RuntimeException("Cannot create new " + clazz.getName(), e);
            }
        }
    }
}
