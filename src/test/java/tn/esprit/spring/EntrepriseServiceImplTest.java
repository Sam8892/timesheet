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
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {

	@Autowired
	IEntrepriseService IEntreprise;
	
	@Test
	public void testAjouterEntreprise() {
	
		Entreprise entr = new Entreprise("Esprit", "Ariana"); 
		int  entrepriseAdded = IEntreprise.ajouterEntreprise(entr);
		
		assertEquals(entr.getId(), entrepriseAdded);
		
	}
	@Test
	public void testAjouterDepartement() {
		Departement dep = new Departement("electronique");
		int  departementAdded = IEntreprise.ajouterDepartement(dep);
		assertEquals(departementAdded,dep.getId());
		
	}
	
	
	
	@Test
	public void testAffecterDepartementAEntreprise() {
		
		
		IEntreprise.affecterDepartementAEntreprise(4, 2);
		
		
		
	}
	
	@Test
	public void getAllDepartementsNamesByEntreprise() {
		List<String>  names =  IEntreprise.getAllDepartementsNamesByEntreprise(10);
		
		
	}
	
	@Test
	public void testDeleteEntrepriseById() {
		IEntreprise.deleteEntrepriseById(20);
		
	}
	
	@Test
	public void testDeleteDepartementById() {
		IEntreprise.deleteDepartementById(20);
		
	}
	
	
	@Test
	public void testGetEntrepriseById() {
		Entreprise e = IEntreprise.getEntrepriseById(4);
		assertEquals(4,e.getId());

		
	}
	
}
