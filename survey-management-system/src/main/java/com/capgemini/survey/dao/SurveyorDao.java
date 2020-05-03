package com.capgemini.survey.dao;

import java.util.List;

import com.capgemini.survey.beans.SurveyorInfoBean;

public interface SurveyorDao {
	public boolean loginSurveyor(SurveyorInfoBean surveyor);
	
	public SurveyorInfoBean getSurveyor(int surveyorID);

	public boolean addSurveyor(SurveyorInfoBean surveyor);

	public boolean updateSurveyor(SurveyorInfoBean surveyor);

	public boolean deleteSurveyor(int surveyorID);

	public List<SurveyorInfoBean> getAllSurveyors();
}
