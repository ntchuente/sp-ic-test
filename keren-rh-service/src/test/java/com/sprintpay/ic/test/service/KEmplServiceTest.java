/**
 * 
 */
package com.sprintpay.ic.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sprintpay.ic.test.dao.impl.KEmplRepository;
import com.sprintpay.ic.test.rh.KEmpl;
import com.sprintpay.ic.test.service.KEmplService;
import com.sprintpay.ic.test.service.impl.KEmplServiceImpl;

/**
 * @author SPRINT-PAY-NTW
 *
 */

//@RunWith(SpringRunner.class)
public class KEmplServiceTest {
	public static  KEmplRepository kemplRepository;
//	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public KEmplService employeeService() {
			return new KEmplServiceImpl(kemplRepository);
		}
	}

	//@Autowired
	private KEmplService employeeService;

	//@MockBean
	private KEmplRepository employeeRepository;

	//@Before
	public void setUp() {
		KEmpl search = new KEmpl();
		search.setLastName("Lokesh");

		Mockito.when(employeeRepository.findByLastName(search.getLastName())).thenReturn(search);
	}

	//@Test
	public void whenValidName_thenEmployeeFound() {
		String name = "Lokesh";
		KEmpl found = employeeService.getEmployeeByName(name);

		assertThat(found.getLastName()).isEqualTo(name);
	}

}
