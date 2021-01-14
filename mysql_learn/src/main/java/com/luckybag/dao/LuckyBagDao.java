package com.luckybag.dao;

import com.utils.MySQLUtil;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

public class LuckyBagDao {
    static Connection connection = MySQLUtil.getConnection();
    private static PreparedStatement ps = null;



    public static void insertIntoDepartment(Set<String> parentSet) {
        String sql = null;

        Iterator<String> iterator = parentSet.iterator();

        int i = 10;
        while (iterator.hasNext()){

            sql = "insert into department (id,name,code,parentid) values (?,?,?,?)";
            System.out.println(sql);
            Statement stmt = null;

            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, i+"");

                ps.setString(2,  new String(iterator.next().getBytes("GBK"),"UTF-8"));

                ps.setString(3, i + "");
                ps.setString(4, "0");
                int result = ps.executeUpdate();
                if (result != 0) {
                    System.out.println("第 " + i+" 条数据插入成功！");
                }
                i++;

            } catch (SQLException | UnsupportedEncodingException throwables) {
                throwables.printStackTrace();
            }

        }
        System.out.println("level 1 department insert successfully");


    }

    public static void insertIntoDepartment(Set<String> departmentSet, Set<String> parentSet) {
    }
}
