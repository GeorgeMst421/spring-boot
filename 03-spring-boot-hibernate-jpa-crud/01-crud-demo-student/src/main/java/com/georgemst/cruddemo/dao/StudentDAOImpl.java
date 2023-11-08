package com.georgemst.cruddemo.dao;

import com.georgemst.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // define entity manager using constructor injection
    // Autowired for constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional // SOS beware to choose transactional from spring framework
    public void save(Student student){
        entityManager.persist(student); // persists() saves the object to the database
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        //create the query. theData is a placeholder that will be filled later
        TypedQuery<Student> theQuery = entityManager.createQuery(
                                        "FROM Student where lastName=:theData",Student.class);

        // set the query parameter. Here we set the value of theData to theLastName input value
        theQuery.setParameter("theData",theLastName);

        // return the results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent){
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id){

        // retrieve the student
        Student student = entityManager.find(Student.class, id);
        // delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll(){
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student ").executeUpdate();
        return numRowsDeleted;
    }

}









