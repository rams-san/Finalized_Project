package com.capgemini.survey.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import com.capgemini.survey.beans.RespondInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.factory.Factory;

	@TestMethodOrder(Alphanumeric.class)
class RespondDaoImplTest {
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);

	@Test
	@DisplayName("Test AaddRespondId")
	void testAaddRespondId() {
		logger.info("\n-----Testing addRespondId-----\n");
		RespondDao respondDao = Factory.getRespondDaoInstance();
		RespondInfoBean respondInfoBean = new RespondInfoBean();
		assertEquals(true, respondDao.addRespondId(respondInfoBean));
	}

	@Test
	@DisplayName("Test BaddRespondTitle")
	void testBaddRespondTitle() {
		logger.info("\n-----Testing addRespondTitle-----\n");
		RespondDao respondDao = Factory.getRespondDaoInstance();
		RespondInfoBean respondInfoBean = new RespondInfoBean();
		assertEquals(true, respondDao.addRespondTitle(respondInfoBean));
	}

	@Test
	@DisplayName("Test CgetListOfRespondTitle ")
	void testCgetListOfRespondTitle() {
		logger.info("\n-----Testing getListOfRespondTitle-----\n");
		RespondDao respondDao = Factory.getRespondDaoInstance();
		assertEquals(true, respondDao.getListOfRespondTitle());
	}

	@Test
	@DisplayName("Test DaddRespondQuestions ")
	void testDaddRespondQuestions() {
		logger.info("\n-----Testing addRespondQuestions-----\n");
		RespondDao respondDao = Factory.getRespondDaoInstance();
		RespondInfoBean respondInfoBean = new RespondInfoBean();
		assertEquals(true, respondDao.addRespondQuestions(respondInfoBean));
	}

	@Test
	@DisplayName("Test EaddRespondAnswers")
	void testEaddRespondAnswers() {
		logger.info("\n-----Testing addRespondAnswers-----\n");
		RespondDao respondDao = Factory.getRespondDaoInstance();
		RespondInfoBean respondInfoBean = new RespondInfoBean();
		assertEquals(true, respondDao.addRespondAnswers(respondInfoBean));
	}

	@Test
	@DisplayName("Test FgetRespondedList")
	void testFgetRespondedList() {
		logger.info("\n-----Testing getRespondedList-----\n");
		RespondDao respondDao = Factory.getRespondDaoInstance();
		assertEquals(true, respondDao.getRespondedList());
	}

	@Test
	@DisplayName("Test GgetRespondedRecord")
	void testGgetRespondedRecord() {
		logger.info("\n-----Testing getRespondedRecord-----\n");
		RespondDao respondDao = Factory.getRespondDaoInstance();
		assertEquals(true, respondDao.getRespondedRecord());
	}

}
