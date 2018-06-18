package it.dstech.springsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.springsecurity.model.User;
import it.dstech.springsecurity.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository dao;
	
	public Iterable<User> findAll() {
		
		return dao.findAll();
	}
	
	public User findOne(Long id) {
		
		Optional<User> user = dao.findById(id);
		
		return user.get();
	}
	
	public void deleteAll() {
		
		dao.deleteAll();
	}
	
	public void deleteOne(Long id) {
		
		dao.deleteById(id);
	}
	
	public User create(User u) {
		
		return dao.save(u);
	}
	
	public User update(User u) {
		
		User old = dao.findById(u.getId()).get();
		
		old.setCap(u.getCap());
		old.setCartaCredito(u.getCartaCredito());
		old.setCitta(u.getCitta());
		old.setPassword(u.getPassword());
		old.setProv(u.getProv());
		old.setRole(u.getRole());
		old.setStorico(u.getStorico());
		old.setTel(u.getTel());
		old.setUsername(u.getUsername());
		
		return dao.save(old);
	}

}
