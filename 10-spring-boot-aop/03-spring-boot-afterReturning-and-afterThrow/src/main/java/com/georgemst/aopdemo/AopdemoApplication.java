package com.georgemst.aopdemo;

import com.georgemst.aopdemo.dao.AccountDao;
import com.georgemst.aopdemo.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao){
		return runner->{
//			demoTheBeforeAdvice(accountDao,membershipDao);

//			demoTheAfterReturningAdvice(accountDao);

			demoTheAfterThrowingAdvice(accountDao);

		};
	}

	private void demoTheAfterThrowingAdvice(AccountDao accountDao) {

		// call method to find the accounts
		List<Account> accounts = null;
		try{
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			accounts = accountDao.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("\n\nMain Program: caught exception: " + e);

		}

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("---");

		System.out.println(accounts);

		System.out.println("\n");

	}

	private void demoTheAfterReturningAdvice(AccountDao accountDao) {

		// call method to find the accounts
		List<Account> accounts = accountDao.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("---");

		System.out.println(accounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDao accountDao,MembershipDao membershipDao) {
		Account account = new Account();
		account.setName("Madu");
		account.setLevel("Platinum");
		accountDao.addAccount(account,true);
		System.out.println();

		accountDao.doWork();
		System.out.println();

		accountDao.setName("foodbar");
		System.out.println();

		accountDao.setServiceCode("silver");
		System.out.println();

		String name = accountDao.getName();
		System.out.println();

		String silvercode = accountDao.getServiceCode();
		System.out.println();

	}


}
