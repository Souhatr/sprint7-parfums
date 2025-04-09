package com.souha.parfums.entities;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Parfum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idParfum;
	private String nomParfum;
	private Double prixParfum;
	private Date dateCreation;
	@ManyToOne
	private Marque marque;
	public Parfum() {
		super();
	}
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	public Parfum(String nomParfum, Double prixParfum, Date dateCreation) {
		super();
		this.nomParfum = nomParfum;
		this.prixParfum = prixParfum;
		this.dateCreation = dateCreation;
	}
	public Long getIdParfum() {
		return idParfum;
	}
	public void setIdParfum(Long idParfum) {
		this.idParfum = idParfum;
	}
	public String getNomParfum() {
		return nomParfum;
	}
	public void setNomParfum(String nomParfum) {
		this.nomParfum = nomParfum;
	}
	public Double getPrixParfum() {
		return prixParfum;
	}
	public void setPrixParfum(Double prixParfum) {
		this.prixParfum = prixParfum;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Parfum [idParfum=" + idParfum + ", nomParfum=" + nomParfum + ", prixParfum=" + prixParfum
				+ ", dateCreation=" + dateCreation + "]";
	}
	
	
	

}
