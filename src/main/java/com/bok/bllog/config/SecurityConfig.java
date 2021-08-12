package com.bok.bllog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 빈등록 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration// 빈등록
@EnableWebSecurity// 필터 추가
@EnableGlobalMethodSecurity(prePostEnabled = true)//특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 것
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
		@Autowired
		private com.bok.bllog.config.auth.PrincipalDetailService principalDetailService;
	
		@Bean
		public BCryptPasswordEncoder encodePWD() {
			return new BCryptPasswordEncoder();
		}
	
		@Override
		public void configure(WebSecurity web) throws Exception {
		    web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		}
		
		//시큐리티가 대신 로그인해주는데 password를 가로채기하는데
		//해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
		//같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할  수가 있음.
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/","/js/**","/img/**","/vid/**","/css/**","/auth/**")
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin() 
				.loginPage("/auth/login")
				.loginProcessingUrl("/auth/loginProc") // 스프링 시큐리티가 해당 주소로 로그인을 가로챈다 
				.defaultSuccessUrl("/")
				.failureUrl("/fail");
				
		}
}
