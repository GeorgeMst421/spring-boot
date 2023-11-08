package com.georgemst.cruddemo;

import com.georgemst.cruddemo.dao.AppDAO;
import com.georgemst.cruddemo.entity.Instructor;
import com.georgemst.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			createInstructor(appDAO);
//			findInstructor(appDAO);
//			removeInstructor(appDAO);
		};
	}

	private void removeInstructor(AppDAO appDAO) {
		int id=1;
		appDAO.deleteInstructorById(id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding Instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor );
		System.out.println("Associate instructorDetail only: " +instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor(
				"george", "mst", "geomst@lov2code.com"
		);

		InstructorDetail instructorDetail = new InstructorDetail(
			"http://youtube.com/geomst","guitar"
		);

		instructor.setInstructorDetail(instructorDetail); // ASSOSIATE THE OBJECT
		System.out.println("saving instructor " + instructor);
		appDAO.save(instructor);
		System.out.println("Done");
	}

}
