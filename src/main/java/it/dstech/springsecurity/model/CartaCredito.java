package it.dstech.springsecurity.model;

import java.time.LocalDate;
import java.util.Base64;

import javax.persistence.Entity;

@Entity(name="cartacredito")
public class CartaCredito {
	
	private String cvv;
	private Double credito;
	private User user;
	private LocalDate scadenza;
	private String numero;
	
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public Double getCredito() {
		return credito;
	}
	public void setCredito(Double credito) {
		this.credito = credito;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public LocalDate getScadenza() {
		return scadenza;
	}
	public void setScadenza(LocalDate scadenza) {
		this.scadenza = scadenza;
	}
	public String getNumero() {
		byte[] decodedBytes = Base64.getDecoder().decode(numero);
		return new String(decodedBytes);
	}
	public void setNumero(String numero) {
		byte[] encodedBytes = Base64.getEncoder().encode(numero.getBytes());
		this.numero = new String(encodedBytes);
	}
	
	
	
	

}
