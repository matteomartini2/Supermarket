package it.dstech.springsecurity.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import it.dstech.springsecurity.model.User;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailService;
	
	/**
	 * Authenticate a user.
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public UserDetails authenticate (User user) throws Exception {
		
		UserDetails loadUserByUsername = userDetailService.loadUserByUsername(user.getUsername());
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loadUserByUsername.getUsername(), user.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return loadUserByUsername;
	}
}
