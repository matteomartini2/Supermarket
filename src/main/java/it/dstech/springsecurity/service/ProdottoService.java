package it.dstech.springsecurity.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.springsecurity.model.CartaCredito;
import it.dstech.springsecurity.model.Categoria;
import it.dstech.springsecurity.model.Prodotto;
import it.dstech.springsecurity.model.Storico;
import it.dstech.springsecurity.repository.IProdottoRepository;

@Service
public class ProdottoService {
	
	@Autowired
	private IProdottoRepository dao;
	
	@Autowired
	private CartaCreditoService cartaCreditoService;
	
	@Autowired
	private StoricoService storicoService;
	
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
	
	public Prodotto update(Prodotto p) {
		
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
	
	public Storico acquista (List<Prodotto> listaProdotti, Long idCartaCredito) {
		

		for(Prodotto p : listaProdotti) {
			if(p.getQuantitaDisponibile() < 1) {
				return null;
				//TODO 
				// throw exception
			}
		}
		
		Double contoTotale = 0.0;
		
		for(Prodotto p : listaProdotti) {
			if(p.getOfferta() > 0) {
				contoTotale += (p.getPrezzoIvato() - (p.getPrezzoIvato()*p.getOfferta()/100));
			} else if (p.getDataDiScadenza().isEqual(LocalDate.now().minusDays(3))) {
				contoTotale += (p.getPrezzoIvato() - (p.getPrezzoIvato()*40/100));
			} else {
			contoTotale += p.getPrezzoUnitario();
			}
		}
		
		CartaCredito carta = cartaCreditoService.findOne(idCartaCredito);
		
		if(carta.getCredito() < contoTotale) {
			return null; 
			// TODO
			// lanciare exception
		}
		
		Storico s = new Storico();
		//user = current logged user
		
		s.setProdotti(new ArrayList<Prodotto>());
		for(Prodotto p : listaProdotti) {
			p.setQuantitaDisponibile(p.getQuantitaDisponibile()-1);
			s.getProdotti().add(p);
		}
		s.setTotale(contoTotale);
		s.setData(LocalDate.now());
		
		for(Prodotto p : listaProdotti) {
			update(p);
		}
		
		return storicoService.create(s);
		
	}
	
	public Iterable<Prodotto> findByDisponibilita() {
		
		ArrayList<Prodotto> listaDisponibili = (ArrayList<Prodotto>) dao.findAll();
		
		for(Prodotto p : listaDisponibili) {
			if(p.getQuantitaDisponibile() < 1) {
				listaDisponibili.remove(p);
			}
		}
		
		return listaDisponibili;
	}
	
	public Iterable<Prodotto> findByCategoria(Categoria categoria) {
		
		return dao.findByCategoria(categoria);
	}

}
