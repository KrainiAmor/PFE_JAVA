package org.sid.web;

import org.sid.entites.Compte;
import org.sid.entites.Operation;
import org.sid.sid.BanqueMetier;
import org.sid.sid.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BanqueControlle {
	@Autowired
	private IBanqueMetier iBanqueMetier;
	@RequestMapping("/operations")
	public String index() {
		return"comptes"; 
		
	}
	@RequestMapping("/consulterCompte")
	public String consulterCompte(Model model,String codecompte,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="3")int size) {
		model.addAttribute("codecompte",codecompte);
		try {
		Compte cp=iBanqueMetier.consuletCompte(codecompte);
		  model.addAttribute("compte",cp);
		  Page<Operation> pageop=iBanqueMetier.listOper(codecompte, page, size);
		  int[] pages=new int[pageop.getTotalPages()];
		  model.addAttribute("pages", pages);
		  model.addAttribute("listOpertaions", pageop.getContent());
		}catch(Exception ex) {
			model.addAttribute("exception",ex);
		}
		  return "comptes";
	}
	@RequestMapping(value="/saveoperation",method=RequestMethod.POST)
	public String save(Model model,String typeOperation,String codecompte,double montant,String codecompte2) {
		try {
		if(typeOperation.equals("Verse")){
			iBanqueMetier.verser(codecompte, montant);
		}
		else if(typeOperation.equals("Ret")){
			iBanqueMetier.retrie(codecompte, montant);
			
		}
		else if(typeOperation.equals("Virm")){
			iBanqueMetier.virmen(codecompte, codecompte2, montant);
		
	}
		}catch(Exception ex) {
			model.addAttribute("error", ex);
			return "redirect:/consulterCompte?codecompte="+codecompte+"&error="+ex.getMessage();
		}
		return "redirect:/consulterCompte?codecompte="+codecompte;
	}
}


