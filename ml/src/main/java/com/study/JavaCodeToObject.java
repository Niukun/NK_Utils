package com.study;

import org.junit.jupiter.api.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class JavaCodeToObject {


    @Test
    public void testJavaCodeToObj() throws Exception {
        System.out.println(System.getProperty("user.dir"));
        //动态编译
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        int status = javac.run(null, null, null, "-d", System.getProperty("user.dir")+"\\target\\classes","D:/AlTest.java");
        if(status!=0){
            System.out.println("没有编译成功！");
        }

        //动态执行
        Class clz = Class.forName("AlTest");//返回与带有给定字符串名的类 或接口相关联的 Class 对象。
        Object o = clz.newInstance();
        Method method = clz.getDeclaredMethod("sayHello");//返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法
        String result= (String)method.invoke(o);//静态方法第一个参数可为null,第二个参数为实际传参
        System.out.println(result);



    }

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));
    }

}
