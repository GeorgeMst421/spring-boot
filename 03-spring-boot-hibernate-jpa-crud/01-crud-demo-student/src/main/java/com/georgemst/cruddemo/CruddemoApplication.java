package com.georgemst.cruddemo;

import com.georgemst.cruddemo.dao.StudentDAO;
import com.georgemst.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating the new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@lov2code.com");

		// save the student object
		System.out.println("Saving the new student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("John", "Doe", "john@lov2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@lov2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum,", "bonita@lov2code.com");

		//save the students
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void readStudent(StudentDAO studentDAO){

		// create a student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//display id of the student
		int theId = tempStudent.getId();
		System.out.println("Saved Student. The Id: " + theId);

		// retrieve student based on the id
		System.out.println("Retrieving the student with the given id");
		Student myStudent = studentDAO.findById(theId);

		// display the student
		System.out.println("Found the student : " + myStudent.toString());
	}

	public void queryForStudents(StudentDAO studentDAO){

		// get a list of students
		List<Student> students = studentDAO.findAll();
		// display the list of students
		for(Student tempStudent: students){
			System.out.println(tempStudent.toString());
		}
	}

	public void queryForStudentsByLastName(StudentDAO studentDAO){

		// get a list of students
		List<Student> students = studentDAO.findByLastName("Duck");
		// display that list of students
		for(Student tempStudent: students){
			System.out.println(tempStudent.toString());
		}
	}

	public void updateStudent(StudentDAO studentDAO){

		// retrieve student based on the id
		int id = 1;
		System.out.println("Getting student by id...");
		Student student = studentDAO.findById(id);

		// change first name to "Scooby"
		System.out.println("Updating the student...");
		student.setFirstName("John");

		// update the student
		studentDAO.update(student);

		// Display the updated student
		System.out.println("Updated student: "+student);
	}

	public void deleteStudent(StudentDAO studentDAO){
		int id = 3;
		System.out.println("Deleteing student with id: " + id);
		studentDAO.delete(id);
		System.out.println("Student deleted");
	}

	public void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting all students...");
		int rows = studentDAO.deleteAll();
		System.out.println("Students deleted: " + rows);
	}

}






