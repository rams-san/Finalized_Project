package com.capgemini.survey.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.survey.beans.AdminInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.validations.InputValidations;

public class AdminDaoImpl implements AdminDao {

	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	static List<AdminInfoBean> adm = new ArrayList<AdminInfoBean>();
	InputValidations inputValidation = Factory.getInputValidationInstance();
	int counter = 0;
	Scanner sc = new Scanner(System.in);
	static {
		AdminInfoBean adminInfoBean = Factory.getAdminInfoBeanInstance();

		adminInfoBean.setAdminUserName("Suyash");
		adminInfoBean.setAdminPassword("Suyash@123");
		adm.add(adminInfoBean);

		/*
		 * for (AdminInfoBean adminInfoBean1 : adm) { logger.info(adminInfoBean1); }
		 */
	}

	public boolean loginAdmin(AdminInfoBean admin) {
		for (AdminInfoBean adminInfoBean : adm) {

			logger.info("Enter Admin UserName :");
			String userName1;
			userName1 = sc.next();

			while (!inputValidation.userNameValidation(userName1)) {
				logger.info("Please enter valid admin username ");
				userName1 = sc.next();
			}

			logger.info("Enter Admin Password :");
			String password1;
			password1 = sc.next();

			while (!inputValidation.passwordValidation(password1)) {
				logger.info("Please enter valid admin password ");
				password1 = sc.next();
			}
		
			if ((adminInfoBean.getAdminUserName().equals(userName1)) && (adminInfoBean.getAdminPassword().equals(password1))) {
				logger.info("Login Done");
				return true;
			}
		}
		logger.info("Invalid credentials please try again");
		return false;
	}
}
