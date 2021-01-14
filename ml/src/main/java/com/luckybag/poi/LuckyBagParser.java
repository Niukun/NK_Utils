package com.luckybag.poi;

import com.luckybag.bean.PersonInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LuckyBagParser {


    public List<PersonInfo> parseExcelFile(File file) throws Exception {

        List<PersonInfo> list = new ArrayList<PersonInfo>();
        FileInputStream fip = new FileInputStream(file);
        if (file.isFile() && file.exists()) {
            System.out.println(
                    "openworkbook.xlsx file open successfully.");
        } else {
            System.out.println(
                    "Error to open openworkbook.xlsx file.");
        }

        XSSFWorkbook workbook = new XSSFWorkbook(fip);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.rowIterator();
        Row next = iterator.next();
        while (iterator.hasNext()) {
            PersonInfo person = new PersonInfo();
            next = iterator.next();
            Iterator<Cell> cellIterator = next.cellIterator();
            person.setLevel1(next.getCell(3).toString());
            person.setLevel2(next.getCell(4).toString());
            person.setLevel3(next.getCell(5).toString());
            person.setLevel4(next.getCell(6).toString());
            person.setName(next.getCell(7).toString());
            person.setPhone(next.getCell(8).toString());

            list.add(person);
        }
        return list;
    }




}
