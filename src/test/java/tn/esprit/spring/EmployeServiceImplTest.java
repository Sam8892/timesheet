package tn.esprit.spring;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	
	@Autowired
	IEmployeService emp ; 
	@Autowired
	IContratService con ; 
	

	@Test
	public void testAuthenticate () {
		 Employe e = new Employe("Junit", "Junit","test1@gmail.com" ,"l123456",false,Role.INGENIEUR);
		Employe Authentification = emp.authenticate(e.getEmail(), e.getPassword());
	    //assertEquals ("test1@gmail.com", Authentification.getEmail());
		assertEquals("hhhhhhh", Authentification.getEmail());
	}
	
	@Test
	public void testaddOrUpdateEmploye (){
		
		Employe e = new Employe("BenFoulen ", "foulen ","foulen2@gmail.com","123456",true,Role.TECHNICIEN);
		
		int employeAdded = emp.addOrUpdateEmploye(e);
		assertNotNull (e);
	}
	
	@Test
	public void testmettreAjourEmailByEmployeId (){
	  Employe e =new Employe() ;
       e.setEmail("saddemTest@gmail.com");
	   e.setId(5);
       emp.mettreAjourEmailByEmployeId(e.getEmail(), e.getId());
     assertEquals(e.getEmail(),"saddemTest2@gmail.com" );
     
	}
	
	@Test
	public void testaffecterEmployeADepartement (){
		Employe e = new Employe(1,"Saddem", "Laifi","foulen2@gmail.com","laifi123",false,Role.ADMINISTRATEUR) ;
		
	    Departement d = new Departement(1 ,"Informatique");
	    
		emp.affecterEmployeADepartement(e.getId(), d.getId());
			
	     assertEquals(e.getNom(),"Laifi");
	     assertEquals(d.getName(),"Informatique");
				
		}
	
	@Test
	public void testdesaffecteremployeDuDepartement () {
     Employe e = new Employe(1,"Saddem", "Laifi","foulen2@gmail.com","laifi123",false,Role.ADMINISTRATEUR) ;
	 Departement d = new Departement(1 ,"Informatique");
	 emp.desaffecterEmployeDuDepartement(e.getId(), d.getId());
     assertEquals(d.getName(),"Informatique");

	}
	
    @Test
	public void testajouterContrat() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse ("2020-10-23");
		Contrat c = new Contrat (d ,"SIVP", 2f);
		
		int contratAdded = emp.ajouterContrat(c);
		assertEquals(c.getTypeContrat(), "SIVP");
	}
	
	@Test
	 public void testaffecterContratAEmploye() throws ParseException{
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Date d = dateFormat.parse ("2020-10-23");
		 Contrat c = new Contrat (5,d ,"SIVP", 1f);
		
	     Employe e = new Employe(4,"John");
	    
	     emp.affecterContratAEmploye(c.getReference(), e.getId());
		// assertEquals(e.getNom(),"Dao") ;
		 assertEquals (c.getTypeContrat(), "SIVP");
	 }
	 
	@Test
	public  void testgetEmployePrenomById  () {
		Employe e = new Employe() ;
		e.setId(1);
		
		String PrenomEmploye = emp.getEmployePrenomById(e.getId());
		assertEquals(PrenomEmploye, "Saddem");
	}
	
	
	
      @Test
		public void testdeleteEmployeById (){
			/***** complete this Method */
		}
		
	
   @Test
	public void testdeleteContratById (){
		int id = 1 ;
		emp.deleteContratById(id);
		assertEquals(id,1);
	}
	
    @Test
    public void testgetNomberEmployeJPQL(){
    	int nbrEmploye = emp.getNombreEmployeJPQL();
    	assertEquals(4, nbrEmploye);
    }
	
	@Test
	public void testgetAllEmployeNamesJPQL(){
		List<Employe> listEmploye = emp.getAllEmployes(); 
		
		assertEquals(4, listEmploye.size());
	}
	@Test
	public void testgetAllEmplyeByEntreprise () {
		Entreprise entr = new Entreprise("Wevoo","test test test");
		entr.setId(1);
		List<Employe> listEmploye2 = emp.getAllEmployeByEntreprise(entr);
		assertEquals(3, listEmploye2.size());
	}
	@Test
	public void testmettreAjourEmailByEmployeIdJPQL (){
	  Employe e =new Employe() ;
       e.setEmail("saddemTestSucces@gmail.com");
	   e.setId(4);
       emp.mettreAjourEmailByEmployeIdJPQL(e.getEmail(), e.getId());
       assertEquals(e.getEmail(),"saddemTestSucces@gmail.com" );
     
	}
	
	@Test
	public void testdeleteAllContratJPQL(){
		//List<Contrat> listContrat = con.getAllContrats();
		emp.deleteAllContratJPQL();
		List<Contrat> listContrat = con.getAllContrats();
		assertEquals(0,listContrat.size());
		
		
	}
	
	@Test
	public void testgetSalaireByEmployeIdJPQL(){
		Employe e = new Employe(4,"John");
		 
		float salaireEmploye = emp.getSalaireByEmployeIdJPQL(e.getId());
	
		assertEquals( 1f,salaireEmploye ,0f);
		
	}
	
	@Test
	public void testgetSalaireMoyenbyDepartementID(){
		 Departement d = new Departement(1 ,"Informatique");
		 Double salaireMoyen = emp.getSalaireMoyenByDepartementId(d.getId());
		
		 assertEquals(2.0 ,salaireMoyen,0);
		
	}
	
	@Test
	public void testTimesheetsByMissionAndDate(){
		/*** complete this Method */
	}
	
	@Test
	public void testgetAllEmployes(){
		List<Employe> employes  = emp.getAllEmployes() ;
		assertEquals(4,employes.size());
	}
	
}
