package com.luckybag;

import com.luckybag.controller.LuckyBagController;
import org.junit.jupiter.api.Test;

public class Main {

    public static void main(String[] args) {



    }

    /**
     * 根据人员名单进行：
     * 1. 部门数据初始化
     * 2. 人员信息初始化
     * 3. 福金预置
     */
    @Test
    public void init(){
        String filePath = "D:\\github\\NK_Utils\\ml\\src\\main\\resources\\luckybag\\rosterlist-20210121.xlsx";
        new LuckyBagController().insertExcelIntoDB(filePath);
    }


    /**
     * 给指定的人预充指定的福金
     */
    @Test
    public void addAmountForUser(){
        int amount = 25;
        String userPhone = "15395150909";
        new LuckyBagController().addLuckyBagAmountForUser(userPhone,amount);
    }




}
