package com.niukun.itf;

public class VUtils {



    public static void main(String[] args) {

        FunctionItf f = (str1, str2) -> "hello " + str1 + str2;
        String printStr = f.printStr("A&", "B");
        System.out.println("printStr = " + printStr);

        


    }

    public static String aa(String a){
        if(a == "a"){
            return "a";
        }else{
            return "b";
        }
    }

}
