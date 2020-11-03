package tn.esprit.spring;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {

	@Autowired
	IEntrepriseService IEntreprise;
	@Autowired
	IDepartementService IDepartement;
	
	
	@Test
	public void testAjouterEntreprise() {
	
		Entreprise entreprise = new Entreprise("Esprit", "Ariana"); 
		int  entrepriseAdded = IEntreprise.ajouterEntreprise(entreprise);
		assertEquals(entrepriseAdded,entreprise.getId());
		
	}
	
	@Test
	public void testAjouterDepartement() {
		Departement dep = new Departement("electronique");
		int  departementAdded = IEntreprise.ajouterDepartement(dep);
		assertEquals(departementAdded,dep.getId());
		
	}
	
	
	
	@Test
	public void testAffecterDepartementAEntreprise() {
		
		
		IEntreprise.affecterDepartementAEntreprise(8, 10);
		
	}
	
	@Test
	public void getAllDepartementsNamesByEntreprise() {
		
		List<String>  names =  IEntreprise.getAllDepartementsNamesByEntreprise(3);
		
		assertEquals(3,names.size());
		
	}
	
	@Test
	public void testDeleteEntrepriseById() {
		IEntreprise.deleteEntrepriseById(49);
		
	}


	
	
	
	@Test
	public void testDeleteDepartementById() {
		IEntreprise.deleteDepartementById(48);
		
		
		
	}
	
	
	@Test
	public void testGetEntrepriseById() {
		Entreprise e = IEntreprise.getEntrepriseById(4);
		assertEquals(4,e.getId());

		
	}
	
}
