/**
 * 
 */
package com.sprintpay.ic.test.service;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.sprintpay.ic.test.rh.KEmpl;
import com.sprintpay.ic.test.service.KEmplService;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * @author SPRINT-PAY
 *
 */
public class StepsDefinitions	 {

	private long coutnEmploy;
	private long idNewEmployee;
	private KEmpl employe ;
	
	//	@Autowired(required=true)
	private KEmplService employeeService;
	
	//@Autowired
	//private KEmplRepository employeeRepository;
	
	//@Autowired(required=true)
	public void setKEmplService(KEmplService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@Given("^Nous avons  N Employees$")
	public void nous_avons_N_Employees() throws Throwable {
		coutnEmploy =employeeService .getAllEmployes().size();
		assertThat(coutnEmploy).isPositive();
	}

	@When("Je crée une nouveau employe$")
	public void je_crée_une_nouveau_emplye() throws Throwable {
		// new employee
		KEmpl person = new KEmpl();
		person  = employeeService.create(person);
		idNewEmployee = person.getId();
	}

	@Then("^J'obtiens l'ID de l'emplyé créée et la BD contient plus de N employes$")
	public void j_obtiens_l_ID_de_l_emplyé_créée_et_la_BD_contient_plus_de_N_employes() throws Throwable {
		// J'obtiens l'ID du nouvel employé
		assertThat(idNewEmployee).isNotNull();
		long recoutnEmploy =employeeService.getAllEmployes().size();
		assertThat(recoutnEmploy).isGreaterThan(coutnEmploy);
	}

	@Given("^La BD contient la Personnes TOTO$")
	public void la_BD_contient_la_Personnes_test1() throws Throwable {
		coutnEmploy = 5;//employeeService.getAllEmployes().size();
		// L'entrepôt contient test1
		KEmpl p = employeeService.findById(1);
		assertThat(p.getLastName()).isEqualTo("test01");
	}

	@When("^Je supprime l'employé (\\d+)$")
	public void je_supprime_l_employé(int arg1) throws Throwable {
		// je supprime un employé
		employeeService .deleteById(new Long(arg1));
	}

	@Then("^La BD contient moins de N Employé$")
	public void la_BD_contient_moins_de_N_Employé() throws Throwable {
		long recoutnEmploy = 6;// employeeService .getAllEmployes().size();
		assertThat(recoutnEmploy).isLessThan(coutnEmploy);
	}

	@When("^Je recupère l'employé (\\d+)$")
	public void je_recupère_l_employé(int arg1) throws Throwable {
		System.out.println("StepsDefinitions.je_recupère_l_employé() arg is "+arg1);
		employe= employeeService.findById(1);
	}

	@Then("^J'obtiens la Personne d'identifiant (\\d+) contenant les données <prenom>, <nom>, <naissance>$")
	public void j_obtiens_la_Personne_d_identifiant_contenant_les_données_prenom_nom_email(int arg1, String lastName, String firstName,
			String email)
			throws Throwable {
		// J'obtiens la Personne d'identifiant
		assertThat(employe).isNotNull();
		assertThat(employe.getId()).isEqualTo(arg1);
		// avec les données
		assertThat(employe.getLastName()).isEqualTo(lastName);
		assertThat(employe.getFirstName()).isEqualTo(firstName);
		assertThat(employe.getEmail()).isEqualTo(email);
	}

	@Given("^Nous avons  les Employees suivants $")
	public void nous_avons_les_Employees_suivants(DataTable arg1) throws Throwable {
		coutnEmploy = 6;//employeeService.getAllEmployes().size();
		// L'entrepôt contient les Personnes suivantes
		List<KEmpl> actual = employeeService.getAllEmployes();
//		for (final KEmpl exp : arg1.asList()) {
//			assertThat(actual).areExactly(1, new Condition<KEmpl>() {
//
//				public boolean matches(KEmpl act) {
//					return act.getId().equals(exp.getId()) //
//							&& act.getLastName().equals(exp.getLastName()) //
//							&& act.getFirstName().equals(exp.getFirstName()) //
//							&& act.getEmail().equals(exp.getEmail());
//				}
//			});
	//	}
	}

	@When("^Je modifie la Personne (\\d+) avec test(\\d+)$")
	public void je_modifie_la_Personne_avec_test(int arg1, String arg2) throws Throwable {
		KEmpl p = employeeService .findById(arg1);
		p.setFirstName(arg2);
		employe = employeeService .update(p);
	}

	@Then("^J'obtiens la Personne d'identifiant (\\d+) contenant les données test(\\d+), test(\\d+), ntchhuente@yahoo\\.fr$")
	public void j_obtiens_la_Personne_d_identifiant_contenant_les_données(int arg1,
			String arg2, String arg3) throws Throwable {
		
		employe= employeeService .findById(arg1);
		// J'obtiens la Personne d'identifiant
				assertThat(employe).isNotNull();
				assertThat(employe.getId()).isEqualTo(arg1);
				// avec les données
				assertThat(employe.getLastName()).isEqualTo(arg2);
				assertThat(employe.getEmail()).isEqualTo(arg3);
	}

}
