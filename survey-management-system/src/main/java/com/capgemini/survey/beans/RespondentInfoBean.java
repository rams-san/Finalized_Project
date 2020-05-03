package com.capgemini.survey.beans;

import java.time.LocalDate;

public class RespondentInfoBean {
	private int respondentId;
	private String respondentName;
	private String respondentEmail;
	private String respondentUserName;
	private String respondentPassword;
	private LocalDate respondentDob;

	@Override
	public String toString() {
		return "respondent [respondentId=" + respondentId + ", respondentName=" + respondentName + ", respondentEmail=" + respondentEmail + ", respondentUserName="
				+ respondentUserName + ", respondentPassword=" + respondentPassword + ", respondentDob=" + respondentDob + "]";
	}
	public int getRespondentId() {
		return respondentId;
	}

	public void setRespondentId(int respondentId) {
		this.respondentId = respondentId;
	}

	public String getRespondentName() {
		return respondentName;
	}

	public void setRespondentName(String respondentName) {
		this.respondentName = respondentName;
	}

	public String getRespondentEmail() {
		return respondentEmail;
	}

	public void setRespondentEmail(String respondentEmail) {
		this.respondentEmail = respondentEmail;
	}

	public String getRespondentUserName() {
		return respondentUserName;
	}

	public void setRespondentUserName(String respondentUserName) {
		this.respondentUserName = respondentUserName;
	}

	public String getRespondentPassword() {
		return respondentPassword;
	}

	public void setRespondentPassword(String respondentPassword) {
		this.respondentPassword = respondentPassword;
	}

	public LocalDate getRespondentDob() {
		return respondentDob;
	}

	public void setRespondentDob(LocalDate respondentDob) {
		this.respondentDob = respondentDob;
	}

	
}
