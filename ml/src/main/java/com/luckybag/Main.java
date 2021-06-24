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
//        【！！！！！先去查看连的数据库对不对】
        new LuckyBagController().insertExcelIntoDB(filePath);
    }


    /**
     * 给指定的人预充指定的福金
     */
    @Test
    public void addAmountForUser(){
//        int amount = 5000000;
//        【！！！！！先去查看连的数据库对不对】
//        String userPhone = "18225602803";
        LuckyBagController luckyBagController = new LuckyBagController();
        luckyBagController.addLuckyBagAmountForUser("18119992099",22000); //吴仲城
        luckyBagController.addLuckyBagAmountForUser("18119992002",11000);//罗健飞
        luckyBagController.addLuckyBagAmountForUser("18119992001",7000);//武理芬
        luckyBagController.addLuckyBagAmountForUser("15255185573",7000);//庾朝富
        luckyBagController.addLuckyBagAmountForUser("13773655673",7000);//王磊
        luckyBagController.addLuckyBagAmountForUser("13855175610",4000);//吴飞
        luckyBagController.addLuckyBagAmountForUser("13501860599",4000);//卢小垂
        luckyBagController.addLuckyBagAmountForUser("18956071203",4000);//李勇
        luckyBagController.addLuckyBagAmountForUser("18326188123",4000);//胡成龙

    }

//        luckyBagController.addLuckyBagAmountForUser("15021597239",11111);//牛坤
//        luckyBagController.addLuckyBagAmountForUser("15555398990",22222);//顾帅
//        luckyBagController.addLuckyBagAmountForUser("18225602803",33333);//纪文静
//        luckyBagController.addLuckyBagAmountForUser("19956900544",44444);//卢鲁
//        luckyBagController.addLuckyBagAmountForUser("15375491107",55555);//朱文睿
//        luckyBagController.addLuckyBagAmountForUser("15862518424",66666);//邓晨皓
//        luckyBagController.addLuckyBagAmountForUser("13501860599",amount);//卢老师
//        luckyBagController.addLuckyBagAmountForUser("19965048045",77777);//束程晨
//        luckyBagController.addLuckyBagAmountForUser("15156079323",88888);//王浩然
//        luckyBagController.addLuckyBagAmountForUser("18715079204",amount);//张运鑫
//        luckyBagController.addLuckyBagAmountForUser("18119992002",amount);//罗健飞


}
