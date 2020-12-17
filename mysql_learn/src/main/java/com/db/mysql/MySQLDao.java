package com.db.mysql;

import com.utils.MySQLUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDao {
    static Connection conn = MySQLUtil.getConnection();

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("mysql_learn/src/main/resources/room.txt");
        BufferedReader bufr = new BufferedReader(fr);
        String line = null;
        String[] strs = new String[3];
        long start = System.currentTimeMillis();

        int i = 0;
        while ((line = bufr.readLine()) != null) {
            strs = line.split(",");
            if (i++ % 1000 == 0) {
                System.out.println(i);
            }
            insertRecordIntoRoom(strs[0], strs[1], strs[2]);

        }
        System.out.println("导入一千万条数据用时：");
        System.out.println((System.currentTimeMillis() - start)/1000);


    }

    public static void insertRecordIntoRoom(String area, String roomnumber, String price) {

        String sql = "insert into ml_room (area,roomnumber,price) values (" + area + "," + roomnumber + "," + price + ")";

//        System.out.println("sql is: " +sql);

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            boolean execute = stmt.execute(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
