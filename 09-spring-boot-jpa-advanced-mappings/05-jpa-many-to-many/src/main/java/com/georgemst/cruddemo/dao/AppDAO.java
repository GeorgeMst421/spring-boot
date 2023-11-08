package com.georgemst.cruddemo.dao;

import com.georgemst.cruddemo.entity.Course;
import com.georgemst.cruddemo.entity.Instructor;
import com.georgemst.cruddemo.entity.InstructorDetail;
import com.georgemst.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    // section 4 jpa one to many - uni

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int id);


    // section 5 many to many

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void updateStudent(Student student);

    void deleteStudentById(int id);

}






