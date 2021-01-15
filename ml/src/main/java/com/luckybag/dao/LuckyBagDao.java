package com.luckybag.dao;

import com.hrssc.utils.DBUtils;
import com.luckybag.bean.Node;
import com.luckybag.bean.PersonInfo;
import com.luckybag.constants.LuckyCons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

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
            ps.setString(7, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            int result = ps.executeUpdate();
//            if (result != 0) {
//                System.out.println(personInfo.getName() + "插入成功！");
//            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
