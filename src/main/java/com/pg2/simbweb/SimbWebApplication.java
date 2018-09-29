package com.pg2.simbweb;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimbWebApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SimbWebApplication.class, args);
		
		
		try {
			String s="postgres";
			MessageDigest m;
			m = MessageDigest.getInstance("MD5");
			m.update(s.getBytes(),0,s.length());
		       System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	}
}
