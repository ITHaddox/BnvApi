package com.codecreature.BnvApi;

import com.codecreature.BnvApi.repository.BabyNameJpaRepository;
import com.codecreature.BnvApi.repository.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BnvApiApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserJpaRepository userJpaRepository;

	@Autowired
	BabyNameJpaRepository babyNameJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(BnvApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		logger.info("/nBabyName Object: {}", babyNameJpaRepository.findByUsername("tyler"));
//		logger.info("\nUser id 10001 -> {}", userJpaRepository.findById(10001));
//		logger.info("\nInsert 10004 -> {}", userJpaRepository.update(new BnvUser(10004, "Richard", "emails", "password")));
//		logger.info("\nUpdate 10003 -> {}", userJpaRepository.update(new BnvUser(10003, "Betty", "emails.com", "pass")));
//		userJpaRepository.deleteById(10002);
//
//		logger.info("\nAll users -> {}", userJpaRepository.findAll());
//
//		logger.info("\nLogged in -> {}", userJpaRepository.loginUser("Ranga"));

//		logger.info("Finding -> {}", repository.findById(10001));

	}
}
