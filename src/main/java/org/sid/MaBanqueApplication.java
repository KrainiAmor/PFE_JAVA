package org.sid;

import java.util.Date;

import org.sid.DAO.ClientRepastory;
import org.sid.DAO.CompteRepast;
import org.sid.DAO.OperationRepastory;
import org.sid.entites.Client;
import org.sid.entites.Compte;
import org.sid.entites.CompteCourant;
import org.sid.entites.CompteEpargne;
import org.sid.entites.Operation;
import org.sid.entites.Retrait;
import org.sid.entites.Versement;
import org.sid.sid.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MaBanqueApplication implements CommandLineRunner {
	@Autowired
	private ClientRepastory clientrepastroy;
	@Autowired
	private CompteRepast compterepas;
	@Autowired
	private OperationRepastory operationRepastory;
	@Autowired
	private IBanqueMetier banqueMetier;
	

	public static void main(String[] args) {
		
		SpringApplication.run(MaBanqueApplication.class, args);
		 
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*
	Client c1=	clientrepastroy.save(new Client("amor", "amor@hotmail.com"));
	Client c2=	clientrepastroy.save(new Client("amor2", "amor@hotmail.com"));
	Client c3=	clientrepastroy.save(new Client("khaled", "amor@hotmail.com"));
	Compte cp1= compterepas.save(new CompteCourant("c1", new Date(), 200, c1, 6000));
	Compte cp2=compterepas.save(new CompteEpargne("c2", new Date(), 300, c2, 5.5));
	Operation op2=operationRepastory.save(new Versement(new Date(), 40, cp1));
	Operation op3=operationRepastory.save(new Versement(new Date(), 400, cp1));
	Operation op1=operationRepastory.save(new Retrait(new Date(), 300, cp1));
	Operation op4=operationRepastory.save(new Versement(new Date(), 40, cp2));
	Operation op5=operationRepastory.save(new Versement(new Date(), 400, cp2));
	Operation op6=operationRepastory.save(new Retrait(new Date(), 300, cp2));
	banqueMetier.verser("c1", 5000);
	banqueMetier.verser("c1", 4000);
	*/
	
		
		
	}
}
