/**
 * 
 */
package com.sprintpay.ic.test.service;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author SPRINT-PAY
 *
 */
public class StepsDefinitions {

	@Given("^Nous avons  N Employees$")
	public void nous_avons_N_Employees() throws Throwable {
		System.out.println("************** j'ai 5 employées *********************");
	}

	@When("^Je crée une nouveau emplye$")
	public void je_crée_une_nouveau_emplye() throws Throwable {
		System.out.println("************** je crée un nouvel employé *********************");
	}

	@Then("^J'obtiens N\\+(\\d+) employes$")
	public void j_obtiens_N_employes(int arg1) throws Throwable {
		System.out.println("************** j'ai 6 employées *********************");
	}

	@Given("^La BD contient l'employe test(\\d+)$")
	public void la_BD_contient_l_employe_test(int arg1) throws Throwable {
		System.out.println("************** oui l'employé "+arg1+" existe *********************");
	}

	@When("^Je supprime l'employé (\\d+)$")
	public void je_supprime_l_employé(int arg1) throws Throwable {
		System.out.println("************** je suprime l'employé "+arg1+"  *********************");
	}

	@Then("^La BD contient  N-(\\d+) Employé$")
	public void la_BD_contient_N_Employé(int arg1) throws Throwable {
		System.out.println(" Après suppression ************** j'ai 5 employées *********************");
	}

	@When("^Je recupère l'employé (\\d+)$")
	public void je_recupère_l_employé(int arg1) throws Throwable {
		System.out.println("************** je recupére  l'employé "+arg1+"  *********************");
	}

	@Then("^J'obtiens l'employe  d'identifiant (\\d+) contenant les données test(\\d+), test(\\d+), test(\\d+)@yahoo\\.fr$")
	public void j_obtiens_l_employe_d_identifiant_contenant_les_données_test_test_test_yahoo_fr(int arg1, int arg2,
			int arg3, int arg4) throws Throwable {
		System.out.println("************** je recupére  l'employé "+arg1+"  *********************");
	}

	@Given("^Nous avons l'employe suivants$")
	public void nous_avons_l_employe_suivants(DataTable arg1) throws Throwable {
		System.out.println("************** liste des employé  *********************");
	}

	@When("^Je modifie l'employe  <firstName>$")
	public void je_modifie_l_employe_firstName() throws Throwable {
		System.out.println("************** lje modifie *********************");
	}

	@Then("^J'obtiens la Personne d'identifiant (\\d+) contenant les données <firstName>, <lastName>, <email>$")
	public void j_obtiens_la_Personne_d_identifiant_contenant_les_données_firstName_lastName_email(int arg1)
			throws Throwable {
		System.out.println("************** verification  *********************");
	}

}
