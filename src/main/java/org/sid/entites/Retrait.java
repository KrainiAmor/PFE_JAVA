package org.sid.entites;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("R")

public class Retrait extends Operation {

	public Retrait() {
		super();
		
	}

	public Retrait(Date dateOpe, double montant, Compte compte) {
		super(dateOpe, montant, compte);
		
	}
	

}
