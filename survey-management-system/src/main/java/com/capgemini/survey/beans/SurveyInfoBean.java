package com.capgemini.survey.beans;

public class SurveyInfoBean {
	private String surveyTitle;
	private String surveyDescription;
	private String surveyQuestion1;
	private String surveyQuestion2;
	private String surveyQuestion3;
	private String surveyQuestion4;
	private String surveyQuestion5;
	private String surveyQuestion6;
	private String surveyQuestion7;
	private String surveyQuestion8;
	private String surveyQuestion9;
	private String surveyQuestion10;

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	public String getSurveyDescription() {
		return surveyDescription;
	}

	public void setSurveyDescription(String surveyDescription) {
		this.surveyDescription = surveyDescription;
	}

	public String getSurveyQuestion1() {
		return surveyQuestion1;
	}

	public void setSurveyQuestion1(String surveyQuestion1) {
		this.surveyQuestion1 = surveyQuestion1;
	}

	public String getSurveyQuestion2() {
		return surveyQuestion2;
	}

	public void setSurveyQuestion2(String surveyQuestion2) {
		this.surveyQuestion2 = surveyQuestion2;
	}

	public String getSurveyQuestion3() {
		return surveyQuestion3;
	}

	public void setSurveyQuestion3(String surveyQuestion3) {
		this.surveyQuestion3 = surveyQuestion3;
	}

	public String getSurveyQuestion4() {
		return surveyQuestion4;
	}

	public void setSurveyQuestion4(String surveyQuestion4) {
		this.surveyQuestion4 = surveyQuestion4;
	}

	public String getSurveyQuestion5() {
		return surveyQuestion5;
	}

	public void setSurveyQuestion5(String surveyQuestion5) {
		this.surveyQuestion5 = surveyQuestion5;
	}

	public String getSurveyQuestion6() {
		return surveyQuestion6;
	}

	public void setSurveyQuestion6(String surveyQuestion6) {
		this.surveyQuestion6 = surveyQuestion6;
	}

	public String getSurveyQuestion7() {
		return surveyQuestion7;
	}

	public void setSurveyQuestion7(String surveyQuestion7) {
		this.surveyQuestion7 = surveyQuestion7;
	}

	public String getSurveyQuestion8() {
		return surveyQuestion8;
	}

	public void setSurveyQuestion8(String surveyQuestion8) {
		this.surveyQuestion8 = surveyQuestion8;
	}

	public String getSurveyQuestion9() {
		return surveyQuestion9;
	}

	public void setSurveyQuestion9(String surveyQuestion9) {
		this.surveyQuestion9 = surveyQuestion9;
	}

	public String getSurveyQuestion10() {
		return surveyQuestion10;
	}

	public void setSurveyQuestion10(String surveyQuestion10) {
		this.surveyQuestion10 = surveyQuestion10;
	}

	@Override
	public String toString() {
		String str = "\n";
		return "surveyTitle = " + surveyTitle + str + "surveyDescription = " + surveyDescription + str + surveyQuestion1 + str
				+ surveyQuestion2 + str + surveyQuestion3 + str + surveyQuestion4 + str + surveyQuestion5 + str
				+ surveyQuestion6 + str + surveyQuestion7 + str + surveyQuestion8 + str + surveyQuestion9 + str
				+ surveyQuestion10;
	}

}
