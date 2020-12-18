package com.hrssc.utils;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public class StringUtil {
    public static final String[] encodes = new String[] { "UTF-8", "GBK", "GB2312", "ISO-8859-1", "ISO-8859-2" };

    private static String nationStr = "汉族、蒙古族、回族、藏族、维吾尔族、苗族、彝族、壮族、布依族、朝鲜族、满族、侗族、瑶族、白族、土家族、哈尼族、哈萨克族、傣族、黎族、僳僳族、佤族、畲族、高山族、拉祜族、水族、东乡族、纳西族、景颇族、柯尔克孜族、土族、达斡尔族、仫佬族、羌族、布朗族、撒拉族、毛南族、仡佬族、锡伯族、阿昌族、普米族、塔吉克族、怒族、乌孜别克族、俄罗斯族、鄂温克族、德昂族、保安族、裕固族、京族、塔塔尔族、独龙族、鄂伦春族、赫哲族、门巴族、珞巴族、基诺族";
    private static String poliStr = "中共党员、中共预备党员、共青团员、民革党员、民盟盟员、民建会员、民进会员、农工党党员、致公党党员、九三学社社员、台盟盟员、无党派民主人士、普通居民/群众";
    private static String str1 = "SELECT T_HRSSC_INF_PID.PIDNAME,T_HRSSC_INF_PID.PIDENDDATE,T_HRSSC_INF_PID.PIDSTARTDATE,T_HRSSC_INF_PID.PIDPID,  \tT_HRSSC_INF_PID.PIDID,  \tT_HRSSC_INF_STAFF.STAFFID,  \tT_HRSSC_INF_STAFFLINK.STAFFLINKID,  \tT_HRSSC_INF_PIDCONTACT.PIDCONTACTVALUE,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYENTRYDATE,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYPOSITIVEDATE,  \tT_HRSSC_INF_JOBHISTORY.JOBLIFECYCLEID,  \tT_HRSSC_INF_JOBHISTORY.PROBATIONID,  \tT_HRSSC_INF_JOBHISTORY.COMPANYID,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYSTARTDATE,  \tT_HRSSC_INF_JOBHISTORY.DEPARTMENTID,  \tT_HRSSC_INF_JOBHISTORY.POSITIONID,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYHIGNER,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYID,  \tT_HRSSC_INF_JOBHISTORY.STAFFLINKID,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYENDDATE,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYZW,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYZJ,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYZD,  \tT_HRSSC_INF_JOBHISTORY.STAFFSTATUSID,  \tT_HRSSC_INF_JOBHISTORY.JOBTYPEID,  \tT_HRSSC_INF_JOBHISTORY.WORKTIMEID,  \tT_HRSSC_INF_JOBHISTORY.ADMINDIVISIONID,  \tT_HRSSC_INF_JOBHISTORY.COMPANYADDRESSID,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYEMAIL,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYTEL,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYTELEXTENSION,  \tT_HRSSC_INF_JOBHISTORY.CHANGESTATUSID,  \tT_HRSSC_INF_JOBHISTORY.JOBORIGINID,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYDEPARTMENTNAME,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYOTHER,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYRECORD,  \tT_HRSSC_INF_JOBHISTORY.JOBHISTORYUPDATEDDATE,  \tT_HRSSC_INF_STAFFLINK.STAFFLINKSTAFFINID,  \tT_HRSSC_INF_STAFFLINK.STAFFLINKREGISTERED,  \tT_HRSSC_INF_PID.PIDBIRTHDAY,  \tT_HRSSC_INF_PID.SEXID,  \tT_HRSSC_INF_PID.NATIONID,  \tT_HRSSC_INF_PID.PIDADDRESS,  \tT_HRSSC_INF_PIDCONTACT.CONTACTTYPEID,  \tT_HRSSC_COD_JOBTYPE.JOBTYPESTATUS,  \tT_HRSSC_INF_POSITION.POSITIONNAME,  \tT_HRSSC_INF_DEPARTMENT.DEPARTMENTNAME FROM \tT_HRSSC_INF_JOBHISTORY \tINNER JOIN \tT_HRSSC_INF_STAFFLINK \tON  \t\tT_HRSSC_INF_JOBHISTORY.STAFFLINKID = T_HRSSC_INF_STAFFLINK.STAFFLINKID \tINNER JOIN \tT_HRSSC_INF_STAFF \tON  \t\tT_HRSSC_INF_STAFFLINK.STAFFID = T_HRSSC_INF_STAFF.STAFFID \tINNER JOIN \tT_HRSSC_INF_PID \tON  \t\tT_HRSSC_INF_PID.PIDID = T_HRSSC_INF_STAFF.PIDID \tINNER JOIN \tT_HRSSC_INF_PIDCONTACT \tON  \t\tT_HRSSC_INF_PIDCONTACT.STAFFID = T_HRSSC_INF_STAFF.STAFFID \tINNER JOIN \tT_HRSSC_INF_POSITION \tON  \t\tT_HRSSC_INF_JOBHISTORY.POSITIONID = T_HRSSC_INF_POSITION.POSITIONID \tINNER JOIN \tT_HRSSC_INF_DEPARTMENT \tON  \t\tT_HRSSC_INF_JOBHISTORY.DEPARTMENTID = T_HRSSC_INF_DEPARTMENT.DEPARTMENTID \tINNER JOIN \tT_HRSSC_COD_JOBTYPE \tON  \t\tT_HRSSC_INF_JOBHISTORY.JOBTYPEID = T_HRSSC_COD_JOBTYPE.JOBTYPEID WHERE  T_HRSSC_INF_PID.PIDPID = ':PIDPID' AND  T_HRSSC_INF_JOBHISTORY.COMPANYID = ':COMPANYID' ORDER BY  T_HRSSC_INF_JOBHISTORY.JOBHISTORYUPDATEDDATE DESC LIMIT 0, 1";




    public static void main(String[] args) {
        System.out.println(str1.replace("\t", "").replace("  ", " "));

//        extractAllItemsToFile(nationStr,"src/main/resources/nation.json");
//        extractAllItemsToFile(poliStr,"src/main/resources/political.json");

    }



    private static void extractAllItemsToFile(String nationStr, String filePath) {
        String[] strs = nationStr.split("、");
        System.out.println(strs.length);
        StringBuilder stringBuilder = new StringBuilder("{\n");
        for (int i =0; i< strs.length-1;i++){
            stringBuilder.append("\t\""+ (i+1) + "\": \"" + strs[i] + "\",\n");
        }
        stringBuilder.append("\t\""+ strs.length + "\": \"" +strs[strs.length-1] +"\"\n}");
        String allNations = stringBuilder.toString();
        System.out.println(allNations);
        JSONObject jsonObject = JSONObject.parseObject(allNations);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(allNations);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    @Test
    public void testRe(){
        String content = "asdasASDA123123";
        String pattern = "(?=.*[a-z].*)(?=.*[A-Z].*)(?=.*[0-9].*)[A-Za-z0-9]{8,16}";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("结果： " + isMatch);
    }

    /**
     * 获取字符串编码格式
     *
     * @param str
     * @return
     */
    public static String getEncode(String str) {
        byte[] data = str.getBytes();
        byte[] b = null;
        a:for (int i = 0; i < encodes.length; i++) {
            try {
                b = str.getBytes(encodes[i]);
                if (b.length!=data.length)
                    continue;
                for (int j = 0; j < b.length; j++) {
                    if (b[j] != data[j]) {
                        continue a;
                    }
                }
                return encodes[i];
            } catch (UnsupportedEncodingException e) {
                continue;
            }
        }
        return null;
    }


}
