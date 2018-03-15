package com.lanmao.demo;

import java.security.KeyPair;

import org.apache.commons.codec.binary.Base64;

import com.lanmao.common.SignatureUtils;

/**
 * 生成公钥私钥 demo
 * 
 * @author Iren08
 * @date 2017年3月8日 下午12:39:13
 * @version 1.0
 */
public class SignatureDemo {

	public static void main(String[] args) throws Exception {
		SignatureDemo.generateKeyPair();
	}
	
	public static void generateKeyPair() throws Exception {
		KeyPair keyPair = null;
		keyPair = SignatureUtils.generateRsaKeyPair(2048);
		try {
			System.out.println("公钥:"
					+ Base64.encodeBase64String(keyPair.getPublic()
							.getEncoded()));
			System.out.println("私钥:"
					+ Base64.encodeBase64String(keyPair.getPrivate()
							.getEncoded()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
