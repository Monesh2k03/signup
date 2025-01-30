package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Login;
import com.example.demo.repository.LoginRepo;

@Service
public class LoginService {
	
	@Autowired
	public OTPService otpservice;
	
	@Autowired
	public LoginRepo loginrepo;
	
	@Autowired
	public JavaMailSender mail;
	
	public String checkOTP;
	
	
	
	public String signUp(Login login) {
		loginrepo.save(login);
		return "User Registered Successfully";
		
	}
	
	public String generateOTP(String email) {
		Login login = loginrepo.findByuserMail(email);
		if(login == null) {
			return "User not Found";
			
		}
		
		String otp = otpservice.generateOTP();
		checkOTP = otp;
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(login.getUserMail());
		msg.setSubject("Verification Code - Mini Truck Booking");
		msg.setText("Your OTP Code is : "+otp+"\nPlease do not share this information to others\n Regards,\nMTB Team");
		mail.send(msg);
		
		return "OTP is sent to your Mail";
	}
	
	public String enterOTP(String userOTP) {
		if(checkOTP.equals(userOTP)) {
			return "Sign Up Successfully Completed";
		}
		return "Incorrect OTP Entered";
	}
	
	
	public String logIn(String mail,String pass) {
		Login login = loginrepo.findByuserMail(mail);
		if(login == null) {
			return"User not Found";
		}
		String orgPass = login.getUserPassword();
		if(pass.equals(orgPass)) {
			return "Login Successfully Completed";
		}
		
		return "User Password is Wrong";
	}
	
}
