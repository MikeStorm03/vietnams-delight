package com.msg.vietnamsdelight.multiloader_compat.registers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;


public final class RegistryHelper<T> {
    private final String namespace;
    private final Map<String, Supplier<T>> suppliers = new LinkedHashMap<>();

    public RegistryHelper(String namespace) {
        this.namespace = namespace;
    }

    public Supplier<T> register(String name, Supplier<T> supplier) {
        suppliers.put(name, supplier);
        return () -> suppliers.get(name).get();
    }

    public String namespace() {
        return this.namespace;
    }

    public Map<String, Supplier<T>> getSuppiers(){
        return suppliers;
    }
}