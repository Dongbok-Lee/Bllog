 package com.bok.bllog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/")
	public String main(){
		return "main";
	}
	
	@GetMapping("/auth/sign")
	public String signup() {
		return "sign";
	}
	@GetMapping("/auth/login")
	public String	login() {
		return "login";
	}
}

