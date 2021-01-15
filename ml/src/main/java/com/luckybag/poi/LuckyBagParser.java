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
        Row row = iterator.next();
        while (iterator.hasNext()) {
            PersonInfo person = new PersonInfo();
            row = iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            person.setLevel1(row.getCell(3).toString());
            person.setLevel2(row.getCell(4).toString());
            person.setLevel3(row.getCell(5).toString());
            person.setLevel4(row.getCell(6).toString());
            person.setName(row.getCell(7).toString());
            person.setPhone(row.getCell(8).toString());
            person.setAmount(row.getCell(9).toString());
            person.setId(row.getRowNum() + 100 + "");

            list.add(person);
        }
        return list;
    }


}
