package com.capgemini.survey.beans;

import java.time.LocalDate;

public class SurveyorInfoBean {
	private int surveyorId;
	private String surveyorName;
	private String surveyorEmail;
	private String surveyorUserName;
	private String surveyorPassword;
	private LocalDate surveyorDob;
   // String str="\n";
	@Override
	public String toString() {
		return "Surveyor [surveyorId=" + surveyorId + ", surveyorName=" + surveyorName + ", surveyorEmail="
				+ surveyorEmail + ", surveyorUserName=" + surveyorUserName + ", surveyorPassword=" + surveyorPassword
				+ ", surveyorDob=" + surveyorDob + "]";
	}
	
	public int getSurveyorId() {
		return surveyorId;
	}

	public void setSurveyorId(int surveyorId) {
		this.surveyorId = surveyorId;
	}
	
	public String getSurveyorName() {
		return surveyorName;
	}

	public void setSurveyorName(String surveyorName) {
		this.surveyorName = surveyorName;
	}

	public String getSurveyorEmail() {
		return surveyorEmail;
	}

	public void setSurveyorEmail(String surveyorEmail) {
		this.surveyorEmail = surveyorEmail;
	}

	public String getSurveyorUserName() {
		return surveyorUserName;
	}

	public void setSurveyorUserName(String surveyorUserName) {
		this.surveyorUserName = surveyorUserName;
	}

	public String getSurveyorPassword() {
		return surveyorPassword;
	}

	public void setSurveyorPassword(String surveyorPassword) {
		this.surveyorPassword = surveyorPassword;
	}

	public LocalDate getSurveyorDob() {
		return surveyorDob;
	}

	public void setSurveyorDob(LocalDate surveyorDob) {
		this.surveyorDob = surveyorDob;
	}

	
}
