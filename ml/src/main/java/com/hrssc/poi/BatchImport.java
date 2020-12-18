package com.hrssc.poi;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BatchImport {
    public static void main(String[] args) {
//        createXLSFile("demo.xls");
        readXLSFile("demo.xls");
    }

    private static void readXLSFile(String fileName) {
        try {
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(fileName));
            HSSFSheet first_sheet = wb.getSheet("first sheet");
            System.out.println(first_sheet.getRow(0).getCell(0));
            System.out.println(first_sheet.getRow(0).getCell(1));
            System.out.println(first_sheet.getRow(0).getCell(2));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void createXLSFile(String fileName) {
        Workbook wb = new HSSFWorkbook();
        Sheet first_sheet = wb.createSheet("first sheet");
        Row row = first_sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("cell value");
        row.createCell(1).setCellValue("2nd value");
        row.createCell(2).setCellValue("3rd value");
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            wb.write(fos);
            fos.close();
            System.out.println("success...");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
