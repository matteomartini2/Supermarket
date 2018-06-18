package it.dstech.springsecurity.repository;

import org.springframework.data.repository.CrudRepository;

import it.dstech.springsecurity.model.User;

public interface IUserRepository extends CrudRepository<User, Long>{
	
	public User findByUsername(String username);

}
