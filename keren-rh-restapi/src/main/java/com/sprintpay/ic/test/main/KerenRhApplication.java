/**
 * 
 */
package com.sprintpay.ic.test.main;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.sprintpay.ic.test.rh.KEmpl;
import com.sprintpay.ic.test.service.KEmplService;

/**
 * @author SPRINT-PAY-NTW
 *
 */
//@SpringBootApplication
//@EnableJpaRepositories("com.sprintpay.ic.test.service")
//@EntityScan("com.sprintpay.ic.test.rh")
public class KerenRhApplication implements CommandLineRunner {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	KEmplService emplRepository;

	public static void main(String[] args)  {
		//ApplicationContext ctx =
		 SpringApplication.run(KerenRhApplication.class, args);
	}
	 @Override
	    public void run(String... args) throws Exception {
	        System.out.println("Our DataSource is = " + dataSource);
	        List<KEmpl> list = emplRepository.getAllEmployes();
	        for(KEmpl entity :list){
	            System.out.println("Employé is : " + entity.toString());
	        }
	    }
}
