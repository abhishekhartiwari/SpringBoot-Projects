package com.abhishek.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.abhishek.journalApp.repository.UserRepository;

public class UserServiceTests {

	@Autowired
	UserRepository userRepo;

	@Disabled
	@Test
	public void testFindByUserName() {
		System.out.println("Running testAdd...");
		assertNotNull(userRepo.findByUserName("Rdam"));
	}

	@ParameterizedTest
	@CsvSource({ "1,1,3", "2,2,4", "2,5,7" })
	public void testParameter(int a, int b, int expected) {

		System.out.println("Parameter test");
		assertEquals(expected, a + b);
	}
}
