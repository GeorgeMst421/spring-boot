package com.georgemst.cruddemo.dao;

import com.georgemst.cruddemo.entity.Course;
import com.georgemst.cruddemo.entity.Instructor;
import com.georgemst.cruddemo.entity.InstructorDetail;
import com.georgemst.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDAO{

    EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager em){
        entityManager=em;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id){
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);

        // you have to remove the constraints from the courses else you cant remove an instructor
        for(Course course : instructor.getCourses()){
            course.setInstructor(null);
        }

        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id){
        TypedQuery<Course> query = entityManager.createQuery(" FROM Course where instructor.id = :data", Course.class) ;
        query.setParameter("data",id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(  "select i from Instructor i "
                                                                    +"JOIN FETCH i.courses "
                                                                    +"JOIN FETCH i.instructorDetail "
                                                                    +"where i.id = :data", Instructor.class);

        query.setParameter("data",id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id){
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                +"JOIN FETCH c.reviews "
                +"WHERE c.id = :data", Course.class);
        query.setParameter("data",id);

        // execute the query
        return query.getSingleResult();
    }


    // SECTION 5 MANY TO MANY


    @Override
    public Course findCourseAndStudentsByCourseId(int id) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "SELECT c FROM Course c "
                +"JOIN FETCH c.students "
                +"WHERE c.id = :data", Course.class);

        query.setParameter("data", id);

        // get resulst
        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT s FROM Student s "
                        +"JOIN FETCH s.courses "
                        +"WHERE s.id = :data", Student.class);

        query.setParameter("data", id);

        // get resulst
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = entityManager.find(Student.class,id);

        entityManager.remove(student);
    }
}
