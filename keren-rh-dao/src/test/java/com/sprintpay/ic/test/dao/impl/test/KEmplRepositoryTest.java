/**
 * 
 */
package com.sprintpay.ic.test.dao.impl.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.sprintpay.ic.test.dao.impl.KEmplRepository;
import com.sprintpay.ic.test.rh.KEmpl;

/**
 * @author SPRINT-PAY-NTW
 *
 */

//@RunWith(SpringRunner.class)
//@DataJpaTest
//@EnableJpaRepositories("com.sprintpay.ic.test.dao")
//@EntityScan("com.sprintpay.ic.test.rh")
public class KEmplRepositoryTest {

    @Autowired
	private TestEntityManager entityManager;

	@Autowired
	private KEmplRepository employeeRepository;

	
	//@Before
	public void saveEntity() {
	// given
			KEmpl employ = new KEmpl();
			// for (int i = 0; i < 5; i++) {
			employ = this.getNewEmploye(2);
			entityManager.persist(employ);
			entityManager.flush();
			// }

	}
	//@Test
	public void whenFindByName_thenReturnEmployee() {
		
		// when
		KEmpl employfound = new KEmpl();
		employfound.setLastName("lastName2");
		KEmpl found = employeeRepository.findByLastName(employfound.getLastName());
		
		java.util.List<KEmpl> allemployes= employeeRepository.findAll();
		for(KEmpl empl : allemployes){
			System.out.println( empl.toString());
		}
		// then
		assertThat(employfound.getLastName()).isEqualTo(found.getLastName());
		
		assertThat(allemployes.size()).isEqualTo(4);
	}

	private KEmpl getNewEmploye(int values) {
		System.out.println("KEmplRepositoryTest.getNewEmploye() je construire employee");
		KEmpl employe = new KEmpl();

		employe.setEmail("nadege.tchuente@sprin-pay.com" + values);
		employe.setFirstName("firstName" + values);
		employe.setLastName("lastName" + values);;
		return employe;
	}

}
