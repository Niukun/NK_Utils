package com.luckybag.service;


import com.luckybag.dao.LuckyBagDao;
import com.luckybag.entity.PersonInfo;
import com.luckybag.poi.LuckyBagParser;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LuckyBagService {

    public void insertExcelIntoDB(File file) {
        LuckyBagParser luckyBagParser = new LuckyBagParser();
        try {
            List<PersonInfo> personInfos = luckyBagParser.parseExcelFile(file);
            Set<String> level1Set = new HashSet<String>();
            Set<String> level2Set = new HashSet<String>();
            Set<String> level3Set = new HashSet<String>();
            Set<String> level4Set = new HashSet<String>();
            Iterator<PersonInfo> iterator = personInfos.iterator();
            PersonInfo personInfo = null;
            while(iterator.hasNext()){
                 personInfo = iterator.next();
                 level1Set.add(personInfo.getLevel1());
                 level2Set.add(personInfo.getLevel2());
                 level3Set.add(personInfo.getLevel3());
                 level4Set.add(personInfo.getLevel4());
            }

            level1Set.remove(null);
            level2Set.remove(null);
            level3Set.remove(null);
            level4Set.remove(null);
            System.out.println("");
            
            LuckyBagDao.insertIntoDepartment(level1Set);
            LuckyBagDao.insertIntoDepartment(level2Set,level1Set);
            LuckyBagDao.insertIntoDepartment(level3Set,level2Set);
            LuckyBagDao.insertIntoDepartment(level4Set,level3Set);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
