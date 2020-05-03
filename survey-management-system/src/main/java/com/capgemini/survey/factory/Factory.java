package com.capgemini.survey.factory;

import com.capgemini.survey.beans.AdminInfoBean;
import com.capgemini.survey.beans.RespondInfoBean;
import com.capgemini.survey.beans.RespondentInfoBean;
import com.capgemini.survey.beans.SurveyInfoBean;
import com.capgemini.survey.beans.SurveyorInfoBean;
import com.capgemini.survey.dao.AdminDao;
import com.capgemini.survey.dao.AdminDaoImpl;
import com.capgemini.survey.dao.RespondDao;
import com.capgemini.survey.dao.RespondDaoImpl;
import com.capgemini.survey.dao.RespondentDao;
import com.capgemini.survey.dao.RespondentDaoImpl;
import com.capgemini.survey.dao.SurveyDao;
import com.capgemini.survey.dao.SurveyDaoImpl;
import com.capgemini.survey.dao.SurveyorDao;
import com.capgemini.survey.dao.SurveyorDaoImpl;
import com.capgemini.survey.service.AdminService;
import com.capgemini.survey.service.AdminServiceImpl;
import com.capgemini.survey.service.RespondService;
import com.capgemini.survey.service.RespondServiceImpl;
import com.capgemini.survey.service.RespondentService;
import com.capgemini.survey.service.RespondentServiceImpl;
import com.capgemini.survey.service.SurveyService;
import com.capgemini.survey.service.SurveyServiceImpl;
import com.capgemini.survey.service.SurveyorService;
import com.capgemini.survey.service.SurveyorServiceImpl;
import com.capgemini.survey.validations.InputValidations;
import com.capgemini.survey.validations.InputValidationsImpl;

public class Factory {
	private Factory() {

	}

	public static AdminInfoBean getAdminInfoBeanInstance() {
		AdminInfoBean adminInfoBean = new AdminInfoBean();
		return adminInfoBean;
	}
	
	public static AdminDao getAdminDaoInstance() {
		AdminDao adminDao = new AdminDaoImpl();
		return adminDao;
	}

	public static AdminService getAdminServiceInstance() {
		AdminService adminService = new AdminServiceImpl();
		return adminService;
	}
	
	public static SurveyorInfoBean getSurveyorInfoBeanInstance() {
		SurveyorInfoBean surveyorInfoBean = new SurveyorInfoBean();
		return surveyorInfoBean;
	}
	
	public static SurveyorDao getSurveyorDaoInstance() {
		SurveyorDao surveyorDao = new SurveyorDaoImpl();
		return surveyorDao;
	}
	
	public static SurveyorService getSurveyorServiceInstance() {
		SurveyorService surveyorService = new SurveyorServiceImpl();
		return surveyorService;
	}
	
	public static RespondentInfoBean getRespondentInfoBeanInstance() {
		RespondentInfoBean respondentInfoBean = new RespondentInfoBean();
		return respondentInfoBean;
	}
	
	public static RespondentDao getRespondentDaoInstance() {
		RespondentDao respondentDao = new RespondentDaoImpl();
		return respondentDao;
	}
	
	public static RespondentService getRespondentServiceInstance() {
		RespondentService respondentService = new RespondentServiceImpl();
		return respondentService;
	}
	
	public static SurveyInfoBean getSurveyInfoBeanInstance() {
		SurveyInfoBean surveyInfoBean = new SurveyInfoBean();
		return surveyInfoBean;
	}

	public static SurveyDao getSurveyDaoInstance() {
		SurveyDao surveyDao = new SurveyDaoImpl();
		return surveyDao;
	}

	public static SurveyService getSurveyServiceInstance() {
		SurveyService surveyService = new SurveyServiceImpl();
		return surveyService;
	}
	
	public static InputValidations getInputValidationInstance() {
		InputValidations inputValidation = new InputValidationsImpl();
		return inputValidation;
	}
	
	public static RespondInfoBean getRespondInfoBeanInstance() {
		RespondInfoBean respondInfoBean = new RespondInfoBean();
		return respondInfoBean;
	}
	
	public static RespondDao getRespondDaoInstance() {
		RespondDao respondDao = new RespondDaoImpl();
		return respondDao;
	}
	
	public static RespondService getRespondServiceInstance() {
		RespondService respondService = new RespondServiceImpl();
		return respondService;
	}
}
