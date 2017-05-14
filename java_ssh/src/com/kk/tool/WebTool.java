package com.kk.tool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import sun.misc.BASE64Encoder;

public class WebTool {

	public  static String createUUID() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String uuid =UUID.randomUUID().toString().replace("-", "");
		MessageDigest md5 =MessageDigest.getInstance("MD5");
		BASE64Encoder baseEn = new BASE64Encoder();
		return baseEn.encode(md5.digest(uuid.getBytes("UTF-8")));
	}
}
