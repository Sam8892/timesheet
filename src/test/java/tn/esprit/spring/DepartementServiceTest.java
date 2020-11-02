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

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceTest {

	  @Autowired
	  IDepartementService depService; 
	  
	  
      @Test
	  public void testajouterDepartement() throws ParseException{
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  Date dd = dateFormat.parse("2015-03-23");
		  Departement departement =new Departement(2, "haythem");
		  int AddDep = depService.ajouterDepartement(departement);
		  assertEquals(departement.getId(), AddDep);
	  }
	  


      @Test
	  public void testdgetAllDepartement(){
		  List<Departement> listDepartement = depService.getAllDepartements();
		  assertEquals(listDepartement.size(), listDepartement.size());
	  }
	  
}