package com.luckybag;

import com.luckybag.controller.LuckyBagController;

public class Main {
    private static String filePath;

    static {
        filePath = "D:\\github\\NK_Utils\\mysql_learn\\src\\main\\resources\\luckybag\\rosterlist-20210113.xlsx";
    }

    public static void main(String[] args) {

        new LuckyBagController().insertExcelIntoDB(filePath);
    }
}
