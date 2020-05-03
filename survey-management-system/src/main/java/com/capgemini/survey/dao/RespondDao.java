package com.capgemini.survey.dao;

import java.util.List;

import com.capgemini.survey.beans.RespondInfoBean;


public interface RespondDao {
	public boolean getRespondedList();
	
	public boolean getRespondedRecord();
	
	public boolean getPendingRecord();
	
	public boolean getPendingRespondList();

	public boolean addRespondId(RespondInfoBean respond);
	
	public boolean addRespondTitle(RespondInfoBean respond);
	
	public boolean addRespondQuestions(RespondInfoBean respond);

	public boolean addRespondAnswers(RespondInfoBean respond);

	public List<RespondInfoBean> getAllResponds();
	
	public boolean getListOfRespondTitle();
}
