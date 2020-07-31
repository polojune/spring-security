package com.cos.securityex01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration //IoC 빈(bean)을 등록
@EnableWebSecurity //필터 체인 관리 시작 어노테이션
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소 접근시 권한 및 인증을 미리 체크 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	 @Override
    protected void configure(HttpSecurity http) throws Exception {
          
    	  http.csrf().disable(); //form 태그 시 post 요청시 csrf 토큰을 만들어야 서버에서 허가를 해준다.
    	  http.authorizeRequests()
	          .antMatchers("/user/**","/admin/**")
	          .authenticated()
	          .anyRequest()
	          .permitAll()
	          
          .and()
          	  .formLogin()
          	  .loginPage("/login")
          	  .loginProcessingUrl("/loginProc")
          	  .defaultSuccessUrl("/");
    	      
    }
}
