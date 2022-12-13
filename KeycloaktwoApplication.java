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

@SpringBootApplication
@RestController
@RequestMapping("/employees")
public class KeycloaktwoApplication {

	@Autowired
	private EmployeeService service;

	@GetMapping("/{employeeId}")
	@RolesAllowed("user")
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId){
		return ResponseEntity.ok(service.getEmployee(employeeId));
	}

	@GetMapping
	@RolesAllowed("admin")
	public ResponseEntity<List<Employee>> findAllEmployees(){
		return ResponseEntity.ok(service.getAllEmployees());
	}

	public static void main(String[] args) {
		SpringApplication.run(KeycloaktwoApplication.class, args);
	}

}
