package com.luckybag.dao;

import com.hrssc.utils.DBUtils;
import com.luckybag.bean.Node;
import com.luckybag.bean.PersonInfo;
import com.luckybag.constants.LuckyCons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class LuckyBagDao {
    static Connection connection = DBUtils.getConnection();
    private static PreparedStatement ps = null;

    public static void insertIntoDepartment(Node node) {
        String name = node.getName();
        String code = node.getCode();
        List<Node> children = node.getChildren();
        String sql = "insert into T_LUCKY_BAG_DEPARTMENT (DEPARTMENTID,DEPARTMENTNAME,DEPARTMENTCODE,PARENTID) values (?,?,?,?)";
//        System.out.println(sql);
        Statement stmt = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, code);
            ps.setString(2, name);
            ps.setString(3, code);
            ps.setString(4, node.getParent() == null ? "0" : node.getParent().getCode());
            int result = ps.executeUpdate();
//            if (result != 0) {
//                System.out.println(name + "插入成功！");
//            }

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
            ps.setString(1, UUID.randomUUID().toString());
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
}
