package com.luckybag.controller;


import com.luckybag.service.LuckyBagService;

import java.io.File;

public class LuckyBagController {
    public void insertExcelIntoDB(String filePath) {

        LuckyBagService luckyBagService = new LuckyBagService();
        luckyBagService.insertExcelIntoDB(new File(filePath));

    }
}
