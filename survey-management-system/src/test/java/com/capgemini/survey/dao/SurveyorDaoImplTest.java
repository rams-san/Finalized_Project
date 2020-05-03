package com.capgemini.survey.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.capgemini.survey.beans.SurveyorInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.factory.Factory;

class SurveyorDaoImplTest {
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	Scanner sc = new Scanner(System.in);

	@Test
	@DisplayName("Test loginSurveyor")
	void testLoginSurveyor() {
		logger.info("\n-----Testing loginSurveyor for correct user-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		SurveyorInfoBean surveyorInfoBean = new SurveyorInfoBean();
		assertEquals(true, surveyorDao.loginSurveyor(surveyorInfoBean));
	}

	@Test
	@DisplayName("Test loginSurveyor1")
	void testLoginSurveyor1() {
		logger.info("\n-----Testing loginSurveyor1 for wrong user-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		SurveyorInfoBean surveyorInfoBean = new SurveyorInfoBean();
		assertEquals(false, surveyorDao.loginSurveyor(surveyorInfoBean));
	}

	@Test
	@DisplayName("Test addSurveyor")
	void testAddSurveyor() {
		logger.info("\n-----Testing addSurveyor-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		SurveyorInfoBean surveyorInfoBean = new SurveyorInfoBean();
		assertEquals(true, surveyorDao.addSurveyor(surveyorInfoBean));
	}

	@Test
	@DisplayName("Test addSurveyor1")
	void testAddSurveyor1() {
		logger.info("\n-----Testing addSurveyor1-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		SurveyorInfoBean surveyorInfoBean = new SurveyorInfoBean();
		assertEquals(true, surveyorDao.addSurveyor(surveyorInfoBean));
	}

	@Test
	@DisplayName("Test updateSurveyor")
	void testUpdateSurveyor() {
		logger.info("\n-----Testing updateSurveyor-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		SurveyorInfoBean surveyorInfoBean = new SurveyorInfoBean();
		assertEquals(true, surveyorDao.updateSurveyor(surveyorInfoBean));
	}

	@Test
	@DisplayName("Test updateSurveyor1")
	void testUpdateSurveyor1() {
		logger.info("\n-----Testing updateSurveyor1-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		SurveyorInfoBean surveyorInfoBean = new SurveyorInfoBean();
		assertEquals(true, surveyorDao.updateSurveyor(surveyorInfoBean));
	}

	@Test
	@DisplayName("Test deleteSurveyor")
	void testDeleteSurveyor() {
		logger.info("\n-----Testing deleteSurveyor-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		logger.info("\nEnter surveyor id to delete :");
		int id = sc.nextInt();
		assertEquals(true, surveyorDao.deleteSurveyor(id));
	}

	@Test
	@DisplayName("Test deleteSurveyor1")
	void testDeleteSurveyor1() {
		logger.info("\n-----Testing deleteSurveyor1-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		logger.info("\nEnter surveyor id to delete :");
		int id = sc.nextInt();
		assertEquals(true, surveyorDao.deleteSurveyor(id));
	}

	@Test
	@DisplayName("Test getSurveyor")
	void testGetSurveyor() {
		logger.info("\n-----Testing getSurveyor-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		logger.info("\nEnter surveyor id to get details :");
		int id = sc.nextInt();
		assertNull(null, surveyorDao.getSurveyor(id));
	}

	@Test
	@DisplayName("Test getSurveyor1")
	void testGetSurveyor1() {
		logger.info("\n-----Testing getSurveyor1-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		logger.info("\nEnter surveyor id to get details :");
		int id = sc.nextInt();
		assertNull(null, surveyorDao.getSurveyor(id));
	}

	@Test
	@DisplayName("Test getAllSurveyor")
	void testGetAllSurveyor() {
		logger.info("\n-----Testing getAllSurveyor-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertNotNull(null, surveyorDao.getAllSurveyors());
	}

	@Test
	@DisplayName("Test getAllSurveyor1")
	void testGetAllSurveyor1() {
		logger.info("\n-----Testing getAllSurveyor1-----\n");
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		assertNotNull(null, surveyorDao.getAllSurveyors());
	}
}
