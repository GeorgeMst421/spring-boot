package com.georgemst.cruddemo.dao;

import com.georgemst.cruddemo.entity.Instructor;
import com.georgemst.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
