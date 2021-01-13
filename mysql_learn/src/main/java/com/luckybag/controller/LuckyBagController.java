package com.luckybag.controller;


public class LuckyBagController {
    public void insertExcelIntoDB(String filePath) {

        new LuckyBagService().insertExcelIntoDB(filePath);
    }
}
