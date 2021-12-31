package com.niukun.blockchain.security;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

public class RSACoderTest {

    public static String src = "hello human";
    public static void main(String[] args) throws NoSuchAlgorithmException, Exception, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {

//		test01();
        test02();

    }

    private static void test02() throws Exception {
        // 密钥初始化
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 签名
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(privateKey);
        signature.update(src.getBytes());
        byte[] arr = signature.sign();
        System.out.println("jdk rsa sign:" + HexBin.encode(arr));
        // 验证签名
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
        keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(src.getBytes());
        boolean bool = signature.verify(arr);
        System.out.println("jdk rsa verify:" + bool);
    }

    private static void test01() throws Exception {
        Map<String, Object> keyMap = RSACoder.initKey();
        String publicKey = RSACoder.getPublicKey(keyMap);
        String privateKey = RSACoder.getPrivateKey(keyMap);

        System.out.println("公钥:");
        System.out.println(publicKey);
        System.out.println("私钥:");
        System.out.println(privateKey);
        System.out.println("公钥加密——私钥解密");

        String text = "Niukun";
        byte[] data = text.getBytes();

        byte[] encodeData = RSACoder.encryptByPublicKey(data, publicKey);

        byte[] decodeData = RSACoder.decryptByPrivateKey(encodeData, privateKey);


        String result = new String(decodeData);
        System.out.println("加密前：" + text + "解密后：" + result);
    }

}
