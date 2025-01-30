package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	public LoginService loginservice;
	
	@PostMapping("/save")
	public String registerUser(@RequestBody Login login) {
		return loginservice.signUp(login);
	}
	
	@PostMapping("/generate-otp")
	public String sendOTP(@RequestParam String mail) {
		return loginservice.generateOTP(mail);
	}
	
	@PostMapping("/otpcheck")
	public String checkOTP(@RequestParam String userOTP) {
		return loginservice.enterOTP(userOTP);
	}
	
	@GetMapping("/signin")
	public String signIn(@RequestParam String mail , String pass) {
		return loginservice.logIn(mail, pass);
	}
}
