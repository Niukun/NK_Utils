package com.hrssc.utils;

import java.util.Iterator;
import java.util.List;

public class ArrayUtils {

    public static void smartPrint(List list){
        if(list.isEmpty() || list == null){
            try {
                throw new Exception("列表是空的");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Iterator iterator = list.iterator();
        Object next = null;
        while(iterator.hasNext()){
            next = iterator.next();
            System.out.println(next);
        }

    }
}
