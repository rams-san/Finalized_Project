package com.capgemini.survey.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.survey.beans.SurveyInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.validations.InputValidations;

public class SurveyDaoImpl implements SurveyDao {
	static List<SurveyInfoBean> surveyList = new ArrayList<SurveyInfoBean>();
	InputValidations inputValidation = Factory.getInputValidationInstance();
	SurveyInfoBean surveyInfoBean = Factory.getSurveyInfoBeanInstance();
	ArrayList<String> titleList = new ArrayList<String>();
	ArrayList<String> questionList = new ArrayList<String>();


	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	int counter = 0;

	Scanner sc = new Scanner(System.in);
	static {
		SurveyInfoBean surveyInfoBean1 = Factory.getSurveyInfoBeanInstance();
		surveyInfoBean1.setSurveyTitle("Amazon Prime");
		surveyInfoBean1.setSurveyDescription("Amazon Prime Survey");
		surveyInfoBean1.setSurveyQuestion1("1.Have you ever heard of Amazon Prime (yes/no)?");
		surveyInfoBean1.setSurveyQuestion2("2.Are you more inclined to buy an item you normally wouldn't consider buying if it is on sale (yes/no)?");
		surveyInfoBean1.setSurveyQuestion3("3.What 3 words would you use to describe Amazon Prime?");
		surveyInfoBean1.setSurveyQuestion4("4.In general, do you feel like subscription services are worth the price of membership? (yes/no)");
		surveyInfoBean1.setSurveyQuestion5("5.Do you know how much Amazon Prime costs (yes/no)?");
		surveyInfoBean1.setSurveyQuestion6("6.Have you ever used Amazon Prime (yes/no)?");
		surveyInfoBean1.setSurveyQuestion7("7.If you have used Amazon Prime what features did you like about it the best?");
		surveyInfoBean1.setSurveyQuestion8("8.Have you seen advertisements for Amazon Prime (yes/no)?");
		surveyInfoBean1.setSurveyQuestion9("9.What features, if any, would you like to see added to Amazon Prime?");
		surveyInfoBean1.setSurveyQuestion10("10.Rate Amazon Prime from (1-10).");

		SurveyInfoBean surveyInfoBean2 = Factory.getSurveyInfoBeanInstance();
		surveyInfoBean2.setSurveyTitle("Flipkart");
		surveyInfoBean2.setSurveyDescription("Flipkart Survey");
		surveyInfoBean2.setSurveyQuestion1("1.Have you ever heard of flipkart (yes/no)?");
		surveyInfoBean2.setSurveyQuestion2("2.Are you more inclined to buy an item you normally wouldn't consider buying if it is on sale (yes/no)?");
		surveyInfoBean2.setSurveyQuestion3("3.What 3 words would you use to describe flipkart?");
		surveyInfoBean2.setSurveyQuestion4("4.Have you ever used flipkart (yes/no)?");
		surveyInfoBean2.setSurveyQuestion5("5.Have you seen advertisements for Flipkart?");
		surveyInfoBean2.setSurveyQuestion6("6.Is Our Product Quality Satisfactory (yes/no)?");
		surveyInfoBean2.setSurveyQuestion7("7.Mention Specific type of item that you didn't found on our website.");
		surveyInfoBean2.setSurveyQuestion8("8.Do you like our payment facility (yes/no)?");
		surveyInfoBean2.setSurveyQuestion9("9.What features, if any, would you like to see added to flipkart?");
		surveyInfoBean2.setSurveyQuestion10("10.Rate flipkart from (1-10).");

		SurveyInfoBean surveyInfoBean3 = Factory.getSurveyInfoBeanInstance();
		surveyInfoBean3.setSurveyTitle("Facebook");
		surveyInfoBean3.setSurveyDescription("Facebook Survey");
		surveyInfoBean3.setSurveyQuestion1("1.What is your name ?");
		surveyInfoBean3.setSurveyQuestion2("2.What is your age ?");
		surveyInfoBean3.setSurveyQuestion3("3.Have you ever used facebook (yes/no)?");
		surveyInfoBean3.setSurveyQuestion4("4.How many accounts do you have (one/one or more)? please enter below :");
		surveyInfoBean3.setSurveyQuestion5("5.What 3 words would you use to describe facebook?");
		surveyInfoBean3.setSurveyQuestion6("6.Is facebook useful to communicate with your friends (yes/no)?");
		surveyInfoBean3.setSurveyQuestion7("7.Have you ever used facebook live (yes/no)?");
		surveyInfoBean3.setSurveyQuestion8("8.What features, if any, would you like to see added to facebook ?");
		surveyInfoBean3.setSurveyQuestion9("9.For what purpose you are using facebook (personal/commercial) ?");
		surveyInfoBean3.setSurveyQuestion10("10.Rate facebook from (1-10).");
		

		surveyList.add(surveyInfoBean1);
		surveyList.add(surveyInfoBean2);
		surveyList.add(surveyInfoBean3);
		logger.info("\n");
		
		/*
		 * for (SurveyInfoBean surveyInfoBean4 : surveyList) {
		 * logger.info("\n"+surveyInfoBean4); }
		 */
	}
	public SurveyInfoBean getSurvey(String surveyTitle) {
		for (SurveyInfoBean surveyInfoBean : surveyList) {
			if (surveyInfoBean.getSurveyTitle().equals(surveyTitle)) {

				counter++;
				logger.info("\nGetting surveyor details !!");
				List<SurveyInfoBean> searchSurvey = new ArrayList<SurveyInfoBean>();
				searchSurvey.add(surveyInfoBean);
				logger.info("\n"+searchSurvey);
			}
		}
		if (counter == 0) {
			throw new NotFoundException("Survey doesn't exists");
		}
		return null;
	}

