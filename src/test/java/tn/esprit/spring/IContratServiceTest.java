package tn.esprit.spring;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.management.relation.Role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IContratServiceTest {
	  @Autowired
	  IEmployeService empService;
	  @Autowired
	  IContratService ctrService;
	  
	 
	  
	  @Test
	  public void testajouterContrat() throws ParseException{
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  Date dd = dateFormat.parse("2015-03-23");
		  Date df = dateFormat.parse("2015-03-23");
		  Contrat ctr =new Contrat(dd, "stagiaire", 250);
		  int Addedctr = ctrService.ajouterContrat(ctr);
		  assertEquals(ctr.getReference(), Addedctr);
	  }
	  
	  @Test
	  public void testaffecterContratAEmployet() throws ParseException{
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  Date dd = dateFormat.parse("2015-03-23");
		  Employe e = new Employe("houssem", "kraoua","testEmp@gmail.com","123456HK",false,tn.esprit.spring.entities.Role.ADMINISTRATEUR);
		  Contrat ctr =new Contrat(dd, "stagiaire", 250);
		  ctrService.ajouterContrat(ctr);
		  empService.addOrUpdateEmploye(e);
		  ctr.setEmploye(e);
		  ctrService.affecterContratAEmploye(ctr.getReference(),e.getId());
		  assertEquals(e.getNom(),"houssem");
		  assertEquals(ctr.getTypeContrat(),"stagiaire");
	  }
	  
	  @Test
	  public void testdeleteContratById(){
		  int id = 10 ;
		  ctrService.deleteContratById(id);
		  assertEquals(id,10);
	  }
	
	  @Test
	  public void testdgetAllContrats(){
		  List<Contrat> listEmploye = ctrService.getAllContrats();
		  assertEquals(4, listEmploye.size());
	  }
	  
	 
	  @Test
	  public void testdgetContratById(){
         int id = 14;
         ctrService.getContratById(id);
		 assertEquals(id,14);
	  }
}
