package com.capgemini.survey.service;

import com.capgemini.survey.beans.RespondInfoBean;

public interface RespondService {
	public boolean validateAddRespondId(RespondInfoBean respond);
	public boolean validateAddRespondTitle(RespondInfoBean respond);
	public boolean validateGetListOfRespondTitle();
	public boolean validateAddRespondQuestions(RespondInfoBean respond);
	public boolean validateAddRespondAnswers(RespondInfoBean respond);
	public boolean validateGetAllResponds(); 
    public boolean validateGetRespondedList();
	public boolean validateGetPendingRespondList();
    public boolean validateGetRespondedRecord();
	public boolean validateGetPendingRecord();
}
