package com.example.demo.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class OTPService {
	
	private static final String otpChar = "0123456789";
	private static final int otpLength = 6;
	
	public String generateOTP() {
		SecureRandom generate = new SecureRandom();
		StringBuilder otp = new StringBuilder(otpLength);
		
		for(int i = 0;i<otpLength;i++) {
			int index = generate.nextInt(otpChar.length());
			otp.append(otpChar.charAt(index));
		}
		return otp.toString();
	}
}
