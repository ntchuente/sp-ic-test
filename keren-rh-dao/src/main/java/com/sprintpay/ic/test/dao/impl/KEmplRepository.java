package com.sprintpay.ic.test.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprintpay.ic.test.rh.KEmpl;


/**
 * @author SPRINT-PAY-NTW
 *
 */

@Repository
public interface KEmplRepository extends JpaRepository<KEmpl, Long> {
	
	 public KEmpl findByLastName(String name);

}
