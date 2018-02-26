package com.niukun.blockchain.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSACoderTest {

	private static String publicKey;
	private static String privateKey;
	public static void main(String[] args) throws NoSuchAlgorithmException, Exception, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
		Map<String,Object> keyMap = RSACoder.initKey();
		publicKey = RSACoder.getPublicKey(keyMap);
		privateKey = RSACoder.getPrivateKey(keyMap);
		
		System.out.println("公钥:");
		System.out.println(publicKey);
		System.out.println("私钥:");
		System.out.println(privateKey);
		System.out.println("公钥加密——私钥解密");
		
		String text = "Niukun";
		byte[] data = text.getBytes();
		
		byte[] encodeData = RSACoder.encryptByPublicKey(data,publicKey);
		
		byte[] decodeData = RSACoder.decryptByPrivateKey(encodeData,privateKey);
		
		
		String result = new String(decodeData);
		System.out.println("加密前："+ text + "解密后：" + result);
		
		
		
		
	}

}
