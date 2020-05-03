package com.capgemini.survey.dao;

import java.util.List;

import com.capgemini.survey.beans.RespondentInfoBean;


public interface RespondentDao {
	public boolean loginRespondent(RespondentInfoBean respondent);
	
	public RespondentInfoBean getRespondent(int respondentID);

	public boolean addRespondent(RespondentInfoBean respondent);

	public boolean updateRespondent(RespondentInfoBean respondent);

	public boolean deleteRespondent(int respondentID);

	public List<RespondentInfoBean> getAllRespondents();
}
