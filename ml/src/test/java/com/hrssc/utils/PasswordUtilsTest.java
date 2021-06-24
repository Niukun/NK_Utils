package com.hrssc.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtilsTest {


    @Test
    public void encryptBASE64() throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("SHA-1");//设置要返回的摘要算法对象
        byte[] digest = md5.digest("123胜多负少asdasd，。,.':--=!@#$%^&*()_+的".getBytes()); //计算hash值
        String str = HexBin.encode(digest);
        System.out.println(str);//输出hash结果 40BD001563085FC35165329EA1FF5C5ECBDBBEEF
    }


    @Test
    public void encryptBASE64Test() throws NoSuchAlgorithmException {

        try {
            String s = PasswordUtils.encodeStr("123");
            System.out.println(s);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }




}