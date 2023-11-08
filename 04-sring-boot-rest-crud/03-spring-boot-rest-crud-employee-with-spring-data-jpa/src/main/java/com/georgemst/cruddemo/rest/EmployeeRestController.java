package com.georgemst.cruddemo.rest;

import com.georgemst.cruddemo.entity.Employee;
import com.georgemst.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    // controller -> service -> DAO
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // create /"employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // create "employees/{employeeId}" and return a single employee
    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> findById(@PathVariable int employeeId){

        Optional<Employee> theEmployee = employeeService.findById(employeeId);

        if (theEmployee.isEmpty()) {
            throw new RuntimeException("Employee Not Found");
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // also just in case they pass an id in JSON ... set id in 0
        //this is to force a save of a new item ... instead of update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // Add mapping for PUT "/employees" - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
       Employee dbEmployee =  employeeService.save(theEmployee);
       return dbEmployee; // dbEmployee has the latest updates from DB
    }

    // Add mapping for DELETE "employees/{employeeId}"
    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

//        Optional<Employee> theEmployee = employeeService.findById(employeeId);

//        if (theEmployee.isEmpty()) {
//            throw new RuntimeException("Employee Not Found");
//        }
        employeeService.deleteById(employeeId);
        return "Employee with id " + employeeId + " deleted";
    }
}
