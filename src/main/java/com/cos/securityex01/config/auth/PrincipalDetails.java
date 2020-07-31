package com.cos.securityex01.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.securityex01.model.User;

import lombok.Data;

//Authentiaction 객체에 저장할 수 있는 유일한 타입
@Data
public class PrincipalDetails implements UserDetails {

	private User user;
	private String role;
   
	public PrincipalDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> autorities = new ArrayList<GrantedAuthority>();
        autorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		return autorities;
	}

}
