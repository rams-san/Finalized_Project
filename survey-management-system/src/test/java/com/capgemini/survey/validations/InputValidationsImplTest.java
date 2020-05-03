package com.capgemini.survey.validations;

import static org.junit.Assert.assertEquals;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.capgemini.survey.controller.SurveyController;

class InputValidationsImplTest {
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	Scanner sc = new Scanner(System.in);

	@Test
	@DisplayName("Test Name")
	void testName() {
		logger.info("\n-----Testing name validation-----\n");
		InputValidations inputValidation = new InputValidationsImpl();
		logger.info("Enter name : ");
		String userName = sc.nextLine();
		assertEquals(true, inputValidation.nameValidation(userName));
	}

	@Test
	@DisplayName("Test Username")
	void testUsername() {
		logger.info("\n-----Testing userName validation-----\n");
		InputValidations inputValidation = new InputValidationsImpl();
		logger.info("Enter user name : ");
		String userName = sc.next();
		assertEquals(true, inputValidation.userNameValidation(userName));
	}
	
	@Test
	@DisplayName("Test Password")
	void testPassword() {
		logger.info("\n-----Testing password validation-----\n");
		InputValidations inputValidation = new InputValidationsImpl();
		logger.info("Enter password : ");
		String userName = sc.next();
		assertEquals(true, inputValidation.passwordValidation(userName));
	}
	
	@Test
	@DisplayName("Test Email")
	void testEmail() {
		logger.info("\n-----Testing Email validation-----\n");
		InputValidations inputValidation = new InputValidationsImpl();
		logger.info("Enter email : ");
		String email = sc.next();
		assertEquals(true, inputValidation.emailValidation(email));
	}
	
	@Test
	@DisplayName("Test Date")
	void testDate() {
		logger.info("\n-----Testing Date validation-----\n");
		InputValidations inputValidation = new InputValidationsImpl();
		logger.info("Enter date : ");
		String date = sc.next();
		assertEquals(true, inputValidation.localDateValidation(date));
	}
	
	@Test
	@DisplayName("Test ID")
	void testId() {
		logger.info("\n-----Testing ID validation-----\n");
		InputValidations inputValidation = new InputValidationsImpl();
		logger.info("Enter id : ");
		String id = sc.next();
		assertEquals(true, inputValidation.idValidation(id));
	}
	
	@Test
	@DisplayName("Test Title")
	void testTitle() {
		logger.info("\n-----Testing Title validation-----\n");
		InputValidations inputValidation = new InputValidationsImpl();
		logger.info("Enter title : ");
		String title = sc.nextLine();
		assertEquals(true, inputValidation.titleValidation(title));
	}
	
	@Test
	@DisplayName("Test Description")
	void testDescription() {
		logger.info("\n-----Testing Description validation-----\n");
		InputValidations inputValidation = new InputValidationsImpl();
		logger.info("Enter description : ");
		String description = sc.nextLine();
		assertEquals(true, inputValidation.descriptionValidation(description));
	}
	
	@Test
	@DisplayName("Test Question")
	void testQuestion() {
		logger.info("\n-----Testing Question validation-----\n");
		InputValidations inputValidation = new InputValidationsImpl();
		logger.info("Enter question : ");
		String question = sc.nextLine();
		assertEquals(true, inputValidation.questionValidation(question));
	}
	
	@Test
	@DisplayName("Test Answer")
	void testAnswer() {
		logger.info("\n-----Testing Answer validation-----\n");
		InputValidations inputValidation = new InputValidationsImpl();
		logger.info("Enter answer : ");
		String answer = sc.nextLine();
		assertEquals(true, inputValidation.titleValidation(answer));
	}
	
	@Test
	@DisplayName("Test Choice4")
	void testChoice4() {
		logger.info("\n-----Testing Choice4 validation-----\n");
		InputValidations inputValidation = new InputValidationsImpl();
		logger.info("Enter choice4 : ");
		String choice4 = sc.nextLine();
		assertEquals(true, inputValidation.choice4Validate(choice4));
	}
}
