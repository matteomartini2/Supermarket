package it.dstech.springsecurity.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import it.dstech.springsecurity.model.CartaCredito;
import it.dstech.springsecurity.repository.ICartaCreditoRepository;

@Service
public class CartaCreditoService {
	
	private ICartaCreditoRepository dao;
	
	
	public CartaCredito findOne(Long id) {
		Optional<CartaCredito> user = dao.findById(id);
		return user.get();
		
	}
	
	public Iterable<CartaCredito> findAll () {
		 return dao.findAll();
	}
	
	public void deleteAll() {
		dao.deleteAll();
	}
	
	
	public void deleteOne(Long id) {
		deleteOne(id);
	}

	public CartaCredito update(CartaCredito carta) {
		CartaCredito cart = dao.findById(carta.getId()).get();
		cart.setCvv(carta.getCvv());
		cart.setCredito(carta.getCredito());
		cart.setNumero(carta.getNumero());
		cart.setScadenza(carta.getScadenza());
		cart.setUser(carta.getUser());
		
		return dao.save(cart);
		
	}
}
