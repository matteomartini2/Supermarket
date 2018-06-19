package it.dstech.springsecurity.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.springsecurity.model.CartaCredito;
import it.dstech.springsecurity.service.CartaCreditoService;

@RestController
@RequestMapping(name="/cartacredito")
public class CartaCreditoCtrl {
	
	@Autowired
	CartaCreditoService serviceCarta;
	
	
	@GetMapping("/findAll")
	public Iterable<CartaCredito> findAll(){
		return serviceCarta.findAll();
	}
	
	@GetMapping("/findOne}")
	public CartaCredito findOne(Long id) {
		return serviceCarta.findOne(id);
		
	}
	
	@PostMapping("/update")
	public void update(@RequestBody CartaCredito carta ) {
		serviceCarta.update(carta);
		
	}
	
	@DeleteMapping("/deleteOne")
	public void delete(@PathVariable ("id") Long id) {
		serviceCarta.deleteOne(id);
		
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		serviceCarta.deleteAll();
		
	}
	

}
