package it.dstech.springsecurity.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.springsecurity.model.User;
import it.dstech.springsecurity.service.UserService;
import it.dstech.springsecurity.service.auth.AuthService;


@RestController
@RequestMapping("/user")
public class UserCtrl {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private PasswordEncoder encoder;

	@RequestMapping(method = RequestMethod.GET, value = "/findAll")
	public Iterable<User> findAll() {
		
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findOne")
	public User findOne(@RequestParam("id") Long id) {
		
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAll")
	public void deleteAll() {
		
		service.deleteAll();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteOne")
	public void deleteOne(@RequestParam("id") Long id) {
		
		service.deleteOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public User create(@RequestBody User user) {
		
		return service.create(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public UserDetails authenticate(@RequestBody User user) throws Exception{
		
		return authService.authenticate(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public User addUser(@RequestBody User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		return service.create(user);
	}
	
}
