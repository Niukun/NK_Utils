package com.hrssc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//    人力资源平台 paas平台数据库
//    10.5.4.106	3306
//    zhongkeuser1
//    A$@j7O$Gra

public class DBUtils {
    //JDBC驱动名以及数据库URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://10.5.4.106:3306/ZKML_HRSSC_DB?useUnicode=true&characterEncoding=UTF-8";

    //数据库的用户名与密码
    static final String USER = "zhongkeuser1";
    static final String PASSWORD = "A$@j7O$Gra";
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(DB_URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
