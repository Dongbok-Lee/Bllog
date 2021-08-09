package com.bok.bllog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bok.bllog.model.RoleType;
import com.bok.bllog.model.User;
import com.bok.bllog.repository.UserRepository;

@RestController
public class DummyController {

		@Autowired
		private UserRepository userRepository;
		
		@PostMapping("/dummy/join")
		public String join(User user) {
			System.out.println("id: "+user.getId());
			System.out.println("username : " + user.getUsername());
			System.out.println("password : " + user.getPassword());
			System.out.println("email : " + user.getEmail());
			System.out.println("role : " + user.getRole());
			System.out.println("createDate : " + user.getCreateDate());
			
			user.setRole(RoleType.USER);
			userRepository.save(user);
			return "회원가입이 완료되었습니다.";
		}
}
