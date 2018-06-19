package it.dstech.springsecurity.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="storico")
public class Storico extends Base {
	
	// ManyToOne
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	// OneToMany
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="storico")
	private List<Prodotto> prodotti;
	
	@Column(name = "totale", nullable = false)
	private Double totale;
	
	@Column(name = "data", nullable = false)
	private LocalDate data;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the prodotti
	 */
	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	/**
	 * @param prodotti the prodotti to set
	 */
	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	/**
	 * @return the totale
	 */
	public Double getTotale() {
		return totale;
	}

	/**
	 * @param totale the totale to set
	 */
	public void setTotale(Double totale) {
		this.totale = totale;
	}

	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}

	
}
