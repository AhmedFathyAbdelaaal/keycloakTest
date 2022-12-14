package com.example.keycloaktwo.service;

import com.example.keycloaktwo.entity.Employee;
import com.example.keycloaktwo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// Our Service Class
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Our PostConstruct to initialize our employee table
    @PostConstruct
    public void initializeEmployeeTable(){
        //save everything in through the repository
        employeeRepository.saveAll(
                Stream.of(
                        new Employee("john",20000),
                        new Employee("mark",55000),
                        new Employee("peter",120000)
                ).collect(Collectors.toList())
        );
    }

    // Function for getting 1 employee through their id from the repository
    public Employee getEmployee(int employeeId){
        return employeeRepository
                .findById(employeeId)
                .orElse(null);
    }

    //Function to get all the employees through the repository
    public List<Employee> getAllEmployees(){
        return employeeRepository
                .findAll();
    }
}
