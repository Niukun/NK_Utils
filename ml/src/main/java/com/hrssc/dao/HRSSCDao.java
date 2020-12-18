package com.hrssc.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hrssc.utils.Contants;
import com.hrssc.utils.DBUtils;
import com.hrssc.utils.FileUtils;


import java.sql.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static com.hrssc.utils.StringUtil.getEncode;


public class HRSSCDao {

    private static final String PROVINCEPOSTFIX = "0000";
    private static final String CITYPOSTFIX = "00";

    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement ps = null;

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("连接数据库。。。。");
        connection = DBUtils.getConnection();
    }

    public static void main(String[] args) {

        try {
//            insertADMINDIVISION();
//            insertATTACHMENTTYPE();
//            insertJOBLIFECYCLE();
//            insertnation();
//            insertpolitical();
//            initArchiveSettingTable();

            initPaymentFields(Contants.PAYMENT_PATH0);



            Close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initPaymentFields(String filePath) throws SQLException {
        String sql = "insert into T_HRSSC_PAY_DEFAULTGROUPLIST(DEFAULTGROUPLISTID, DEFAULTGROUPLISTGROUPNAME,DEFAULTGROUPLISTFIELDNAME,GROUPDATASOURCESID) VALUE(?,?,?,?)";
        //得到档案字段的json对象
        List<String> list = FileUtils.getLinesFromFile(filePath);

        String[] str = new String[4];
        for (String s: list ) {
            ps = connection.prepareStatement(sql);
            str = s.split(",");
            ps.setString(1, str[0]);
            ps.setString(2, str[1]);
            ps.setString(3, str[2]);
            ps.setString(4, str[3]);


            int result = ps.executeUpdate();
            if (result != 0) {
//                System.out.println(jsonObject.get("FIELDNAME") + ": " + jsonObject.get("FIELDNAME") +"\t插入成功！");
            }
        }
        System.out.println(filePath + " finished.");

    }

    /**
     * TODO 为每个分组添加字段
     * @param filePath
     * @throws SQLException
     */
    private static void insertPaymentFields(String filePath) throws SQLException {
        String sql = "insert into T_HRSSC_INF_ARCHIVESETTING(ARCHIVESETTINGID, COMPANYID,ARCHIVESETTINGFIELDCATEGORY,ARCHIVESETTINGFIELDNAME, ARCHIVESETTINGFIELDTYPE,ARCHIVESETTINGISSHOWINREGISTER,ARCHIVESETTINGISREQUIRED) VALUE(?,?,?,?,?,?,?)";
        //得到档案字段的json对象
        JSONArray jsonArray = FileUtils.getJSONArrayFromFile(filePath);

        for (Object o: jsonArray ) {
            JSONObject jsonObject = (JSONObject) o;
//            System.out.println(jsonObject.get("FIELDNAME"));
            ps = connection.prepareStatement(sql);
            ps.setString(1, UUID.randomUUID().toString().replaceAll("-",""));
            ps.setString(2, (String) jsonObject.get("COMPANYID"));
            ps.setString(3, (String) jsonObject.get("FIELDCATEGORY"));
            ps.setString(4, (String) jsonObject.get("FIELDNAME"));
            ps.setString(5, (String) jsonObject.get("FIELDTYPE"));
            ps.setString(6, (String) jsonObject.get("ISSHOWINREGISTER"));
            ps.setString(7, (String) jsonObject.get("ISREQUIRED"));

            int result = ps.executeUpdate();
            if (result != 0) {
//                System.out.println(jsonObject.get("FIELDNAME") + ": " + jsonObject.get("FIELDNAME") +"\t插入成功！");
            }
        }
        System.out.println(filePath + " finished.");
    }



    private static void initArchiveSettingTable() throws SQLException {
//        insertArchiveSetting(Contants.ARCHIVESETTING_ATTACHMENT_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_BASIC_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_CERT_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_CONTACT_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_CONTACTPERSON_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_EDUCATION_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_FAMILY_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_HOBBY_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_JOB_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_LANGUAGE_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_SKILL_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_TITLE_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_TRAIN_PATH);
//        insertArchiveSetting(Contants.ARCHIVESETTING_WORK_PATH);
    }

    private static void insertArchiveSetting(String filePath) throws SQLException {
        String sql = "insert into T_HRSSC_INF_ARCHIVESETTING(ARCHIVESETTINGID, COMPANYID,ARCHIVESETTINGFIELDCATEGORY,ARCHIVESETTINGFIELDNAME, ARCHIVESETTINGFIELDTYPE,ARCHIVESETTINGISSHOWINREGISTER,ARCHIVESETTINGISREQUIRED) VALUE(?,?,?,?,?,?,?)";
        //得到档案字段的json对象
        JSONArray jsonArray = FileUtils.getJSONArrayFromFile(filePath);

        for (Object o: jsonArray ) {
            JSONObject jsonObject = (JSONObject) o;
//            System.out.println(jsonObject.get("FIELDNAME"));
            ps = connection.prepareStatement(sql);
            ps.setString(1, UUID.randomUUID().toString().replaceAll("-",""));
            ps.setString(2, (String) jsonObject.get("COMPANYID"));
            ps.setString(3, (String) jsonObject.get("FIELDCATEGORY"));
            ps.setString(4, (String) jsonObject.get("FIELDNAME"));
            ps.setString(5, (String) jsonObject.get("FIELDTYPE"));
            ps.setString(6, (String) jsonObject.get("ISSHOWINREGISTER"));
            ps.setString(7, (String) jsonObject.get("ISREQUIRED"));

            int result = ps.executeUpdate();
            if (result != 0) {
//                System.out.println(jsonObject.get("FIELDNAME") + ": " + jsonObject.get("FIELDNAME") +"\t插入成功！");
            }
        }
        System.out.println(filePath + " finished.");
    }



    /**
     * 向数据库中插入 员工职业生命周期字典表
     * @throws SQLException
     */
    private static void insertJOBLIFECYCLE() throws SQLException {
        String sql = "insert into T_HRSSC_COD_JOBLIFECYCLE(JOBLIFECYCLEID, JOBLIFECYCLEVALUE) VALUE(?,?)";
        //得到材料附件的json对象
        JSONObject jsonObject = FileUtils.getJSONObjectFromFile(Contants.JOB_LIFE_CYCLE);
        Set<String> items = jsonObject.keySet();
        for(String str : items){
            ps = connection.prepareStatement(sql);
//                ps.setString(1, UUID.randomUUID().toString().replaceAll("-",""));
            ps.setString(1,str);
            ps.setString(2, (String) jsonObject.get(str));

            int result = ps.executeUpdate();
            if (result != 0) {
                System.out.println(str + ": " + jsonObject.get(str) +"\t插入成功！");
            }
        }
    }

    /**
     * 向数据库中插入 材料附件字典表
     * @throws SQLException
     */
    private static void insertATTACHMENTTYPE() throws SQLException{
        String sql = "insert into T_HRSSC_COD_ATTACHMENTTYPE(ATTACHMENTTYPEID, ATTACHMENTTYPEVALUE,ATTACHMENTTYPECODE) VALUE(?,?,?)";
        //得到材料附件的json对象
        JSONObject jsonObject = FileUtils.getJSONObjectFromFile(Contants.ATTACHMENT_TYPE_PATH);
        Set<String> items = jsonObject.keySet();

        for(String str : items){


            ps = connection.prepareStatement(sql);
            ps.setString(1,str);
            ps.setString(2, (String) jsonObject.get(str));
            ps.setString(3, str);

            int result = ps.executeUpdate();
            if (result != 0) {
                System.out.println(str + ": " + jsonObject.get(str) +"插入成功！");
            }
            System.out.println(str);
            System.out.println(jsonObject.get(str));
        }

    }

    /**
     * 向数据库中插入 行政区划字典表
     * @throws SQLException
     */
    private static void insertADMINDIVISION() throws SQLException {
        String sql = "insert into T_HRSSC_COD_ADMINDIVISION(ADMINDIVISIONID, ADMINDIVISIONADMINDIVISIONNUMCODE,ADMINDIVISIONADMINDIVISIONCODE,ADMINDIVISIONADMINDIVISION,ADMINDIVISIONPARENT) value(?,?,?,?,?)";
        //得到行政区划的json对象
        JSONObject jsonObject = FileUtils.getJSONObjectFromFile(Contants.CITYCODE_PATH);
        Set<String> items = jsonObject.keySet();

        String provinceCode = null;
        String cityCode = null;

        for(String str : items){
            provinceCode = str.substring(0,2) + PROVINCEPOSTFIX;
            cityCode = str.substring(0,4) + CITYPOSTFIX;

            ps = connection.prepareStatement(sql);
//                ps.setString(1, UUID.randomUUID().toString().replaceAll("-",""));
            ps.setString(1,str);
            ps.setInt(2, Integer.parseInt(str));
            ps.setString(3, "");
            ps.setString(4, (String) jsonObject.get(str));
            if(str.endsWith(PROVINCEPOSTFIX)){
                ps.setString(5, "0");
            } else if(str.endsWith(CITYPOSTFIX)){
                ps.setString(5, provinceCode);
            } else{
                ps.setString(5, cityCode);
            }
            int result = ps.executeUpdate();
            if (result != 0) {
                System.out.println(str + ": " + jsonObject.get(str) +"插入成功！");
            }
            System.out.println(str);
            System.out.println(jsonObject.get(str));
        }
    }

    private static void Close() throws SQLException {
        ps.close();
        connection.close();
    }

    private static void getAllDate(Connection connection) throws SQLException {
        Statement dosql = connection.createStatement();

        String query = "select * from T_HRSSC_COD_ADMINDIVISION";
        //3.ResultSet类，用来存放获取的结果集！！
        ResultSet rs = dosql.executeQuery(query);
        System.out.println("-----------------");
        System.out.println("执行结果如下所示:");
        System.out.println("-------------------------------------------");
        System.out.println("ADMINDIVISIONID"+"\tADMINDIVISIONADMINDIVISIONNUMCODE" +"\tADMINDIVISIONADMINDIVISIONCODE"+"\tADMINDIVISIONADMINDIVISION");
        System.out.println("-------------------------------------------");
        String id = null;
        String name = null;
        String stunum = null;
        String phonenum = null;
        while(rs.next()){
            //获取ID
            id=rs.getString("ADMINDIVISIONID");
            //获取学生姓名
            name = rs.getString("ADMINDIVISIONADMINDIVISIONNUMCODE");
            //获取学号
            stunum = rs.getString("ADMINDIVISIONADMINDIVISIONCODE");
            //获取手机号码
            phonenum=rs.getString("ADMINDIVISIONADMINDIVISION");
            //输出结果
            System.out.println(id+"\t"+name + "\t" + stunum+"\t"+ phonenum+"\t"+ getEncode(phonenum));
        }
    }

    /**
     * 向数据库中插入 党派数据
     */
    private static void insertpolitical() throws SQLException {
        String sql = "insert into T_HRSSC_COD_POLITICALSTATUS(POLITICALSTATUSID, POLITICALSTATUSCODE,POLITICALSTATUSVALUE) VALUE(?,?,?)";
        //得到材料附件的json对象
        JSONObject jsonObject = FileUtils.getJSONObjectFromFile(Contants.POLITICAL_PATH);
        Set<String> items = jsonObject.keySet();

        for(String str : items){
            ps = connection.prepareStatement(sql);
            ps.setString(1,str);
            ps.setInt(2, Integer.parseInt(str));
            ps.setString(3, (String) jsonObject.get(str));

            int result = ps.executeUpdate();
            if (result != 0) {
                System.out.println(str + ": " + jsonObject.get(str) +"插入成功！");
            }
            System.out.println(str);
            System.out.println(jsonObject.get(str));
        }
    }

    /**
     * 向数据库中插入 民族字典表
     */
    private static void insertnation() throws SQLException {
        String sql = "insert into T_HRSSC_COD_NATION(NATIONID, NATIONNATIONNUMCODE,NATIONNATIONCODE,NATIONNATION) VALUE(?,?,?,?)";
        //得到材料附件的json对象
        JSONObject jsonObject = FileUtils.getJSONObjectFromFile(Contants.NATION_PATH);
        Set<String> items = jsonObject.keySet();

        for(String str : items){
            ps = connection.prepareStatement(sql);
            ps.setString(1,str);
            ps.setInt(2, Integer.parseInt(str));
            ps.setString(3, str);
            ps.setString(4, (String) jsonObject.get(str));

            int result = ps.executeUpdate();
            if (result != 0) {
                System.out.println(str + ": " + jsonObject.get(str) +"插入成功！");
            }
            System.out.println(str);
            System.out.println(jsonObject.get(str));
        }
    }
}
