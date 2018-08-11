package org.sid.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dType",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class Compte implements Serializable {
	@Id
	private String code;
	private Date dateCre;
	private double solde;
	@ManyToOne
	@JoinColumn(name="codeCLI")
	private Client client;
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
public Compte() {
	// TODO Auto-generated constructor stub
}
public Compte(String code, Date dateCre, double solde, Client client) {
	super();
	this.code = code;
	this.dateCre = dateCre;
	this.solde = solde;
	this.client = client;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public Date getDateCre() {
	return dateCre;
}
public void setDateCre(Date dateCre) {
	this.dateCre = dateCre;
}
public double getSolde() {
	return solde;
}
public void setSolde(double solde) {
	this.solde = solde;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Collection<Operation> getOperations() {
	return operations;
}
public void setOperations(Collection<Operation> operations) {
	this.operations = operations;
}

}
