package com.sprintpay.ic.test.main;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprintpay.ic.test.dao.impl.KEmplRepository;
import com.sprintpay.ic.test.rh.KEmpl;
import com.sprintpay.ic.test.service.KEmplService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 */

/**
 * @author SPRINT-PAY-NTW
 *
 */
public class StepsDefinitions extends KerenIntegrationTest {
	
	String exceptionMessage;
	KEmpl newEmploye;
	KEmpl oldEmploye;
	
	@Autowired
	KEmplRepository employeRepository;
	@Autowired
	KEmplService employeService;
	
	@Given("^Qu'il y'a aucun employe avec le nom \"([^\"]*)\"$")
	public void quilyaaucunemployeaveclenom(String arg1) throws Exception {
		KEmpl employee = this.employeRepository.findByLastName(arg1);
	  	if(employee != null) {
		  this.employeRepository.delete(employee);
		  }
		  assertTrue(this.employeRepository.findByLastName(arg1) == null);
	}

	@When("^Un nouveau user essaie de creer avec le nom \"([^\"]*)\"$")
	public void unnouveauuseressaiedecreeraveclenom(String arg1) {
		newEmploye = new KEmpl();
		newEmploye.setLastName("arg1");
		newEmploye.setFirstName("firstName");
		newEmploye.setCreatedAt(new Date());
		newEmploye.setUpdatedAt(new Date());
		try {
		this.employeService.createnewEmployee(newEmploye);
		}catch(Exception e) {
		exceptionMessage = e.getMessage();
		}
	}

	@Then("^Un nouveau employe est crée avec le nom \"([^\"]*)\"$")
	public void unnouveauemployeestcréeaveclenom(String arg1) throws Exception {
		assertTrue(this.employeRepository.findByLastName(arg1).getLastName().equals(arg1));
	}

	

}