	public boolean addSurvey(SurveyInfoBean survey) {

		Iterator<SurveyInfoBean> surveyInfoBean4 = surveyList.iterator();

		logger.info("Enter Survey Title :");
		String surveyTitle = sc.nextLine();
		while (!inputValidation.titleValidation(surveyTitle)) {
			logger.error("please enter valid survey title");
			surveyTitle = sc.nextLine();
		}
		while (surveyInfoBean4.hasNext()) {
			SurveyInfoBean compare2 = surveyInfoBean4.next();

			if (compare2.getSurveyTitle().equals(surveyTitle)) {
				counter++;
			}
		}
		if (counter == 0) {
			SurveyInfoBean surveyInfoBean = Factory.getSurveyInfoBeanInstance();

			surveyInfoBean.setSurveyTitle(surveyTitle);

			logger.info("Enter Survey Description :");
			String description = sc.nextLine();

			while (!inputValidation.descriptionValidation(description)) {
				logger.error("please enter valid survey description");
				description = sc.nextLine();
			}
			surveyInfoBean.setSurveyDescription(description);

			logger.info("Enter Survey Question no 1 :");
			String question1 = sc.nextLine();
			while (!inputValidation.questionValidation(question1)) {
				logger.info("Please enter valid question ");
				question1 = sc.nextLine();
			}
			surveyInfoBean.setSurveyQuestion1(question1);

			logger.info("Enter Survey Question no 2 :");
			String question2 = sc.nextLine();
			while (!inputValidation.questionValidation(question2)) {
				logger.info("Please enter valid question ");
				question2 = sc.nextLine();
			}
			surveyInfoBean.setSurveyQuestion2(question2);

			logger.info("Enter Survey Question no 3 :");
			String question3 = sc.nextLine();
			while (!inputValidation.questionValidation(question3)) {
				logger.info("Please enter valid question ");
				question3 = sc.nextLine();
			}
			surveyInfoBean.setSurveyQuestion3(question3);

			logger.info("Enter Survey Question no 4 :");
			String question4 = sc.nextLine();
			while (!inputValidation.questionValidation(question4)) {
				logger.info("Please enter valid question ");
				question4 = sc.nextLine();
			}
			surveyInfoBean.setSurveyQuestion4(question4);

			logger.info("Enter Survey Question no 5 :");
			String question5 = sc.nextLine();
			while (!inputValidation.questionValidation(question5)) {
				logger.info("Please enter valid question ");
				question5 = sc.nextLine();
			}
			surveyInfoBean.setSurveyQuestion5(question5);

			logger.info("Enter Survey Question no 6 :");
			String question6 = sc.nextLine();
			while (!inputValidation.questionValidation(question6)) {
				logger.info("Please enter valid question ");
				question6 = sc.nextLine();
			}
			surveyInfoBean.setSurveyQuestion6(question6);

			logger.info("Enter Survey Question no 7 :");
			String question7 = sc.nextLine();
			while (!inputValidation.questionValidation(question7)) {
				logger.info("Please enter valid question ");
				question7 = sc.nextLine();
			}
			surveyInfoBean.setSurveyQuestion7(question7);

			logger.info("Enter Survey Question no 8 :");
			String question8 = sc.nextLine();
			while (!inputValidation.questionValidation(question8)) {
				logger.info("Please enter valid question ");
				question8 = sc.nextLine();
			}
			surveyInfoBean.setSurveyQuestion8(question8);

			logger.info("Enter Survey Question no 9 :");
			String question9 = sc.nextLine();
			while (!inputValidation.questionValidation(question9)) {
				logger.info("Please enter valid question ");
				question9 = sc.nextLine();
			}
			surveyInfoBean.setSurveyQuestion9(question9);

			logger.info("Enter Survey Question no 10 :");
			String question10 = sc.nextLine();
			while (!inputValidation.questionValidation(question10)) {
				logger.info("Please enter valid question ");
				question10 = sc.nextLine();
			}
			surveyInfoBean.setSurveyQuestion10(question10);

			ArrayList<SurveyInfoBean> list3 = new ArrayList<SurveyInfoBean>();
			list3.add(surveyInfoBean);

			surveyList.addAll(list3);

			if (list3.isEmpty()) {
				logger.error("Survey not added");
			} else {
				logger.info("\nSurvey is added \n");
			}
			return true;
		} else {
			logger.info("\nSurvey already exists !!");
		}
		return false;
	}

