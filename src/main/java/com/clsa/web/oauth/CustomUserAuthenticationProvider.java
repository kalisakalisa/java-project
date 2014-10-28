package com.clsa.web.oauth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;

import com.clsa.web.domain.Account;
import com.clsa.web.services.interfaces.IService;

public class CustomUserAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	IService service;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		Authentication curAuthentication = SecurityContextHolder.getContext()
				.getAuthentication();
		grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_USER"));
		Account account = service.search(authentication.getPrincipal()
				.toString().trim());
		if (account != null) {
			if (account.getPassword().equals(
					authentication.getPrincipal().toString())
					&& account.getPassword().equals(
							authentication.getCredentials().toString())) {
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
						authentication.getPrincipal(),
						authentication.getCredentials(), grantedAuthorities);
				return auth;
			}
		}
		throw new BadCredentialsException("Bad User Credentials.");

	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return true;
	}
}
