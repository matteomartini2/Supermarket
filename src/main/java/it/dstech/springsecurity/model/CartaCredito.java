package it.dstech.springsecurity.model;

import java.time.LocalDate;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="carta_credito")
public class CartaCredito  extends Base{
	
	@Column (name= "cvv", nullable= false)
	private String cvv;
	
	@Column(name= "credito", nullable = false)
	private Double credito;

	//manytoOne 
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="user_id", nullable= false)
	private User user;
	
	@Column(name="scadenza", nullable=false)
	private LocalDate scadenza;
	
	@Column(name= "numero", unique = true, nullable = false)
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
