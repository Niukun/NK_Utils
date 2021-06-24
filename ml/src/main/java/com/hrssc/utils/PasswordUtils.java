package com.hrssc.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;


import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {


    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }


    public static String encodeStr(String str){
        MessageDigest md5 = null;//设置要返回的摘要算法对象
        try {
            md5 = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = md5.digest(str.getBytes()); //计算hash值
        return HexBin.encode(digest);
    }



}
