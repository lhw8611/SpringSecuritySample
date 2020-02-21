package com.eins.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/home")
	public String home() {
		return  "home/home";
	}
	
	//?��??권한 경로
	@RequestMapping("/user/main")
	public String user() {
		return  "user/main";
	}
	
	//�?리자권한 경로
	@RequestMapping("/admin/main")
	public String admin() {
		return  "admin/main";
	}
	
}
	
