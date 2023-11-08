package com.georgemst.aopdemo;

import com.georgemst.aopdemo.dao.AccountDao;
import com.georgemst.aopdemo.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao){
		return runner->{
			demoTheBeforeAdvice(accountDao,membershipDao);
		};
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
