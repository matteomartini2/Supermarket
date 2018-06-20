package it.dstech.springsecurity.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import it.dstech.springsecurity.model.CartaCredito;
import it.dstech.springsecurity.model.User;
import it.dstech.springsecurity.repository.ICartaCreditoRepository;

@Service
public class CartaCreditoService {
	
	@Autowired
	private ICartaCreditoRepository dao;
	
	@Autowired
	private UserService userService;
	
	
	public CartaCredito findOne(Long id)  throws Exception{
	CartaCredito user = dao.findById(id).orElseThrow(()->new Exception());
		return user;
		
	}
	
	public CartaCredito findByNumero(String numero) {
		
		return dao.findByNumero(numero);
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
	
	public CartaCredito associaCartaCreditoUtente(Long idCarta) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUsername(auth.getName());

		CartaCredito carta = dao.findById(idCarta).get();
		List<CartaCredito> listaCarteCredito = user.getCartaCredito();
		if(listaCarteCredito==null) listaCarteCredito = new ArrayList<>();
		listaCarteCredito.add(carta);
		user.setCartaCredito(listaCarteCredito);
		carta.setUser(user);
		return dao.save(carta);

	}
	
	public CartaCredito create(CartaCredito carta) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = userService.findByUsername(auth.getName());
		
		List<CartaCredito> listaCarte =  u.getCartaCredito();
		if(listaCarte == null) listaCarte = new ArrayList<CartaCredito>();
		
		listaCarte.add(carta);
		carta.setUser(u);
		
		return dao.save(carta);

	}
}
