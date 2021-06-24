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
//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";


    //开发环境数据库的用户名与密码
//    static final String USER_DEV = "zhongkeuser1";
//    static final String DB_URL_DEV = "jdbc:mysql://10.5.4.106:3306/ZKML_HRSSC_DB?useUnicode=true&characterEncoding=UTF-8";
//    static final String PASSWORD_DEV = "A$@j7O$Gra";


    //【2021-0208】您的【天翼云】 测试环境
//    static final String USER_DEV = "zkluckybaguser";
//    static final String DB_URL_DEV = "jdbc:mysql://101.89.219.3:33891/zkml_lucky_bag_test?useUnicode=true&characterEncoding=UTF-8";
//    static final String PASSWORD_DEV = "bh3H!RAw3E43ID";

    //【2021-0208】您的【localhost】 测试环境
    static final String USER_DEV = "root";
    static final String DB_URL_DEV = "jdbc:mysql://localhost:3306/zkml_lucky_bag_0208?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8";
//                                    jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
    static final String PASSWORD_DEV = "Niukun@12";

//   【已经弃用】【年会期间使用的数据库】，DBA已经收回控制权限，目前只读
//    static final String USER_PRO = "zkluckybaguser";
//    static final String DB_URL_PRO = "jdbc:mysql://121.37.189.223:33917/zkml_lucky_bag?useUnicode=true&characterEncoding=UTF-8";
//    static final String PASSWORD_PRO = "bh3H!RAw3E43ID";
//


    // 【慎用！！！！！】
    //【2021-0208】您的【天翼云】数据库已经创建成功。DBName：zkml_lucky_bag_0208，User：zkluckybaguser，Password: bh3H!RAw3E43ID，
    // 公网IP：101.89.219.3，Port：33891 ，内网IP：172.16.0.231，Port：33891。请您及时做连接测试。
//    static final String USER_PRO = "zkluckybaguser";
//    static final String DB_URL_PRO = "jdbc:mysql://101.89.219.3:33891/zkml_lucky_bag_0208?useUnicode=true&characterEncoding=UTF-8";
//    static final String PASSWORD_PRO = "bh3H!RAw3E43ID";


    static boolean isDev = true;

    public static Connection getConnection() {
        try {

            if (isDev) {
                return DriverManager.getConnection(DB_URL_DEV, USER_DEV, PASSWORD_DEV);
            }
            //【慎用！！！】下面的语句返回福袋线上环境连接，需要操作线上环境是手动打开
//            return DriverManager.getConnection(DB_URL_PRO, USER_PRO, PASSWORD_PRO);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
