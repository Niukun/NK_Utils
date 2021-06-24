package com.luckybag.dao;

import com.hrssc.utils.DBUtils;
import com.luckybag.bean.Node;
import com.luckybag.bean.PersonInfo;
import com.luckybag.constants.LuckyCons;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class LuckyBagDao {
    static Connection connection = DBUtils.getConnection();
    private static PreparedStatement ps = null;

    public static void insertIntoDepartment(Node node) {
        String name = node.getName();

        String code = node.getCode();
        List<Node> children = node.getChildren();
        String sql = "insert into T_LUCKY_BAG_DEPARTMENT (DEPARTMENTID,DEPARTMENTNAME,DEPARTMENTCODE,PARENTID) values (?,?,?,?)";
        Statement stmt = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            ps.setString(2, name);
            ps.setString(3, code);
            ps.setString(4, node.getParent() == null ? "0" : node.getParent().getCode());
            if(!"-".equalsIgnoreCase(name)){
                int result = ps.executeUpdate();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Iterator<Node> iterator = children.iterator();
        while (iterator.hasNext()) {
            insertIntoDepartment(iterator.next());
        }


    }


    public static void insertUser(PersonInfo personInfo) {
        String sql = "insert into T_LUCKY_BAG_USER (USERID,USERNAME,USERPHONE,USERPASSWORD,USERLOGINTYPE,ROLEID,DEPARTMENTID) values (?,?,?,?,?,?,?)";

        Statement stmt = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, personInfo.getId());
            ps.setString(2, personInfo.getName());
            ps.setString(3, personInfo.getPhone());
            ps.setString(4, LuckyCons.USERPASSWORD);
            ps.setString(5, LuckyCons.USERLOGINTYPE);
            ps.setString(6, LuckyCons.ROLEID);
            ps.setString(7, personInfo.getDepartmentid());
            int result = ps.executeUpdate();
//            if (result != 0) {
//                System.out.println(personInfo.getName() + "插入成功！");
//            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public static void initLuckyBagAmount(PersonInfo personInfo) {

        String sql = "insert into T_LUCKY_BAG_RECORD (RECORDID,RECORDAMOUNT,RECORDTOTALAMOUNT,USERID,RESOURCETYPEID,RECORDDESC,RECORDCREATETIME) values (?,?,?,?,?,?,?)";

        Statement stmt = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, personInfo.getAmount());
            ps.setString(3, personInfo.getAmount());
            ps.setString(4, personInfo.getId());
            ps.setString(5, LuckyCons.RESOURCETYPEID_INIT);
            ps.setString(6, LuckyCons.RESOURCEDESC);
            ps.setString(7, String.valueOf(System.currentTimeMillis()));

            int result = ps.executeUpdate();
//            if (result != 0) {
//                System.out.println(personInfo.getName() + "插入成功！");
//            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static String getUserIdByPhone(String phone){

        String sql = "select userid from T_LUCKY_BAG_USER where userphone = ?";
        Statement stmt = null;

        String result = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, phone);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                result = resultSet.getString("USERID");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;

    }

    public static String getuserCurrentAmountByUserid(String userId) {
        String sql = "SELECT RECORDTOTALAMOUNT FROM T_LUCKY_BAG_RECORD WHERE USERID = ? ORDER BY RECORDCREATETIME DESC;";
        Statement stmt = null;

        String result = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, userId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                result = resultSet.getString("RECORDTOTALAMOUNT");
                break;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public static String addLuckyBagAmountForUser(String userId, int amount, int totalAmount) {
        String sql = "insert into T_LUCKY_BAG_RECORD (RECORDID,RECORDAMOUNT,RECORDTOTALAMOUNT,USERID,RESOURCETYPEID,RECORDDESC,RECORDCREATETIME) values (?,?,?,?,?,?,?)";

        Statement stmt = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, Integer.toString(amount));
            ps.setString(3, Integer.toString(totalAmount));
            ps.setString(4, userId);
            ps.setString(5, LuckyCons.RESOURCETYPEID_INIT);
            ps.setString(6, LuckyCons.RESOURCEDESC_ADD);
            ps.setString(7, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            int result = ps.executeUpdate();
            if (result != 0) {
                return LuckyCons.SUCCESS;
            }
            return LuckyCons.ERROR;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return LuckyCons.ERROR;
    }

}
