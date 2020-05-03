package com.capgemini.survey.service;


import com.capgemini.survey.beans.RespondentInfoBean;

public interface RespondentService {
	public boolean validateLoginRespondent(RespondentInfoBean respondent);

	public boolean validateGetRespondent(String respondentID1);

	public boolean validateAddRespondent(RespondentInfoBean respondent);

	public boolean validateUpdateRespondent(RespondentInfoBean respondent);

	public boolean validateDeleteRespondent(String respondentID1);

	public boolean validateGetAllRespondents();
}
