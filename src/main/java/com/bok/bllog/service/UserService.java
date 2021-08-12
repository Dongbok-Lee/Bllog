package com.bok.bllog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bok.bllog.model.RoleType;
import com.bok.bllog.model.User;
import com.bok.bllog.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	 
	@Transactional
	public void 회원가입(User user) {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			
			user.setPassword(encPassword);
			user.setRole(RoleType.USER);
		 	userRepository.save(user);
	}
}
