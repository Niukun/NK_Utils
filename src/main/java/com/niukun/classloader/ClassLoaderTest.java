package com.niukun.classloader;

import org.junit.Test;

import java.net.URLClassLoader;

public class ClassLoaderTest {

    @Test
    public void testIt(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        System.out.println(classLoader.toString());
    }

}
