package it.dstech.springsecurity.service;

import java.util.List;

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
	
	public Storico create(Storico storico) {
		return dao.save(storico);
	}
	
	public Iterable<Storico> create(List<Storico> storici){
		return dao.saveAll(storici);
	}
	
	public Storico update(Storico storico) {
		Storico temp=dao.findById(storico.getId()).get();
		temp.setData(storico.getData());
		temp.setProdotti(storico.getProdotti());
		temp.setTotale(storico.getTotale());
		temp.setUser(storico.getUser());
		return dao.save(temp);
	}
	
	public void delete(Long id) {
		dao.deleteById(id);
	}
	
	public void delete(Storico storico) {
		dao.delete(storico);
	}
	
	public void purge() {
		dao.deleteAll();
	}
	
	public void deleteAll(Iterable<Storico> storici) {
		dao.deleteAll(storici);
	}
	

}
