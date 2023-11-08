package com.georgemst.cruddemo.dao;

import com.georgemst.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entity
    EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee ", Employee.class);

        //execute the query
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee theEmployee = entityManager.find(Employee.class,id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save the employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return the employee with the updated ID SOS // if id == 0 then insert/save else update
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        // find the employee
        Employee theEmployee = entityManager.find(Employee.class,id);
        entityManager.remove(theEmployee);
    }


}
