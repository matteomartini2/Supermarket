package it.dstech.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.dstech.springsecurity.model.Storico;

public interface IStoricoRepository extends CrudRepository<Storico, Long>{
	
		@Query("Select s from storico s where s.user.id= :id")
		List<Storico> findAllByUser(@Param("id") Long id);
}
