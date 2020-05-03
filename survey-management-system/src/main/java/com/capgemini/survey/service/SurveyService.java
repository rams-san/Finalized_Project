package com.capgemini.survey.service;

import com.capgemini.survey.beans.SurveyInfoBean;

public interface SurveyService {

	public boolean validateGetSurvey(String surveyTitle);

	public boolean validateAddSurvey(SurveyInfoBean survey);

	public boolean validateUpdateSurvey(SurveyInfoBean survey);

	public boolean validateDeleteSurvey(String surveyTitle);
	
	public boolean validateGetAllSurveys();
	
	public boolean validateGetListOfTitle();
}
