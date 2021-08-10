package com.bok.bllog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {
	@GetMapping("/")
	public String main(){
		return "main";
	}
}
