package hrssc.utils;

import org.junit.Test;

public class StringTest {

    @Test
    public void test01(){
        String[] arr = {"牛","气","冲","天"};
        for(int i = 0; i < 100;i++){
            System.out.print(arr[i%arr.length]);
        }
    }
}
