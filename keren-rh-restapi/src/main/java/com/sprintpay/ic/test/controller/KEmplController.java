package com.sprintpay.ic.test.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sprintpay.ic.test.rh.KEmpl;
import com.sprintpay.ic.test.service.KEmplService;

/**
 * @author SPRINT-PAY-NTW
 *
 */

@RestController
@RequestMapping("/api/employees")
public class KEmplController {

	// @Autowired
	private KEmplService employeeService;

	@Autowired
	// @Qualifier("clientService")
	public void employeeService(KEmplService employeeService) {
		this.employeeService = employeeService;
	}

	// Get All employees
	@GetMapping("/employees/all")
	public List<KEmpl> getAllEmployes() {
		return employeeService.getAllEmployes();
	}

	// Create a new employes
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity createEmployes(@Valid @RequestBody KEmpl employe, UriComponentsBuilder uriComponentsBuilder) {

		KEmpl entity = employeeService.create(employe);

		final URI uri = uriComponentsBuilder.path("/api/employees/{id}").build(entity.getId());

		return ResponseEntity.created(uri).build();
	}

	// get employee by id
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<KEmpl> getById(@PathVariable("id") Long id) {
		KEmpl employee = employeeService.findById(id);

		return ResponseEntity.ok(employee);
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity update(@RequestBody KEmpl employee) {
		employeeService.update(employee);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<KEmpl> deleteById(@PathVariable("id") Long id) {
		employeeService.deleteById(id);

		return ResponseEntity.ok().build();
	}

}
