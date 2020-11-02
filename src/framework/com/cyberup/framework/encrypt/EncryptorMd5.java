package com.cyberup.framework.encrypt;

import java.security.MessageDigest;

import org.apache.log4j.Logger;
//import org.apache.tomcat.util.buf.UTF8Decoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptorMd5 {
	public static byte[] encrypt(String data)
	{
		try {
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.reset();
	        
	        return md.digest(data.getBytes());
		} catch (Exception e) {
			Logger.getLogger(EncryptorMd5.class).error(e.getMessage(), e);
			
			return null;
		}
	}
	
	public static String encode(byte[] encrypted)
	{
		try {
			return new BASE64Encoder().encode(encrypted);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static byte[] decode(String encrypted) throws Exception
	{
		return new BASE64Decoder().decodeBuffer(encrypted);
	}
	
	public static void main(String[] args) {
		try {
			
//			String test = "k1234";
			String test = "dcu123";
			
			System.out.println("encode = " + EncryptorMd5.encode(EncryptorMd5.encrypt(test)));
			
			/*
			String data = "k1234";
			String encrypted = encode(encrypt(data));
			System.out.print("encrypt data : " + encrypted);
			*/
			/*
			byte[] aa = decode("ebifwhxOmyvqxtKtA+wsyQ==");
			
			System.out.println("aa =============> " + new String(aa));
			for (int i = 0; i < aa.length; i++) {
//				System.out.print(aa[i]);
			}
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
