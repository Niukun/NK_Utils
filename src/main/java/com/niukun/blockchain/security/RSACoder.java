package com.niukun.blockchain.security;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;

public class RSACoder {

	//初始化秘钥
	public static Map<String,Object> initKey() throws NoSuchAlgorithmException{
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(1024);
		
		KeyPair keyPair = keyPairGen.generateKeyPair();
		
		//公钥
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		//私钥
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		
		Map<String,Object> keyMap = new HashMap<String,Object>(2);
		keyMap.put("publicKey", publicKey);
		keyMap.put("privateKey", privateKey);
		return keyMap;
	}
	/**
	 * 获取公钥
	 * @param keyMap
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String getPublicKey(Map<String,Object> keyMap) throws NoSuchAlgorithmException {
		RSAPublicKey publicKey = (RSAPublicKey) keyMap.get("publicKey");
		
		return Base64.encodeBase64URLSafeString(publicKey.getEncoded());
		
	}
	/**
	 * 获取私钥
	 * @param keyMap
	 * @return
	 */
	public static String getPrivateKey(Map<String,Object> keyMap) {
		
		RSAPrivateKey privateKey = (RSAPrivateKey) keyMap.get("privateKey");
		return Base64.encodeBase64URLSafeString(privateKey.getEncoded());
		
	}
	
	/**
	 * 使用公钥加密
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchPaddingException 
	 */
	public static byte[] encryptByPublicKey(byte[] data, String key) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
		byte[] keyBytes = Base64.decodeBase64(key);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		
		RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
		
		
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(data);
		
	}
	
	/**
	 * 使用私钥解密
	 * @throws Exception 
	 */
	
	public static byte[] decryptByPrivateKey(byte[] data,String key) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(key);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		
		RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
		
		
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}
}
