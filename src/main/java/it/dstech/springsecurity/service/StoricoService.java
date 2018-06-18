package it.dstech.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.springsecurity.model.Storico;
import it.dstech.springsecurity.repository.IStoricoRepository;

@Service
public class StoricoService {
	
	@Autowired
	private IStoricoRepository dao;
	
	@Autowired
	private UserService userService;
	
	public Iterable<Storico> findAll() {
		
		return dao.findAll();
	}
	
	public Iterable<Storico> findByUserId(Long userId) {
		
		return userService.findOne(userId).getStorico();
	}

}
