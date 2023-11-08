package com.georgemst.cruddemo.service;

import com.georgemst.cruddemo.dao.EmployeeRepository;
import com.georgemst.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeDAO){
        this.employeeRepository = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        // This is his code probably of an older java version
        Optional<Employee> result =  employeeRepository.findById(id);
        Employee employee;
        if(result.isPresent()){
            employee = result.get();
        }
        else{
            // we didn't find the employee
            throw new RuntimeException("I did not found the employee malaka");
        }
        return Optional.of(employee);
//        return employeeRepository.findById(id);
    }

    @Override // No need for transactional since jpa repository provides that
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override // No need for transactional since jpa repository provides that
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}






