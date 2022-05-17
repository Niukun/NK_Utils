package com.niukun.net;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class InetAddressDemo {
    private static Logger logger = Logger.getLogger(InetAddressDemo.class);
    public static final String FIRST_LEVEL = "127.0.0.1";

    public static void main(String[] args) throws Exception {
//        getMD5Str("357725678854269-1881034049");

//        testdb();

        generatekeys();

    }

    private static void generatekeys() throws IOException {
        String[] strs = new String[]{"0","1","2"};
        char[] chars = "0123456789abcdef".toCharArray();

        long l = 1l;
        BufferedWriter bufw = new BufferedWriter(new FileWriter("keys1.txt"));
        for(char a1 : chars){
            for(char a2 : chars){
                for(char a3 : chars){
                    for(char a4 : chars){
                        for(char a5 : chars){
                            for(char a6 : chars){
//                                bufw.write(""+a1+a2+a3+a4+a5+a6+a6);
//                                bufw.newLine();
                                for(char a7 : chars){
                                    l++;
                                    bufw.write(""+a1+a2+a3+a4+a5+a6+a7);
                                    bufw.newLine();
                                }
                            }
                        }
                    }
                }
            }
        }
        bufw.flush();
        bufw.close();
        System.out.println("l is: " + l);
        System.out.println(chars.length);
    }

    private static void testdb() throws SQLException {
        String db = "E:\\Data\\ML\\jwj\\wechat\\test.db";
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:E:\\Data\\ML\\jwj\\wechat\\PublicMsg.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        Statement stmt = null;
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + age);
            System.out.println("ADDRESS = " + address);
            System.out.println("SALARY = " + salary);
            System.out.println();
        }
        rs.close();
        stmt.close();
        c.close();
        System.out.println("Operation done successfully");
    }


    /**
     * 357725678854269-1881034049
     * 4bc36a03296a8b4fc63e5bb8e74db2a2
     *
     * @param str
     */
    private static void getMD5Str(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");//获取MD5实例
            md.update(str.getBytes());//此处传入要加密的byte类型值
            byte[] digest = md.digest();//此处得到的是md5加密后的byte类型值

            /*
               下边的运算就是自己添加的一些二次小加密，记住这个千万不能弄错乱，
                   否则在解密的时候，你会发现值不对的（举例：在注册的时候加密方式是一种，
                在我们登录的时候是不是还需要加密它的密码然后和数据库的进行比对，但是
            最后我们发现，明明密码对啊，就是打不到预期效果，这时候你就要想一下，你是否
             有改动前后的加密方式）
            */
            int i;
            StringBuilder sb = new StringBuilder();
            for (int offset = 0; offset < digest.length; offset++) {
                i = digest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    sb.append(0);
                sb.append(Integer.toHexString(i));//通过Integer.toHexString方法把值变为16进制
            }

            System.out.println(sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //Test the url is accessable or not
    private static boolean isAccessable(String url, int timeout) {
        boolean flag = false;
        try {
            InetAddress ip = InetAddress.getByName(url);
            flag = ip.isReachable(timeout);
        } catch (UnknownHostException e) {
            logger.warn("UnknownHostException happens...");
//            e.printStackTrace();
        } catch (IOException e) {
            logger.warn("IOException happens...");
//            e.printStackTrace();
        }
        return flag;
    }


}
