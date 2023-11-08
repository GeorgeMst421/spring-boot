package com.georgemst.cruddemo;

import com.georgemst.cruddemo.dao.AppDAO;
import com.georgemst.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {

//			createCourseAndStudents(appDAO);

//			findCourseAndStudents(appDAO);

//			findStudentAndCourses(appDAO);

//			addMoreCoursesForStudent(appDAO);

//			deleteCourse(appDAO);

			deleteStudent(appDAO);
		};

	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting Student with id " + id);
		appDAO.deleteStudentById(id);
		System.out.println("Done");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int id=2;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		Course c1 = new Course("Rubik's cube speed cube lessons");
		Course c2 = new Course("Atari game development");

		student.addCourse(c1);
		student.addCourse(c2);

		System.out.println("Updating student: "+student);
		System.out.println("assosiated courses: " + student.getCourses());
		appDAO.updateStudent(student);
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id = 2;
		Student s = appDAO.findStudentAndCoursesByStudentId(id);
		System.out.println("Students: " + s);
		System.out.println("Courses: " + s.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 10;
		Course c = appDAO.findCourseAndStudentsByCourseId(id);
		System.out.println("Course: " + c);
		System.out.println("Students: " + c.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course course = new Course("PacMan - how to score a million points");

		// create the students
		Student student1 = new Student("John","Doe","john@luv2code.com");
		Student student2 = new Student("Mary","Public","mary@luv2code.com");

		// add the students to the course
		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println("Saving the course: " + course);
		System.out.println("Assosiacet students: " + course.getStudents());

		// save the course and the associated students
		appDAO.save(course); // the save will cascade the students also with the course
	}


	//	~~~~~~~~~~~~ above here is the 05 many to many functions ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 11;
		System.out.println("deleting course with id " + id);
		appDAO.deleteCourseById(11);

	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int id = 11;
		Course course = appDAO.findCourseAndReviewsByCourseId(id);
		System.out.println("Course:" + course);

		System.out.println("Reviews:" + course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course course = new Course("Pacman  - how to score a million points");

		course.addReview(new Review("Great course...loved it"));
		course.addReview(new Review("Cool curse well done"));
		course.addReview(new Review("Bad course ... it sucks"));
		System.out.println("saving the course: " + course);
		System.out.println("Reviews: " + course.getReviews());
		appDAO.save(course);
	}

	//~~~~~~~~~~~~~~~~~~~~~~~  above here is the 04 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void deleteCourse(AppDAO appDAO) {
		int id = 11;
		System.out.println("Deleting course with id: " + id);
		appDAO.deleteCourseById(id);
		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 11;

		System.out.println("Finding the course id: " + id);
		Course course = appDAO.findCourseById(id);

		System.out.println("Updating the course: " + course);
		course.setInstructor(appDAO.findInstructorById(2));

		appDAO.update(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 2;

		System.out.println("Finding the instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Updating the instructor: " + instructor);

		//updates
		List<Course> courses = new ArrayList<>();
		Course course11 = appDAO.findCourseById(11);
		courses.add(course11);
		instructor.setCourses(courses);

		appDAO.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int id = 2;
		System.out.println("Finding the instructor id: " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("tempInstructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding the instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("tempInstructor: " + instructor);

		System.out.println("Finding the courses...");
		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		System.out.println("Courses found "+ courses);

		System.out.println("Setting the courses to the instructor");
		instructor.setCourses(courses);
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding the instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("tempInstructor: " + instructor);

		// this works only when fetch = eager
		System.out.println("the assoiacted courses: "+ instructor.getCourses());
		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor instructor = new Instructor(
				"susan", "Public", "Susan@lov2code.com");

		// create the instructor detail
		InstructorDetail instructorDetail = new InstructorDetail(
				"http://youtube.com/susanPublic","video games");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// create some courses
		Course c1 = new Course("Air Guitar - the Ultimate Guide");
		Course c2 = new Course("The paintBall masterclass");

		// add the courses to the instructor
		instructor.add(c1);
		instructor.add(c2);

		// Save the instructor
		// This will ALSO save the courses because of the CascadeType.PERSIST
		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: "+c1 +" "+ c2);
		appDAO.save(instructor);


	}

	private void removeInstructorDetail(AppDAO appDAO) {
		int id = 3;
		appDAO.deleteInstructorDetailById(id);

	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("InstructorDetail: "+instructorDetail);
		System.out.println("Instructor: "+instructorDetail.getInstructor());

	}

	private void deleteInstructor(AppDAO appDAO) {
		int id=1;
		System.out.println("DEleting instructor with id: " + id);
		appDAO.deleteInstructorById(id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding Instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor );
//		System.out.println("Associate instructorDetail only: " +instructor.getInstructorDetail());

		System.out.println("Courses: " + instructor.getCourses());

		for(Course course : instructor.getCourses()){
			System.out.println(course);
		}
		if(instructor.getCourses().isEmpty()) System.out.println("YES IT IS NULL");
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor instructor = new Instructor(
				"ioli", "kok", "kok@lov2code.com"
		);

		// create the instructor detail
		InstructorDetail instructorDetail = new InstructorDetail(
			"http://youtube.com/iolikok","art"
		);

		// associate the objects
		instructor.setInstructorDetail(instructorDetail); // ASSOSIATE THE OBJECT
		System.out.println("saving instructor " + instructor);
		appDAO.save(instructor);
		System.out.println("Done");
	}

}
