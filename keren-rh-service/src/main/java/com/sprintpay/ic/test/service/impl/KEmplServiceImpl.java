package com.sprintpay.ic.test.service.impl;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.sprintpay.ic.test.dao.impl.KEmplRepository;
import com.sprintpay.ic.test.rh.KEmpl;
import com.sprintpay.ic.test.rh.execption.KerenException;
import com.sprintpay.ic.test.service.KEmplService;

/**
 * @author SPRINT-PAY-NTW
 *
 */

@Service
@Transactional
public class KEmplServiceImpl implements KEmplService {
	
	
	private KEmplRepository kemplRepository;
	
	public KEmplServiceImpl(KEmplRepository kemplRepository) {
        this.kemplRepository = kemplRepository;
    }


	@Override
	public KEmpl getEmployeeByName(String name) {
		return kemplRepository.findByLastName(name);
	}

	@Override
	public List<KEmpl> getAllEmployes() {
		return kemplRepository.findAll();
	}

	@Override
	public KEmpl create(@Valid KEmpl entity) {
		kemplRepository.save(entity).getId();
		return entity;
	}

	@Override
	public KEmpl findById(long id) {
		return kemplRepository.findById(id).orElseThrow(() -> new KerenException("Employee not found for given id", "id", id));

	}

	@Transactional
	public void deleteById(@NotNull Long id) {
		KEmpl employeeEntity = kemplRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Employee not found for given id"));

		kemplRepository.delete(employeeEntity);
	}

	@Override
	public KEmpl update(KEmpl entity) {
		kemplRepository.save(entity);
		return entity;
	}

	@Override
	public List<KEmpl> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
