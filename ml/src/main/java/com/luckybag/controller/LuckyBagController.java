package com.luckybag.controller;


import com.luckybag.service.LuckyBagService;

import java.io.File;

public class LuckyBagController {
    public void insertExcelIntoDB(String filePath) {
        new LuckyBagService().insertExcelIntoDB(new File(filePath));

    }

    public void addLuckyBagAmountForUser(String userPhone, int amount) {
        new LuckyBagService().addLuckyBagAmountForUser(userPhone,amount);
    }
}
