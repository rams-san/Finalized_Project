package com.capgemini.survey.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.survey.beans.SurveyInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.factory.Factory;

class SurveyDaoImplTest {
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	Scanner sc = new Scanner(System.in);
	
	@Test
	@DisplayName("Test addSurvey")
	void testAddSurvey() {
		logger.info("\n-----Testing addSurvey-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		SurveyInfoBean surveyInfoBean = new SurveyInfoBean();
		assertEquals(true, surveyDao.addSurvey(surveyInfoBean));
	}

	@Test
	@DisplayName("Test addSurvey1")
	void testAddSurvey1() {
		logger.info("\n-----Testing addSurvey1-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		SurveyInfoBean surveyInfoBean = new SurveyInfoBean();
		assertEquals(true, surveyDao.addSurvey(surveyInfoBean));
	}

	@Test
	@DisplayName("Test updateSurvey")
	void testUpdateSurvey() {
		logger.info("\n-----Testing updateSurvey-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		SurveyInfoBean surveyInfoBean = new SurveyInfoBean();
		assertEquals(true, surveyDao.updateSurvey(surveyInfoBean));
	}

	@Test
	@DisplayName("Test updateSurvey1")
	void testUpdateSurvey1() {
		logger.info("\n-----Testing updateSurvey1-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		SurveyInfoBean surveyInfoBean = new SurveyInfoBean();
		assertEquals(true, surveyDao.updateSurvey(surveyInfoBean));
	}

	@Test
	@DisplayName("Test deleteSurvey")
	void testDeleteSurvey() {
		logger.info("\n-----Testing deleteSurvey-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		logger.info("\nEnter survey title to delete :");
		String title = sc.nextLine();
		assertEquals(true, surveyDao.deleteSurvey(title));
	}

	@Test
	@DisplayName("Test deleteSurvey1")
	void testDeleteSurvey1() {
		logger.info("\n-----Testing deleteSurvey1-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		logger.info("\nEnter survey title to delete :");
		String title = sc.nextLine();
		assertEquals(true, surveyDao.deleteSurvey(title));
	}

	@Test
	@DisplayName("Test getSurvey")
	void testGetSurvey() {
		logger.info("\n-----Testing getSurvey-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		logger.info("\nEnter survey title to get details :");
		String title = sc.nextLine();
		assertNull(null, surveyDao.getSurvey(title));
	}

	@Test
	@DisplayName("Test getSurvey1")
	void testGetSurvey1() {
		logger.info("\n-----Testing getSurvey1-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		logger.info("\nEnter survey title to get details :");
		String title = sc.nextLine();
		assertNull(null, surveyDao.getSurvey(title));
	}

	@Test
	@DisplayName("Test getAllSurvey")
	void testGetAllSurvey() {
		logger.info("\n-----Testing getAllSurvey-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		assertNotNull(null, surveyDao.getAllSurveys());
	}

	@Test
	@DisplayName("Test getAllSurvey1")
	void testGetAllSurvey1() {
		logger.info("\n-----Testing getAllSurvey1-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		assertNotNull(null, surveyDao.getAllSurveys());
	}
	
	@Test
	@DisplayName("Test getListOfTitle")
	void testGetListOfTitle() {
		logger.info("\n-----Testing getListOfTitle-----\n");
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		assertNotNull(null, surveyDao.getListOfTitle());
	}
	
	@Test
	@DisplayName("Test getSurveyQuestions")
	void testGetSurveyQuestions() {
		logger.info("\n-----Testing getSurveyQuestions for wrong entry-----\n");
		logger.info("Enter the survey title from below list :");
		logger.info("1. Amazon Prime");
		logger.info("2. Flipkart");
		logger.info("3. Facebook");
		String title = sc.nextLine();
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		assertNotNull(null, surveyDao.getSurveyQuestions(title));
	}
}