	public boolean updateSurvey(SurveyInfoBean survey) {

		logger.info("Enter Survey Title :");
		String surveyTitle;
		surveyTitle = sc.nextLine();

		while (!inputValidation.titleValidation(surveyTitle)) {
			logger.info("Please Enter Valid survey title ");
			surveyTitle = sc.nextLine();
		}
		for (SurveyInfoBean surveyInfoBean : surveyList) {

			if (surveyInfoBean.getSurveyTitle().equals(surveyTitle)) {
				counter++;
			}
		}
		if (counter != 0) {

			for (SurveyInfoBean surveyInfoBean : surveyList) {

				if (surveyInfoBean.getSurveyTitle().equals(surveyTitle)) {
					logger.info("Update Survey Description :");
					String surveyDescription = sc.nextLine();
					while (!inputValidation.descriptionValidation(surveyDescription)) {
						logger.info("Please enter valid survey description ");
						surveyDescription = sc.nextLine();
					}
					surveyInfoBean.setSurveyDescription(surveyDescription);
					logger.info("Update Survey Question no 1 :");
					String question1 = sc.nextLine();
					while (!inputValidation.questionValidation(question1)) {
						logger.info("Please enter valid question ");
						question1 = sc.nextLine();
					}
					surveyInfoBean.setSurveyQuestion1(question1);

					logger.info("Update Survey Question no 2 :");
					String question2 = sc.nextLine();
					while (!inputValidation.questionValidation(question2)) {
						logger.info("Please enter valid question ");
						question2 = sc.nextLine();
					}
					surveyInfoBean.setSurveyQuestion2(question2);

					logger.info("Update Survey Question no 3 :");
					String question3 = sc.nextLine();
					while (!inputValidation.questionValidation(question3)) {
						logger.info("Please enter valid question ");
						question3 = sc.nextLine();
					}
					surveyInfoBean.setSurveyQuestion3(question3);

					logger.info("Update Survey Question no 4 :");
					String question4 = sc.nextLine();
					while (!inputValidation.questionValidation(question4)) {
						logger.info("Please enter valid question ");
						question4 = sc.nextLine();
					}
					surveyInfoBean.setSurveyQuestion4(question4);

					logger.info("Update Survey Question no 5 :");
					String question5 = sc.nextLine();
					while (!inputValidation.questionValidation(question5)) {
						logger.info("Please enter valid question ");
						question5 = sc.nextLine();
					}
					surveyInfoBean.setSurveyQuestion5(question5);

					logger.info("Update Survey Question no 6 :");
					String question6 = sc.nextLine();
					while (!inputValidation.questionValidation(question6)) {
						logger.info("Please enter valid question ");
						question6 = sc.nextLine();
					}
					surveyInfoBean.setSurveyQuestion6(question6);

					logger.info("Update Survey Question no 7 :");
					String question7 = sc.nextLine();
					while (!inputValidation.questionValidation(question7)) {
						logger.info("Please enter valid question ");
						question7 = sc.nextLine();
					}
					surveyInfoBean.setSurveyQuestion7(question7);

					logger.info("Update Survey Question no 8 :");
					String question8 = sc.nextLine();
					while (!inputValidation.questionValidation(question8)) {
						logger.info("Please enter valid question ");
						question8 = sc.nextLine();
					}
					surveyInfoBean.setSurveyQuestion8(question8);

					logger.info("Update Survey Question no 9 :");
					String question9 = sc.nextLine();
					while (!inputValidation.questionValidation(question9)) {
						logger.info("Please enter valid question ");
						question9 = sc.nextLine();
					}
					surveyInfoBean.setSurveyQuestion9(question9);

					logger.info("Update Survey Question no 10 :");
					String question10 = sc.nextLine();
					while (!inputValidation.questionValidation(question10)) {
						logger.info("Please enter valid question ");
						question10 = sc.nextLine();
					}
					surveyInfoBean.setSurveyQuestion10(question10);
					logger.info("\nSurvey Updated !!");
				}
			}
			return true;
		} else {
			throw new NotFoundException("Survey doesn't exists");
		}
	}

