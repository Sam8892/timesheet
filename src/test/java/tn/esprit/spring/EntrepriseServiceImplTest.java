package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {

	@Autowired
	IEntrepriseService IEntreprise;
	
	@Test
	public void testajouterEntreprise() {
		
		
		Entreprise entr = new Entreprise("Esprit", "Ariana"); 
		int  entrepriseAdded = IEntreprise.ajouterEntreprise(entr);
		
		assertEquals(entr.getId(), entrepriseAdded);
		
	}
	@Test
	public void ajouterDepartement() {
		Departement dep = new Departement("electronique");
		int  departementAdded = IEntreprise.ajouterDepartement(dep);
		assertEquals(departementAdded,dep.getId());
		
	}
	
}
