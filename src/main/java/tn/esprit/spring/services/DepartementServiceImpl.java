package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {


	@Autowired
	DepartementRepository deptRepoistory;
	
	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);
	
	


	public List<Departement> getAllDepartements() {
		return (List<Departement>) deptRepoistory.findAll();
	}


	@Override
	public int ajouterDepartement(Departement departement) {
		l.info("In ajouterDepartement : ");
		deptRepoistory.save(departement);
		l.info("out of ajouterDepartement:");
		return departement.getId();
	}
	


	@Override
	public void deleteDepartementId(int departementId) {

		l.info("In deleteDepartementId : ");
		l.debug("check for departement id then delete");
		Departement departement = deptRepoistory.findById(departementId).get();
		deptRepoistory.delete(departement);
		l.info("out of deleteDepartementId");
		

	deptRepoistory.delete(departement);
		
	}

}
