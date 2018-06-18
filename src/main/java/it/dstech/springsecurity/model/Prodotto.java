package it.dstech.springsecurity.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Prodotto extends Base{
	/**
	 * Prodotto
	 id: int;
	 nome: string;
	 marca: string;
	 dataDiScadenza: LocalDate; (prodotti con scadenza <3gg sconto 40%)
	 categoria: Categoria;
	 quantitaDisponibile: int;
	 unita: Unita;
	 prezzoUnitario: double;
	 prezzoIvato: double;
	 offerta: int; (percentuale, random 5 prodotti in offerta al giorno)
	 */
	
	@Column
	private String nome;
	
	@Column
	private String marca;
	
	@Column(name="data_di_scadenza")
	private LocalDate dataDiScadenza;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@Column(name="quantita_disponibile")
	private int quantitaDisponibile;
	
	@Enumerated(EnumType.STRING)
	private Unita unita;
	
	@Column(name="prezzo_unitario")
	private double prezzoUnitario ;
	
	@Column(name="prezzo_ivato")
	private double prezzoIvato;
	
	@Column
	private int offerta;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public LocalDate getDataDiScadenza() {
		return dataDiScadenza;
	}

	public void setDataDiScadenza(LocalDate dataDiScadenza) {
		this.dataDiScadenza = dataDiScadenza;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}

	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}

	public Unita getUnita() {
		return unita;
	}

	public void setUnita(Unita unita) {
		this.unita = unita;
	}

	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public double getPrezzoIvato() {
		return prezzoIvato;
	}

	public void setPrezzoIvato(double prezzoIvato) {
		this.prezzoIvato = prezzoIvato;
	}

	public int getOfferta() {
		return offerta;
	}

	public void setOfferta(int offerta) {
		this.offerta = offerta;
	}
	
	
	
}
