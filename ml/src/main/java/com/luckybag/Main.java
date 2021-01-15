package com.luckybag;

import com.luckybag.controller.LuckyBagController;

public class Main {
    private static String filePath;

    static {
        filePath = "D:\\github\\NK_Utils\\ml\\src\\main\\resources\\luckybag\\rosterlist-20210113.xlsx";
    }

    public static void main(String[] args) {

        /**
         * 根据人员名单进行：
         * 1. 部门数据初始化
         * 2. 人员信息初始化
         * 3. 福金预置
         */
        new LuckyBagController().insertExcelIntoDB(filePath);
    }
}
