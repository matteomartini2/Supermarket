package it.dstech.springsecurity.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.springsecurity.model.Categoria;
import it.dstech.springsecurity.model.Prodotto;

public interface IProdottoRepository  extends CrudRepository<Prodotto, Long>{
	
	public Iterable<Prodotto> findByCategoria(Categoria categoria);

}
