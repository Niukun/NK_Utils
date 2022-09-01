package com.me.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseRelFile {

    public static void main(String[] args) {
//        File f = new File("src/main/resources/me/rel-door.txt");
//        System.out.println(f);
        List list = new ArrayList();
        BufferedReader bufr = null;
        try {
            bufr = new BufferedReader(new FileReader(new File("ml/src/main/resources/me/rel-door.txt")));
            String line = null;
            while((line = bufr.readLine())!= null){
                list.add(line);
                System.out.println(line);
            }
            bufr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufr != null){
                try {
                    bufr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            return list;
        }


    }
}
