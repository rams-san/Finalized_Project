package com.capgemini.survey.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.survey.beans.SurveyInfoBean;

public interface SurveyDao {
	public SurveyInfoBean getSurvey(String surveyTitle);

	public boolean addSurvey(SurveyInfoBean survey);

	public boolean updateSurvey(SurveyInfoBean survey);

	public boolean deleteSurvey(String surveyTitle);
	
	public List<SurveyInfoBean> getAllSurveys();
	
	public boolean getListOfTitle();

	public ArrayList<String> getSurveyQuestions(String respondTitle);
}
