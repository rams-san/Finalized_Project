package com.capgemini.survey.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.capgemini.survey.beans.RespondentInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.factory.Factory;

class RespondentDaoImplTest {
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	Scanner sc = new Scanner(System.in);

	@Test
	@DisplayName("Test loginRespondent")
	void testLoginRespondent() {
		logger.info("\n-----Testing loginRespondent for correct user-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		RespondentInfoBean respondentInfoBean = new RespondentInfoBean();
		assertEquals(true, respondentDao.loginRespondent(respondentInfoBean));
	}

	@Test
	@DisplayName("Test loginRespondent1")
	void testLoginRespondent1() {
		logger.info("\n-----Testing loginRespondent1 for wrong user-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		RespondentInfoBean respondentInfoBean = new RespondentInfoBean();
		assertEquals(false, respondentDao.loginRespondent(respondentInfoBean));
	}

	@Test
	@DisplayName("Test addRespondent")
	void testAddRespondent() {
		logger.info("\n-----Testing addRespondent-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		RespondentInfoBean respondentInfoBean = new RespondentInfoBean();
		assertEquals(true, respondentDao.addRespondent(respondentInfoBean));
	}

	@Test
	@DisplayName("Test addRespondent1")
	void testAddRespondent1() {
		logger.info("\n-----Testing addRespondent1-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		RespondentInfoBean respondentInfoBean = new RespondentInfoBean();
		assertEquals(true, respondentDao.addRespondent(respondentInfoBean));
	}

	@Test
	@DisplayName("Test updateRespondent")
	void testUpdateRespondent() {
		logger.info("\n-----Testing updateRespondent-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		RespondentInfoBean respondentInfoBean = new RespondentInfoBean();
		assertEquals(true, respondentDao.updateRespondent(respondentInfoBean));
	}

	@Test
	@DisplayName("Test updateRespondent1")
	void testUpdateRespondent1() {
		logger.info("\n-----Testing updateRespondent1-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		RespondentInfoBean respondentInfoBean = new RespondentInfoBean();
		assertEquals(true, respondentDao.updateRespondent(respondentInfoBean));
	}

	@Test
	@DisplayName("Test deleteRespondent")
	void testDeleteRespondent() {
		logger.info("\n-----Testing deleteRespondent-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		logger.info("\nEnter respondent id to delete :");
		int id = sc.nextInt();
		assertEquals(true, respondentDao.deleteRespondent(id));
	}
	
	@Test
	@DisplayName("Test deleteRespondent1")
	void testDeleteRespondent1() {
		logger.info("\n-----Testing deleteRespondent1-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		logger.info("\nEnter respondent id to delete :");
		int id = sc.nextInt();
		assertEquals(true, respondentDao.deleteRespondent(id));
	}
	
	@Test
	@DisplayName("Test getRespondent")
	void testGetRespondent() {
		logger.info("\n-----Testing getRespondent-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		logger.info("\nEnter respondent id to get details :");
		int id = sc.nextInt();
		assertNull(null, respondentDao.getRespondent(id));
	}
	
	@Test
	@DisplayName("Test getRespondent1")
	void testGetRespondent1() {
		logger.info("\n-----Testing getRespondent1-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		logger.info("\nEnter respondent id to get details :");
		int id = sc.nextInt();
		assertNull(null, respondentDao.getRespondent(id));
	}
	
	@Test
	@DisplayName("Test getAllRespondent")
	void testGetAllRespondent() {
		logger.info("\n-----Testing getAllRespondent-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertNotNull(null, respondentDao.getAllRespondents());
	}
	
	@Test
	@DisplayName("Test getAllRespondent1")
	void testGetAllRespondent1() {
		logger.info("\n-----Testing getAllRespondent1-----\n");
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		assertNotNull(null, respondentDao.getAllRespondents());
	}
}
