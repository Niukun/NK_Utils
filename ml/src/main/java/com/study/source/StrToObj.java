package com.study.source;

import org.junit.jupiter.api.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.FileReader;

public class StrToObj {

    @Test
    public void testSrc() throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/hrssc/src.txt"));
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        while ((line = bufferedReader.readLine())!=null){
            stringBuffer.append(line + "\n");
        }
        System.out.println(stringBuffer.toString());

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();




    }

}
