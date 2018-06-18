package it.dstech.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.springsecurity.model.Prodotto;
import it.dstech.springsecurity.repository.IProdottoRepository;

@Service
public class ProdottoService {
	
	@Autowired
	private IProdottoRepository dao;
	
	public Iterable<Prodotto> findAll() {
		
		return dao.findAll();
	}
	
	public Prodotto findOne(Long id) {
		
		return dao.findById(id).get();
	}
	
	public void deleteAll() {
		
		dao.deleteAll();
	}
	
	public void deleteOne(Long id) {
		
		dao.deleteById(id);
	}
	
	public Prodotto create(Prodotto p) {
		
		return dao.save(p);
	}
	
	public Prodotto update(Long id, Prodotto p) {
		
		Prodotto old = dao.findById(p.getId()).get();
		
		old.setCategoria(p.getCategoria());
		old.setDataDiScadenza(p.getDataDiScadenza());
		old.setMarca(p.getMarca());
		old.setNome(p.getNome());
		old.setOfferta(p.getOfferta());
		old.setPrezzoIvato(p.getPrezzoIvato());
		old.setPrezzoUnitario(p.getPrezzoUnitario());
		old.setQuantitaDisponibile(p.getQuantitaDisponibile());
		old.setUnita(p.getUnita());
		
		return dao.save(old);
	}

}
