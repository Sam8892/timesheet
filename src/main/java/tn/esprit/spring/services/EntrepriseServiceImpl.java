package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);

	@Autowired
	EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;

	public int ajouterEntreprise(Entreprise entreprise) {
		l.info("Entreprise : ");
		entrepriseRepoistory.save(entreprise);
		l.debug("entreprise +++ : " + entreprise);
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		l.debug("Departement +++ : " + dep);
		return dep.getId();
	}

	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		// Le bout Master de cette relation N:1 est departement
		// donc il faut rajouter l'entreprise a departement
		// ==> c'est l'objet departement(le master) qui va mettre a jour
		// l'association
		// Rappel : la classe qui contient mappedBy represente le bout Slave
		// Rappel : Dans une relation oneToMany le mappedBy doit etre du cote
		// one.
		l.info("in departement id = " + depId);
		l.info("in entreprise id = " + entrepriseId);
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		l.info("entrepriseManagedEntity : " + entrepriseManagedEntity);
		Departement depManagedEntity = deptRepoistory.findById(depId).get();
		l.info("depManagedEntity : " + depManagedEntity);

		depManagedEntity.setEntreprise(entrepriseManagedEntity);
		deptRepoistory.save(depManagedEntity);

	}

	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		List<String> depNames = new ArrayList<>();
		for (Departement dep : entrepriseManagedEntity.getDepartements()) {
			depNames.add(dep.getName());
			l.info("depNames : " + depNames);
		}

		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		l.debug("deleteEntrepriseById : " + entrepriseId);
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		l.debug("deleteDepartementById : " + depId);
		deptRepoistory.delete(deptRepoistory.findById(depId).get());
	}

	public Entreprise getEntrepriseById(int entrepriseId) {
		l.debug("deleteDepartementById : " + entrepriseId);
		return entrepriseRepoistory.findById(entrepriseId).get();
	}

}
