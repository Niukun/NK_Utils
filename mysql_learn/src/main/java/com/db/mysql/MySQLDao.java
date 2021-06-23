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

    /**
     * 往test数据库中插入100万条数据
     * @throws IOException
     */
    public static void InsertMillionRecords() throws IOException {
        FileReader fr = new FileReader("F:\\Data\\IntellijIdea\\NK_Utils\\mysql_learn\\target\\classes\\address.txt ");
        BufferedReader bufr = new BufferedReader(fr);
        String line = null;
        String[] strs = new String[3];
        long start = System.currentTimeMillis();

        int i = 0;
        while ((line = bufr.readLine()) != null) {
            strs = line.split(",");
            if (i++ % 2 == 0) {
                System.out.println(i);
            }
            insertRecordIntoRoom(strs[0], strs[1], strs[2]);

        }
        System.out.println("导入一千万条数据用时：");
        System.out.println((System.currentTimeMillis() - start)/1000);
    }

    public static void insertRecordIntoRoom(String id, String code, String address) {

        String sql = "insert into ml_room (id,code,address) values (\""  + id + "\",\"" + code + "\",\"" + address + "\")";

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
