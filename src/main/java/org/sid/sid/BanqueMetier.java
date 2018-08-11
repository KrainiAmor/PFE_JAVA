package org.sid.sid;



import java.util.Date;

import org.sid.DAO.CompteRepast;
import org.sid.DAO.OperationRepastory;
import org.sid.entites.Compte;
import org.sid.entites.CompteCourant;
import org.sid.entites.Operation;
import org.sid.entites.Retrait;
import org.sid.entites.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional

public class BanqueMetier implements IBanqueMetier {
	@Autowired
	private CompteRepast compterepa;
	@Autowired
	private OperationRepastory operationRepastory;

	@Override
	public Compte consuletCompte(String codecompte) {
		Compte cp=compterepa.findOne(codecompte);
		if(cp==null) 
			throw new RuntimeException("compte introuvable");
		
		return cp;
	}

	@Override
	public void verser(String codecompte, double montant) {
		Compte cp=consuletCompte(codecompte);
		Versement v=new Versement(new Date(), montant, cp);
		operationRepastory.save(v);
		cp.setSolde(cp.getSolde()+montant);
		compterepa.save(cp);
		 
		
		

	}

	@Override
	public void retrie(String codecompte, double montant) {
		Compte cp=consuletCompte(codecompte);
		double faciliteCaisee=0;
		if(cp instanceof CompteCourant)
			faciliteCaisee=((CompteCourant) cp).getDecouvert();
		if(cp.getSolde()+faciliteCaisee<montant)
			throw new RuntimeException("solde insuffisant");
		Retrait r=new Retrait(new Date(), montant, cp);
		operationRepastory.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compterepa.save(cp);
		

	}

	@Override
	public void virmen(String codecompte1, String codecompte2, double montant) {
		if(codecompte1.equals(codecompte2))
			throw new RuntimeException("operation impossible");
		retrie(codecompte1, montant);
		verser(codecompte2, montant);

	}

	@Override
	public Page<Operation> listOper(String codeCompte, int page, int size) {
		
		return operationRepastory.listoper(codeCompte, new PageRequest(page, size));
	}

	

}
