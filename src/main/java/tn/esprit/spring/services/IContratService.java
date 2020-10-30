package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;


public interface IContratService {
	
	
	public List<Contrat> getAllContrats();
	public int ajouterContrat(Contrat contrat);
	public void affecterContratAEmploye(int conID, int empID);
	public void deleteContratById(int ContratId);
	public Contrat getContratById(int ContratId);
    
	
	
	

	
}
