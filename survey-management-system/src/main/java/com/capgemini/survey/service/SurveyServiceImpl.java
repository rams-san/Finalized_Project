package com.capgemini.survey.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.survey.beans.SurveyInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.dao.SurveyDao;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.validations.InputValidations;


public class SurveyServiceImpl implements SurveyService {
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	InputValidations inputValidation = Factory.getInputValidationInstance();
	Scanner sc = new Scanner(System.in);

	public boolean validateGetSurvey(String surveyTitle) {
		while (!inputValidation.titleValidation(surveyTitle)) {
			logger.info("Please enter valid choice: ");
			surveyTitle = sc.next();
		}
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		surveyDao.getSurvey(surveyTitle);
		return false;
	}
	
	public boolean validateAddSurvey(SurveyInfoBean survey) {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		surveyDao.addSurvey(survey);
		return false;
	}

	public boolean validateUpdateSurvey(SurveyInfoBean survey) {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		surveyDao.updateSurvey(survey);
		return false;
	}

	public boolean validateDeleteSurvey(String surveyTitle) {
		while (!inputValidation.titleValidation(surveyTitle)) {
			logger.info("Please enter valid choice: ");
			surveyTitle = sc.next();
		}
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		surveyDao.deleteSurvey(surveyTitle);	
		return false;
	}

	public boolean validateGetAllSurveys() {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		surveyDao.getAllSurveys();
		return false;
	}

	public boolean validateGetListOfTitle() {
		SurveyDao surveyDao = Factory.getSurveyDaoInstance();
		surveyDao.getListOfTitle();
		return false;
	}
}
