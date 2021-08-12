package com.bok.bllog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bok.bllog.dto.ResponseDto;
import com.bok.bllog.model.RoleType;
import com.bok.bllog.model.User;
import com.bok.bllog.service.UserService;

@RestController
public class UserApiController {
		
		@Autowired
		 private UserService userService;

		
		@PostMapping("/auth/joinProc")  
		public ResponseDto<Integer> save(@RequestBody User user) {
			System.out.println(user);
				System.out.println("save호출됨");
				userService.회원가입(user);
				return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		}
		
}
