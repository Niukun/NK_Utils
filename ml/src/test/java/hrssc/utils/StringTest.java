package hrssc.utils;

import com.hrssc.utils.PasswordUtils;
import com.hrssc.utils.RSAUtil;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringTest {

    @Test
    public void test01() {
        String[] arr = {"牛", "气", "冲", "天"};
        for (int i = 0; i < 100; i++) {
            System.out.print(arr[i % arr.length]);
        }
    }

    @Test
    public void test() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }


    @Test
    public void testNum() {
        double a = 9;
        double b = 11;
        System.out.println(a / b);

    }


    @Test
    public void testNum1() {
        System.out.println(System.getProperty("user.dir") + "/src/test/java/com/hrssc/utils/PasswordUtilsTest.java");
        System.out.println(System.getProperty("user.home"));
    }


    public static int getNum(int hours) {
        if (hours <= 1) {
            return 1;
        } else {
            return getNum(hours - 1) + getNum(hours - 2);
        }

    }


    @Test
    public void testDate() throws NoSuchAlgorithmException, InvalidKeySpecException {

        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println("明文文字： " + sdf.format(date));
        System.out.println("明文文字大小： " + sdf.format(date).length());

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnKGUoZ3GJBlwAkNh2gNYKU920WG9E4FgFa2bwH76ZEuXfpK0PWpg6tDBmYYOp93XqQPpn0tafIo8HqGwO8bT2jR-atnQ40SDhd8MbPPDXFGneeGDzU6RVrLGiWMsCVnEmlDGaQ0ktxX8sFntx_MXN1tTPUmVgG--WQepJ3hkm8wIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKcoZShncYkGXACQ2HaA1gpT3bRYb0TgWAVrZvAfvpkS5d-krQ9amDq0MGZhg6n3depA-mfS1p8ijweobA7xtPaNH5q2dDjRIOF3wxs88NcUad54YPNTpFWssaJYywJWcSaUMZpDSS3FfywWe3H8xc3W1M9SZWAb75ZB6kneGSbzAgMBAAECgYAE1LAHuOWZFiv2gDkhQ5vr9HyFx8B_dxRUI8R30BMMDXXDPtkZhn67w5VagBr0AIjR2kriUT-OncsQZ5en3uhh47X9DUdxI1C8fd_jhNcZ9bOJbktix2X26Xi5HLglpgGq6ovSEwtYXEb0EZeOUWsD18DxUe5vpYQ8cpbjk4smUQJBAOFn-TEr2gQgLn7OUvySMUFRpcMOrleAEDjvJ58KR8ZzyOUE4MnmBDILk_jYUFibsVqJnf-wOtq1yesQEQgGCgcCQQC92IH9yC3E6O-2rK_SzaTntSDxOUEYJ75dXzC7NGEQN6HHIl5Bx0OUFb5ttHHL_iXX1Bp_WDXAS6UHvHaux3C1AkAI73w7bMeZvkTZlghIJut48Wmmz-Ata9A40ZI6hcfOoCxol8bpegrUiQz2omyc9p8TPb1bs3rBzM8SWHK0ZLjlAkAs3X3a-_PVFTeRdD4ZE4BlQekHGQDJNJtIdbaOh1JpAry40uZzpSPTW1AlnP9Htkg7OWUJs08Aot_ddCyYIYoBAkEAkwmpFXvYJJrfJ033ku6m2xQfkkjlxBYuyKXz2t-p8tHcbwbMKJx_H0Jt6lNLq7J5_Ck0e5hMDCYlNIo7W4gSYQ";

        String encodedData = RSAUtil.publicEncrypt(sdf.format(date), RSAUtil.getPublicKey(publicKey));  //传入明文和公钥加密,得到密文
        System.out.println("密文：\r\n" + encodedData);
        String decodedData = RSAUtil.privateDecrypt(encodedData, RSAUtil.getPrivateKey(privateKey)); //传入密文和私钥,得到明文
        System.out.println("解密后文字: \r\n" + decodedData);


        PasswordUtils.encodeStr(sdf.format(date));
    }


    @Test
    public void generateTODORecord() {

        int year = 2022;
        int month = 12;
        int day = 31;
        for (int i = 1; i <= month; i++) {
            System.out.println(year + "-" + i);
            for (int j = 1; j <=day; j++) {
                System.out.println(year + "-" + i + "-" + j);
                System.out.println("TODO");
                System.out.println("DONE");
            }
        }


    }


}
