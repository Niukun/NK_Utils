package com.niukun.jmx;

public class Hello implements HelloMBean {
    private final String name = "Reginald";
    private int cacheSize = DEFAULT_CACHE_SIZE;
    private static final int
            DEFAULT_CACHE_SIZE = 200;

    @java.lang.Override
    public void sayHello() {
        System.out.println("hello, world");
    }

    @java.lang.Override
    public int add(int x, int y) {
        return x + y;
    }

    @java.lang.Override
    public String getName() {
        return this.name;
    }

    @java.lang.Override
    public int getCacheSize() {
        return this.cacheSize;
    }

    @java.lang.Override
    public void setCacheSize(int size) {
        this.cacheSize = size;
        System.out.println("Cache size now " + this.cacheSize);
    }
}
