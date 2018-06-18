package it.dstech.springsecurity.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class User extends Base {
	
	@Column(name = "username", nullable = false, unique = true)
	private String username; //mail
	
	@Column(name = "password", nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private RoleUser role;
	
	@Column(name = "tel", nullable = false, unique = true)
	private String tel;
	
	@Column(name = "cap", nullable = false)
	private String cap;
	
	@Column(name = "citta", nullable = false)
	private String citta;
	
	@Column(name = "prov", nullable = false)
	private String prov;
	
	private List<CartaCredito> cartaCredito;
	
	private List<Storico> storico;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public RoleUser getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleUser role) {
		this.role = role;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the cap
	 */
	public String getCap() {
		return cap;
	}

	/**
	 * @param cap the cap to set
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}

	/**
	 * @return the citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * @param citta the citta to set
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}

	/**
	 * @return the prov
	 */
	public String getProv() {
		return prov;
	}

	/**
	 * @param prov the prov to set
	 */
	public void setProv(String prov) {
		this.prov = prov;
	}

	/**
	 * @return the cartaCredito
	 */
	public List<CartaCredito> getCartaCredito() {
		return cartaCredito;
	}

	/**
	 * @param cartaCredito the cartaCredito to set
	 */
	public void setCartaCredito(List<CartaCredito> cartaCredito) {
		this.cartaCredito = cartaCredito;
	}

	/**
	 * @return the storico
	 */
	public List<Storico> getStorico() {
		return storico;
	}

	/**
	 * @param storico the storico to set
	 */
	public void setStorico(List<Storico> storico) {
		this.storico = storico;
	}

}
