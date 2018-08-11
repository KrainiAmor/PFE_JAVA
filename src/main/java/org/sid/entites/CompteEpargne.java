package org.sid.entites;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	private double taux;
	public CompteEpargne() {
	
	}
	public CompteEpargne(String code, Date dateCre, double solde, Client client,double taux) {
		super(code, dateCre, solde, client);
		this.taux=taux;
		
		
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	

}
