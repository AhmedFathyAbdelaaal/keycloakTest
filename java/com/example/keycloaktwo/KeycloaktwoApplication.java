package com.example.keycloaktwo;

import com.example.keycloaktwo.entity.Employee;
import com.example.keycloaktwo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

//Our sprint boot application which is also our controller
@SpringBootApplication
@RestController
// the mapping tied to it
@RequestMapping("/employees")
public class KeycloaktwoApplication {

	//Auto wiring the service
	@Autowired
	private EmployeeService service;

	// setting our GET mapping and specifying the roles allowed to access it through that mapping
	@GetMapping("/{employeeId}")
	@RolesAllowed("user")
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId){
		// this function finds and displays one employees' data
		return ResponseEntity.ok(service.getEmployee(employeeId));
	}

	// setting our GET mapping and specifying the role allowed to use it.
	@GetMapping
	@RolesAllowed("admin")
	// this function finds and displays all  the employees data
	public ResponseEntity<List<Employee>> findAllEmployees(){
		return ResponseEntity.ok(service.getAllEmployees());
	}

	public static void main(String[] args) {
		SpringApplication.run(KeycloaktwoApplication.class, args);
	}

}
