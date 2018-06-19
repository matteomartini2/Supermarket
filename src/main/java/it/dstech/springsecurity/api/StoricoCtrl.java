package it.dstech.springsecurity.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.springsecurity.model.Storico;
import it.dstech.springsecurity.service.StoricoService;

@RestController
@RequestMapping("/storico")
public class StoricoCtrl {
		@Autowired
		StoricoService serviceStorico;
		
		@PostMapping("/")
		public Storico create(@RequestBody Storico storico) {
			return serviceStorico.create(storico);
		}
		
		@PostMapping("/many")
		public Iterable<Storico> createMany(@RequestBody List<Storico> storici){
			return serviceStorico.create(storici);
		}
		
		@PutMapping("/")
		public Storico update(@RequestBody Storico storico) {
			return serviceStorico.update(storico);
		}
		
		@GetMapping("/{id}")
		public Iterable<Storico> findOne(@PathVariable("id") Long id) {
			return serviceStorico.findByUserId(id);
		}
		
		@GetMapping("/")
		public Iterable<Storico> findAll(){
			return serviceStorico.findAll();
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable("id") Long id) {
			serviceStorico.delete(id);
		}
		
		@DeleteMapping("/")
		public void delete(@RequestBody Storico storico) {
			serviceStorico.delete(storico);
		}
		
		@DeleteMapping("/all")
		public void deleteAll() {
			serviceStorico.purge();
		}
		
		@DeleteMapping("/many")
		public void deleteMany(@RequestBody Iterable<Storico> storici) {
			serviceStorico.deleteAll(storici);
		}
		
		
		
}	
