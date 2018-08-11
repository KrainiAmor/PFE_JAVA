package org.sid.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typop",discriminatorType=DiscriminatorType.STRING,length=1)

public  abstract class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numero;
	private Date dateOpe;
	private double montant;
	@ManyToOne
	@JoinColumn(name="codecomp")
	private Compte compte;
	public Operation() {
		
	}
	public Operation(Date dateOpe, double montant, Compte compte) {
		super();
		this.dateOpe = dateOpe;
		this.montant = montant;
		this.compte = compte;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Date getDateOpe() {
		return dateOpe;
	}
	public void setDateOpe(Date dateOpe) {
		this.dateOpe = dateOpe;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	

}
