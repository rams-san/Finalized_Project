package com.capgemini.survey.service;

import org.apache.log4j.Logger;

import com.capgemini.survey.beans.RespondInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.dao.RespondDao;
import com.capgemini.survey.factory.Factory;

public class RespondServiceImpl implements RespondService {
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);

	public boolean validateAddRespondId(RespondInfoBean respond) {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		if (respondDao.addRespondId(respond)) {
			return true;
		}
		return false;
	}

	public boolean validateAddRespondTitle(RespondInfoBean respond) {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		respondDao.addRespondTitle(respond);
		return false;
	}

	public boolean validateGetListOfRespondTitle() {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		if (respondDao.getListOfRespondTitle()) {
			return true;
		}
		return false;
	}

	public boolean validateAddRespondQuestions(RespondInfoBean respond) {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		if (respondDao.addRespondQuestions(respond)) {
			return true;
		}
		return false;
	}

	public boolean validateAddRespondAnswers(RespondInfoBean respond) {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		if (respondDao.addRespondAnswers(respond)) {
			return true;
		}
		return false;
	}

	public boolean validateGetAllResponds() {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		respondDao.getAllResponds();
		return false;
	}

	public boolean validateGetRespondedList() {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		respondDao.getRespondedList();
		return false;
	}

	public boolean validateGetPendingRespondList() {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		respondDao.getPendingRespondList();
		return false;
	}

	public boolean validateGetRespondedRecord() {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		respondDao.getRespondedRecord();
		return false;
	}

	public boolean validateGetPendingRecord() {
		RespondDao respondDao = Factory.getRespondDaoInstance();
		respondDao.getPendingRecord();
		return false;
	}
}
