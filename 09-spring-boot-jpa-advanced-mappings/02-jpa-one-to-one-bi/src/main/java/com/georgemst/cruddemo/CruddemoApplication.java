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

//			createInstructor(appDAO);

//			findInstructor(appDAO);

			removeInstructor(appDAO);

//			findInstructorDetail(appDAO);

//			removeInstructorDetail(appDAO);
		};
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

	private void removeInstructor(AppDAO appDAO) {
		int id=3;
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
				"ioli", "kok", "kok@lov2code.com"
		);

		InstructorDetail instructorDetail = new InstructorDetail(
			"http://youtube.com/iolikok","art"
		);

		instructor.setInstructorDetail(instructorDetail); // ASSOSIATE THE OBJECT
		System.out.println("saving instructor " + instructor);
		appDAO.save(instructor);
		System.out.println("Done");
	}

}
