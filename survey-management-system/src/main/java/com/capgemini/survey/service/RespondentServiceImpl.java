package com.capgemini.survey.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.survey.beans.RespondentInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.dao.RespondentDao;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.validations.InputValidations;

public class RespondentServiceImpl implements RespondentService{
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	InputValidations inputValidation = Factory.getInputValidationInstance();
	Scanner sc = new Scanner(System.in);
	
	public boolean validateLoginRespondent(RespondentInfoBean respondent) {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		boolean b = respondentDao.loginRespondent(respondent);
		if (b == true) {
			return true;
		} else
			return false;
	}

	public boolean validateGetRespondent(String respondentID1) {
		while (!inputValidation.idValidation(respondentID1)) {
			logger.info("Please enter valid choice: ");
			respondentID1 = sc.next();
		}
		int respondentID = Integer.parseInt(respondentID1);
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		respondentDao.getRespondent(respondentID);
		return false;
	}

	public boolean validateAddRespondent(RespondentInfoBean respondent) {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		respondentDao.addRespondent(respondent);
		return false;
	}

	public boolean validateUpdateRespondent(RespondentInfoBean respondent) {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		respondentDao.updateRespondent(respondent);
		return false;
	}

	public boolean validateDeleteRespondent(String respondentID1) {
		while (!inputValidation.idValidation(respondentID1)) {
			logger.info("Please enter valid choice: ");
			respondentID1 = sc.next();
		}
		int respondentID = Integer.parseInt(respondentID1);
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		respondentDao.deleteRespondent(respondentID);	
		return false;
	}

	public boolean validateGetAllRespondents() {
		RespondentDao respondentDao = Factory.getRespondentDaoInstance();
		respondentDao.getAllRespondents();
		return false;
	}
}
