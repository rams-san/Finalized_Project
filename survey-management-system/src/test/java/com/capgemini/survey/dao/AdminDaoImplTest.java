package com.capgemini.survey.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.survey.beans.AdminInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.factory.Factory;

class AdminDaoImplTest {
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);

	@Test
	@DisplayName("Test loginAdmin")
	void testLoginAdmin() {
		logger.info("\n-----Testing loginAdmin for correct user-----\n");
		AdminDao adminDao = Factory.getAdminDaoInstance();
		AdminInfoBean admin = new AdminInfoBean();
		assertEquals(true, adminDao.loginAdmin(admin ));
	}
	
	@Test
	@DisplayName("Test loginAdmin1")
	void testLoginAdmin1() {
		logger.info("\n-----Testing loginAdmin1 for wrong user-----\n");
		AdminDao adminDao = Factory.getAdminDaoInstance();
		AdminInfoBean admin = new AdminInfoBean();
		assertEquals(false, adminDao.loginAdmin(admin ));
	}
}
