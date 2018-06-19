package it.dstech.springsecurity.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.springsecurity.model.Categoria;
import it.dstech.springsecurity.model.Prodotto;
import it.dstech.springsecurity.model.Storico;
import it.dstech.springsecurity.service.ProdottoService;

@RestController
@RequestMapping("/prodotto")
public class ProdottoCtrl {

	@Autowired
	private ProdottoService service;
	
	@GetMapping("")
	public Iterable<Prodotto> findAll() {
		
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Prodotto findOne(@PathVariable("id") Long id) {
		
		return service.findOne(id);
	}
	
	@GetMapping("/disponibili")
	public Iterable<Prodotto> disponibili() {
		
		return service.findByDisponibilita();
	}
	
	@GetMapping("/categoria")
	public Iterable<Prodotto> findByCategoria(@RequestHeader("categoria") Categoria categoria) {
		
		return service.findByCategoria(categoria);
	}
	
	@PutMapping("")
	public Storico acquista(@RequestBody List<Prodotto> listaProdotti, @RequestHeader("idCarta") Long idCartaCredito) {
		
		return service.acquista(listaProdotti, idCartaCredito);
	}
	
	@PostMapping("")
	public Prodotto create(@RequestBody Prodotto p) {
		
		return service.create(p);
	}
}
