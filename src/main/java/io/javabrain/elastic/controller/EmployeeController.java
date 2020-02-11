package io.javabrains.eleastic.controller;

import com.github.javafaker.Faker;
import io.javabrain.elastic.model.Departament;
import io.javabrain.elastic.model.Employee;
import io.javabrain.elastic.model.Organization;
import io.javabrain.elastic.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private  EmployeeRepo repository;

	@PostMapping
	public Employee add(@RequestBody Employee employee){

		System.out.println(employee);

	return repository.save(employee);
	}

	@GetMapping("/{name}")
	public List<Employee> findByName(@PathVariable("name") String name) {
		return repository.findByName(name);
	}

	@GetMapping("/organization/{organizationName}")
	public List<Employee> findByOrganizationName(@PathVariable("organizationName") String organizationName) {
		return repository.findByOrganizationName(organizationName);
	}
	@GetMapping("/getAll")
	public List<Employee> findAll()
	{
		return StreamSupport.stream(repository.findAll().spliterator(),false).collect(Collectors.toList());
	}

}