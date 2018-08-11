package org.sid.sid;

import org.sid.entites.Compte;
import org.sid.entites.Operation;
import org.springframework.data.domain.Page;

public interface IBanqueMetier {
	public Compte consuletCompte(String codecompte);
    public void verser(String codecompte,double montant);
    public void retrie(String codecompte,double montant);
    public void virmen(String codecompte1,String codecompte2,double montant);
    public Page<Operation> listOper(String codeCompte,int page,int size);
    
}
