package hrssc.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringTest {

    @Test
    public void test01(){
        String[] arr = {"牛","气","冲","天"};
        for(int i = 0; i < 100;i++){
            System.out.print(arr[i%arr.length]);
        }
    }

    @Test
    public void test(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
