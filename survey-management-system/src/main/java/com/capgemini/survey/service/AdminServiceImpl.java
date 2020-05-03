package com.capgemini.survey.service;

import org.apache.log4j.Logger;

import com.capgemini.survey.beans.AdminInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.dao.AdminDao;
import com.capgemini.survey.factory.Factory;

public class AdminServiceImpl implements AdminService {
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);

	public boolean validateLoginAdmin(AdminInfoBean admin) {
		AdminDao adminDao = Factory.getAdminDaoInstance();
		boolean b = adminDao.loginAdmin(admin);
//		logger.info(b+"from service");
		if (b == true) {
			return true;
		} else
			return false;
	}

}
