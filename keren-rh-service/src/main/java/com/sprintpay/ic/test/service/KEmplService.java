/**
 * 
 */
package com.sprintpay.ic.test.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.sprintpay.ic.test.rh.KEmpl;

/**
 * @author SPRINT-PAY-NTW
 *
 */
public interface KEmplService {

	 public KEmpl getEmployeeByName(String name) ;
	 
	 public List<KEmpl>getAllEmployes();
	 	 
	 public KEmpl findById(long id );
	 
	 public void deleteById( @NotNull Long id);
	 
	 public KEmpl create(KEmpl entity);
	 
	 public KEmpl update(KEmpl entity);
	 public List<KEmpl> findAll();
}