	public boolean deleteSurvey(String surveyTitle) {
		Iterator<SurveyInfoBean> surveyInfoBean = surveyList.iterator();
		while (surveyInfoBean.hasNext()) {
			SurveyInfoBean itr1 = surveyInfoBean.next();
			if (itr1.getSurveyTitle().equals(surveyTitle)) {
				counter++;
				surveyInfoBean.remove();
				logger.info("\nData deleted");
			}
		}
		if (counter == 0) {
			throw new NotFoundException("Survey doesn't exists");
		}
		return true;
	}

	public List<SurveyInfoBean> getAllSurveys() {
		logger.info("\nDetails of all Surveys !!");
		for (SurveyInfoBean surveyInfoBean : surveyList) {
			logger.info(surveyInfoBean);
		}
		return surveyList;
	}

	public boolean getListOfTitle() {
		logger.info("\nList of Survey Titles : \n");
		for (SurveyInfoBean surveyInfoBean : surveyList) {
			String str = surveyInfoBean.getSurveyTitle();
			titleList.add(str);
		}
		int n=0;
		for(int i=0;i<titleList.size();i++) {
			n++;
			logger.info(n+"."+titleList.get(i));
		}
		return true;
	}

	public ArrayList<String> getSurveyQuestions(String respondTitle) {
		for (SurveyInfoBean surveyInfoBean : surveyList) {
			if (surveyInfoBean.getSurveyTitle().equals(respondTitle)) {
				questionList.add((surveyInfoBean.getSurveyQuestion1()));
				questionList.add((surveyInfoBean.getSurveyQuestion2()));
				questionList.add((surveyInfoBean.getSurveyQuestion3()));
				questionList.add((surveyInfoBean.getSurveyQuestion4()));
				questionList.add((surveyInfoBean.getSurveyQuestion5()));
				questionList.add((surveyInfoBean.getSurveyQuestion6()));
				questionList.add((surveyInfoBean.getSurveyQuestion7()));
				questionList.add((surveyInfoBean.getSurveyQuestion8()));
				questionList.add((surveyInfoBean.getSurveyQuestion9()));
				questionList.add((surveyInfoBean.getSurveyQuestion10()));
				counter++;
			}
		}
		if(counter!=0) {
			return questionList;
		}
		else {
			throw new NotFoundException("\nSurvey title doesn't exists");
		}
	}
}
