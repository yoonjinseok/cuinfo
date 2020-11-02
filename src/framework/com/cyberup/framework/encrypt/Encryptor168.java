package com.cyberup.framework.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encryptor168 {
	public static byte[] encrypt(byte[] keydata, String data)
	{
		try {
			DESedeKeySpec keySpec = new DESedeKeySpec(keydata);
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
	        SecretKey desKey = keyFactory.generateSecret(keySpec);

	        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, desKey);
	        
	        byte [] plainText = data.getBytes("UTF8");
	        
	        byte [] cipherText = cipher.doFinal(plainText);
	        
	        return cipherText;
		} catch (Exception e) {
			Logger.getLogger(Encryptor168.class).error(e.getMessage(), e);
			
			return null;
		}
	}
	
	public static String encode(byte[] encrypted)
	{
		return new BASE64Encoder().encode(encrypted);
	}
	
	public static byte[] decode(String encrypted) throws Exception
	{
		return new BASE64Decoder().decodeBuffer(encrypted);
	} 
	
	public static String makeRandomKey()
	{
		return String.valueOf(Math.random());
	}
	public static String encodeRandomKey(String randomKey)
	{
		String ciphers = "aBcDeFgHiJ";
		
		String randomkey = "";
		for(int i = 0; i < randomKey.length(); i++)
		{
			if(!randomKey.substring(i, i+1).equals("."))
			{
				int key = Integer.parseInt(randomKey.substring(i, i+1));
				randomkey = randomkey.concat(ciphers.substring(key,key+1));
			}
			else
				randomkey = randomkey.concat(randomKey.substring(i, i+1));
		}
		
		return randomkey;
	}
	
	public static String decodeRandomKey(String randomKey)
	{
		String ciphers = "aBcDeFgHiJ";
		String key = "";
		
		for(int i = 0; i < randomKey.length(); i++)
		{
			int index = ciphers.indexOf(randomKey.substring(i, i+1));
			if(index < 0)
				key = key.concat(".");
			else
				key = key.concat(String.valueOf(index));
		}
		
		return key;
	}
	
	public static String findRandomKey(String encrypted)
	{
		return encrypted.substring(encrypted.lastIndexOf(".")-1);
	}
	public static String findOriginData(String encrypted)
	{
		return encrypted.substring(0, encrypted.lastIndexOf(".")-1);
	}
	
	public static void main(String[] args) {
		try {
			/*
			// 암호화 서버
			String random = makeRandomKey();
			String randomkey = encodeRandomKey(random);
			
			String key = "kcm.korea.ac.kr163.152.65.193" + random; // 접속 사이트 도메인 : request.getServerName()접속자 PC 주소 : request.getRemoteAddr()
			String data = "sStdId=seeyou&sDeptCd=333222&sWHY=PASSWORD"; // 암호화 해서 보내실 데이타 : 사번(sStdId), 부서코드(sDeptCd), 로그인결과(sWHY)
			
			String encrypted = encode(encrypt(key.getBytes(), data)) + randomkey;
			
			System.out.println("encrypt data : " + encrypted);
			*/
			
			// 복호화 호스트
			String encrypted = "z8wzJw4reygwzHYD5//qi9ay+AKXY7UdTolzYWV0IBppOxgYm9ihsQ==a.iDJDBFBBFDcFDDce";
			
			String randomKey = decodeRandomKey(findRandomKey(encrypted));
			String key2 = "portal.korea.ac.kr163.152.65.34" + randomKey;
			String originData = findOriginData(encrypted);
			
			String decrypted = decrypt(key2.getBytes(), decode(originData));
			System.out.println("decrypt data : " + decrypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String decrypt(byte[] keydata, byte[] data)
	{
		try {
	        DESedeKeySpec keySpec = new DESedeKeySpec(keydata);
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
	        SecretKey desKey = keyFactory.generateSecret(keySpec);

	        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
	        cipher.init(Cipher.DECRYPT_MODE, desKey);

	        byte [] decryptedText = cipher.doFinal(data);
	        String output =  new String(decryptedText, "UTF8");
	        
	        return output;
		} catch (Exception e) {
			Logger.getLogger(Encryptor168.class).error(e.getMessage(), e);
			
			return null;
		}
	}
}
