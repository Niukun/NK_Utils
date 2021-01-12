package hrssc.utils;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.hrssc.utils.ArrayUtils.smartPrint;


public class ArrayUtilsTest {

    @Test
    public void testSmartPrint(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("e");
        list.add("t");
        System.out.println(list.contains("a"));
        smartPrint(list);
    }


    @Test
    public void testStringSplit(){
        String str = "总经办|平台中心|运营中心|4465465";
        String str1 = "总经办,平台中心,运营中心,4465465";
        String[] split = str.split("\\|");
        for (String s:
                split) {
            System.out.println(s);
        }
    }

}
