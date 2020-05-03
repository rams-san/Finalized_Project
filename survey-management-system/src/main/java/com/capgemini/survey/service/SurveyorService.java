package com.capgemini.survey.service;

import com.capgemini.survey.beans.SurveyorInfoBean;

public interface SurveyorService {
	public boolean validateLoginSurveyor(SurveyorInfoBean surveyor);

	public boolean validateGetSurveyor(String surveyorID1);

	public boolean validateAddSurveyor(SurveyorInfoBean surveyor);

	public boolean validateUpdateSurveyor(SurveyorInfoBean surveyor);

	public boolean validateDeleteSurveyor(String surveyorID1);

	public boolean validateGetAllSurveyors();
}
