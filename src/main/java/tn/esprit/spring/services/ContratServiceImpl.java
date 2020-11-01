package tn.esprit.spring.services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class ContratServiceImpl implements IContratService {


	@Autowired
	ContratRepository contratRepository;
	@Autowired
	EmployeRepository employeRepository;
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	
	
	@Override
	public List<Contrat> getAllContrats() {
		return (List<Contrat>) contratRepository.findAll();
	}


	@Override
	public int ajouterContrat(Contrat contrat) {
		l.info("In ajouterContrat : ");
		contratRepository.save(contrat);
		l.info("out of ajouterContrat:");
		return contrat.getReference();
	}


	@Override
	public void affecterContratAEmploye(int conID, int empID) {
		l.info("In affecterContratAEmploye :");
		Contrat ctrManagedEntity = contratRepository.findById(conID).get();
		Employe employeManagedEntity = employeRepository.findById(empID).get();
		l.debug("check contrat employee by ID  : ");
		ctrManagedEntity.setEmploye(employeManagedEntity);

		l.debug("save to contrat repository");
		contratRepository.save(ctrManagedEntity); 
		l.info("out of affecterContratAEmploye");
	}


	@Override
	public void deleteContratById(int ContratId) {
		l.info("In deleteContratById : ");
		l.debug("check for contrat id then delete");
		Contrat contratManagedEntity = contratRepository.findById(ContratId).get();
		contratRepository.delete(contratManagedEntity);
		l.info("out of deleteContratById");
	}


	@Override
	public Contrat getContratById(int ContratId) {
		return contratRepository.findById(ContratId).get();
	}

}
