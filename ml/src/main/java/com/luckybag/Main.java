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
        String filePath = "D:\\github\\NK_Utils\\ml\\src\\main\\resources\\luckybag\\rosterlist-0208.xlsx";
        new LuckyBagController().insertExcelIntoDB(filePath);
    }


    /**
     * 给指定的人预充指定的福金
     */
    @Test
    public void addAmountForUser(){
        int amount = 1648;
//        String userPhone = "18225602803";
        LuckyBagController luckyBagController = new LuckyBagController();
//        luckyBagController.addLuckyBagAmountForUser("15021597239",amount);//牛坤
//        luckyBagController.addLuckyBagAmountForUser("15555398990",amount);//顾帅
//        luckyBagController.addLuckyBagAmountForUser("18225602803",amount);//纪文静
//        luckyBagController.addLuckyBagAmountForUser("19956900544",amount);//卢鲁
        luckyBagController.addLuckyBagAmountForUser("15375491107",amount);//朱文睿
//        luckyBagController.addLuckyBagAmountForUser("13501860599",amount);//卢老师
//        luckyBagController.addLuckyBagAmountForUser("19965048045",amount);//束程晨
//        luckyBagController.addLuckyBagAmountForUser("18715079204",amount);//张运鑫
//        luckyBagController.addLuckyBagAmountForUser("18119992002",amount);//罗健飞
    }




}
