package com.hrssc.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import org.junit.jupiter.api.Test;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class PasswordUtils {


    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    @Test
    public void encryptBASE64() throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("SHA-1");//设置要返回的摘要算法对象
        byte[] digest = md5.digest("Admin_1234".getBytes()); //计算hash值
        String str = HexBin.encode(digest);
        System.out.println(str);//输出hash结果 125D6EAB3B5C355DE1EB1307D5D1EB9C40C8F4C2
        byte[] decode = HexBin.decode(str);
        for (byte b : decode) {
            System.out.print(b);
        }
    }


}
