package org.sid.entites;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("V")

public class Versement extends Operation {

	public Versement() {
		super();
		
	}

	public Versement(Date dateOpe, double montant, Compte compte) {
		super(dateOpe, montant, compte);
		
	}

}
