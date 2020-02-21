package com.eins.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
public class MemberController {
	
	@GetMapping("/")
	public void login() {	
		
	}
}
