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


    //数据库的用户名与密码
    static final String USER_DEV = "zhongkeuser1";
    static final String DB_URL_DEV = "jdbc:mysql://10.5.4.106:3306/ZKML_HRSSC_DB?useUnicode=true&characterEncoding=UTF-8";
    static final String PASSWORD_DEV = "A$@j7O$Gra";

//
//    static final String USER_PRO = "zkluckybaguser";
//    static final String DB_URL_PRO = "jdbc:mysql://121.37.189.223:33917/zkml_lucky_bag?useUnicode=true&characterEncoding=UTF-8";
//    static final String PASSWORD_PRO = "bh3H!RAw3E43ID";
//


    static final String USER_PRO = "zkluckybaguser";
    static final String DB_URL_PRO = "jdbc:mysql://101.91.227.223:33905/zkml_lucky_bag_0207?useUnicode=true&characterEncoding=UTF-8";
    static final String PASSWORD_PRO = "bh3H!RAw3E43ID";


    static boolean isDev = false;

    public static Connection getConnection() {
        try {

            if (isDev) {
                return DriverManager.getConnection(DB_URL_DEV, USER_DEV, PASSWORD_DEV);
            }
            return DriverManager.getConnection(DB_URL_PRO, USER_PRO, PASSWORD_PRO);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
