package com.capgemini.survey.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.survey.beans.SurveyorInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.dao.SurveyorDao;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.validations.InputValidations;

public class SurveyorServiceImpl implements SurveyorService {
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	InputValidations inputValidation = Factory.getInputValidationInstance();
	Scanner sc = new Scanner(System.in);

	public boolean validateLoginSurveyor(SurveyorInfoBean surveyor) {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		boolean b = surveyorDao.loginSurveyor(surveyor);
		if (b == true) {
			return true;
		} else
			return false;
	}

	public boolean validateGetSurveyor(String surveyorID1) {
		while (!inputValidation.titleValidation(surveyorID1)) {
			logger.info("Please enter valid choice: ");
			surveyorID1 = sc.next();
		}
		int surveyorID = Integer.parseInt(surveyorID1);
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		surveyorDao.getSurveyor(surveyorID);
		return false;
	}

	public boolean validateAddSurveyor(SurveyorInfoBean surveyor) {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		surveyorDao.addSurveyor(surveyor);
		return false;
	}

	public boolean validateUpdateSurveyor(SurveyorInfoBean surveyor) {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		surveyorDao.updateSurveyor(surveyor);
		return false;
	}

	public boolean validateDeleteSurveyor(String surveyorID1) {
		while (!inputValidation.idValidation(surveyorID1)) {
			logger.info("Please enter valid choice: ");
			surveyorID1 = sc.next();
		}
		int surveyorID = Integer.parseInt(surveyorID1);
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		surveyorDao.deleteSurveyor(surveyorID);	
		return false;
	}

	public boolean validateGetAllSurveyors() {
		SurveyorDao surveyorDao = Factory.getSurveyorDaoInstance();
		surveyorDao.getAllSurveyors();
		return false;
	}
}
