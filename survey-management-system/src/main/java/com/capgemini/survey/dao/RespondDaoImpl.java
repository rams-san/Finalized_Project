package com.capgemini.survey.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.survey.beans.RespondInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.service.SurveyService;
import com.capgemini.survey.validations.InputValidations;

public class RespondDaoImpl implements RespondDao {
	static List<RespondInfoBean> respondList = new ArrayList<RespondInfoBean>();
	InputValidations inputValidation = Factory.getInputValidationInstance();
	RespondInfoBean respondInfoBean = Factory.getRespondInfoBeanInstance();
	ArrayList<String> respondTitleList = new ArrayList<String>();
	ArrayList<Integer> respondIdList = new ArrayList<Integer>();

	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	int counter = 0;
	Scanner sc = new Scanner(System.in);

	public boolean getRespondedList() {
		logger.info("\nList of Responded Id with Titles :\n");
		for (RespondInfoBean respondInfoBean : respondList) {
			if ((respondInfoBean.getRespondAnswer10() != null)) {
				String str = respondInfoBean.getRespondTitle();
				int id = respondInfoBean.getRespondId();
				respondIdList.add(id);
				respondTitleList.add(str);
			}
		}
		int n = 0;
		for (int i = 0; i < respondTitleList.size(); i++) {
			n++;
			logger.info(n + ". "+respondIdList.get(i) +" , "+ respondTitleList.get(i));
		}
		return true;
	}

	public boolean getPendingRespondList() {
		logger.info("\nList of Pending Responds Id with Titles :\n");
		for (RespondInfoBean respondInfoBean : respondList) {
			if ((respondInfoBean.getRespondAnswer10() == null)) {
				String str = respondInfoBean.getRespondTitle();
				int id = respondInfoBean.getRespondId();
				respondIdList.add(id);
				respondTitleList.add(str);
			}
		}
		int n = 0;
		for (int i = 0; i < respondTitleList.size(); i++) {
			n++;
			logger.info(n + ". "+respondIdList.get(i) +" , "+ respondTitleList.get(i));
		}
		return true;
	}
	
	public boolean addRespondId(RespondInfoBean respond) {
		Iterator<RespondInfoBean> respondInfoBean4 = respondList.iterator();

		logger.info("\nEnter respondent Id to assign surveys::");
		String respondId1 = sc.next();
		while (!inputValidation.idValidation(respondId1)) {
			logger.error("please enter valid respond id");
			respondId1 = sc.next();
		}
		int respondId = Integer.parseInt(respondId1);
		while (respondInfoBean4.hasNext()) {
			RespondInfoBean compare2 = respondInfoBean4.next();

			if (compare2.getRespondId() == respondId) {
				counter++;
			}
		}
		if (counter == 0) {
			RespondInfoBean respondInfoBean = Factory.getRespondInfoBeanInstance();

			respondInfoBean.setRespondId(respondId);

			ArrayList<RespondInfoBean> list1 = new ArrayList<RespondInfoBean>();
			list1.add(respondInfoBean);

			respondList.addAll(list1);

			if (list1.isEmpty()) {
				logger.error("\nRespondId not added");
			} else {
				logger.info("\nRespondId is added");
			}
			return true;
		} else {
			logger.info("\nThis Id is already in use !!");
		}
		return false;
	}

	public List<RespondInfoBean> getAllResponds() {
		logger.info("Details of all responded and pending responds !!");
		for (RespondInfoBean respondInfoBean : respondList) {
			logger.info(respondInfoBean);
		}
		return respondList;
	}

	public boolean getListOfRespondTitle() {
		logger.info("Enter your ID to respond :");
		String respondId1;
		respondId1 = sc.next();

		while (!inputValidation.idValidation(respondId1)) {
			logger.info("Please Enter Valid respondent ID ");
			respondId1 = sc.next();
		}
		int respondId = Integer.parseInt(respondId1);
		for (RespondInfoBean respondInfoBean : respondList) {

			if (respondInfoBean.getRespondId() == respondId) {
				counter++;
			}
		}
		if (counter != 0) {
			logger.info("\nYou can respond to the surveys mentioned below : \n");

			for (RespondInfoBean respondInfoBean : respondList) {
				if (respondInfoBean.getRespondId() == respondId) {

				String str = respondInfoBean.getRespondTitle();
				respondTitleList.add(str);
				}
			}
			int n = 0;
			for (int i = 0; i < respondTitleList.size(); i++) {
				n++;
				logger.info(n + "." + respondTitleList.get(i));
			}
			return true;
		} else {
			throw new NotFoundException("RespondentId doesn't exists");
		}
	}

	public boolean addRespondTitle(RespondInfoBean respond) {
		logger.info("\nEnter respective respondent ID again:");
		String respondId1;
		respondId1 = sc.next();

		while (!inputValidation.idValidation(respondId1)) {
			logger.info("Please Enter Valid respondent ID ");
			respondId1 = sc.next();
		}
		int respondId = Integer.parseInt(respondId1);

		for (RespondInfoBean respondInfoBean : respondList) {

			if (respondInfoBean.getRespondId() == respondId) {
				counter++;
			}
		}
		if (counter != 0) {
			SurveyService surveyService5 = Factory.getSurveyServiceInstance();
			surveyService5.validateGetListOfTitle();
			
			for (RespondInfoBean respondInfoBean : respondList) {

				if (respondInfoBean.getRespondId() == respondId) {
					logger.info("\nNow enter survey title from above list to distribute to correspondent respondent :");

					sc.nextLine();
					String respondTitle = sc.nextLine();
					while (!inputValidation.titleValidation(respondTitle)) {
						logger.info("Please enter valid title name ");
						respondTitle = sc.nextLine();
					}
					respondInfoBean.setRespondTitle(respondTitle);
					logger.info("\nSurvey distributed !!\n");
				}
			}
			return true;
		} else {
			throw new NotFoundException("RespondentId doesn't exists");
		}
	}

	public boolean addRespondQuestions(RespondInfoBean respond) {
		logger.info("\nEnter survey title from above list to respond :");
		String respondTitle1;
		respondTitle1 = sc.nextLine();

		while (!inputValidation.titleValidation(respondTitle1)) {
			logger.info("Please Enter Valid responding title ");
			respondTitle1 = sc.nextLine();
		}

		for (RespondInfoBean respondInfoBean : respondList) {

			if (respondInfoBean.getRespondTitle().equals(respondTitle1)) {
				counter++;
			}
		}
		if (counter != 0) {
			for (RespondInfoBean respondInfoBean : respondList) {

				if (respondInfoBean.getRespondTitle().equals(respondTitle1)) {
					SurveyDao surveyDao = Factory.getSurveyDaoInstance();
					surveyDao.getSurveyQuestions(respondTitle1);
				}
			}

			for (RespondInfoBean respondInfoBean : respondList) {
				if (respondInfoBean.getRespondTitle().equals(respondTitle1)) {
					SurveyDaoImpl surveyDaoImpl = new SurveyDaoImpl();
					List<String> respondQuestionList = surveyDaoImpl.getSurveyQuestions(respondTitle1);

					for (int i = 0; i < respondQuestionList.size(); i++) {

						logger.info(respondQuestionList.get(i));
					}

					respondInfoBean.setRespondQuestion1(respondQuestionList.get(0));
					respondInfoBean.setRespondQuestion2(respondQuestionList.get(1));
					respondInfoBean.setRespondQuestion3(respondQuestionList.get(2));
					respondInfoBean.setRespondQuestion4(respondQuestionList.get(3));
					respondInfoBean.setRespondQuestion5(respondQuestionList.get(4));
					respondInfoBean.setRespondQuestion6(respondQuestionList.get(5));
					respondInfoBean.setRespondQuestion7(respondQuestionList.get(6));
					respondInfoBean.setRespondQuestion8(respondQuestionList.get(7));
					respondInfoBean.setRespondQuestion9(respondQuestionList.get(8));
					respondInfoBean.setRespondQuestion10(respondQuestionList.get(9));

				}
			}
			return true;
		} else {
			throw new NotFoundException("Survey Title doesn't exists");
		}
	}

	public boolean addRespondAnswers(RespondInfoBean respond) {
		logger.info("\nEnter correspondent survey title again to answer the above questions :");
		String respondTitle1;
		respondTitle1 = sc.nextLine();

		while (!inputValidation.titleValidation(respondTitle1)) {
			logger.info("Please Enter Valid responding title ");
			respondTitle1 = sc.nextLine();
		}

		for (RespondInfoBean respondInfoBean : respondList) {

			if (respondInfoBean.getRespondTitle().equals(respondTitle1)) {
				counter++;
			}
		}
		if (counter != 0) {
			for (RespondInfoBean respondInfoBean : respondList) {
				if (respondInfoBean.getRespondTitle().equals(respondTitle1)) {

					logger.info("\nEnter answer no.1 :");
					String answer1 = sc.nextLine();
					while (!inputValidation.answerValidation(answer1)) {
						logger.info("Please enter valid answer ");
						answer1 = sc.nextLine();
					}
					respondInfoBean.setRespondAnswer1(answer1);

					logger.info("\nEnter answer no.2 :");
					String answer2 = sc.nextLine();
					while (!inputValidation.answerValidation(answer2)) {
						logger.info("Please enter valid answer ");
						answer2 = sc.nextLine();
					}
					respondInfoBean.setRespondAnswer2(answer2);

					logger.info("\nEnter answer no.3 :");
					String answer3 = sc.nextLine();
					while (!inputValidation.answerValidation(answer3)) {
						logger.info("Please enter valid answer ");
						answer3 = sc.nextLine();
					}
					respondInfoBean.setRespondAnswer3(answer3);

					logger.info("\nEnter answer no.4 :");
					String answer4 = sc.nextLine();
					while (!inputValidation.answerValidation(answer4)) {
						logger.info("Please enter valid answer ");
						answer4 = sc.nextLine();
					}
					respondInfoBean.setRespondAnswer4(answer4);

					logger.info("\nEnter answer no.5 :");
					String answer5 = sc.nextLine();
					while (!inputValidation.answerValidation(answer5)) {
						logger.info("Please enter valid answer ");
						answer5 = sc.nextLine();
					}
					respondInfoBean.setRespondAnswer5(answer5);

					logger.info("\nEnter answer no.6 :");
					String answer6 = sc.nextLine();
					while (!inputValidation.answerValidation(answer6)) {
						logger.info("Please enter valid answer ");
						answer6 = sc.nextLine();
					}
					respondInfoBean.setRespondAnswer6(answer6);

					logger.info("\nEnter answer no.7 :");
					String answer7 = sc.nextLine();
					while (!inputValidation.answerValidation(answer7)) {
						logger.info("Please enter valid answer ");
						answer7 = sc.nextLine();
					}
					respondInfoBean.setRespondAnswer7(answer7);

					logger.info("\nEnter answer no.8 :");
					String answer8 = sc.nextLine();
					while (!inputValidation.answerValidation(answer8)) {
						logger.info("Please enter valid answer ");
						answer8 = sc.nextLine();
					}
					respondInfoBean.setRespondAnswer8(answer8);

					logger.info("\nEnter answer no.9 :");
					String answer9 = sc.nextLine();
					while (!inputValidation.answerValidation(answer9)) {
						logger.info("Please enter valid answer ");
						answer9 = sc.nextLine();
					}
					respondInfoBean.setRespondAnswer9(answer9);

					logger.info("\nEnter answer no.10 :");
					String answer10 = sc.nextLine();
					while (!inputValidation.answerValidation(answer10)) {
						logger.info("Please enter valid answer ");
						answer10 = sc.nextLine();
					}
					respondInfoBean.setRespondAnswer10(answer10);
					logger.info("\nRespond recorded successfully !!");
				}
			}
			return true;
		} else {
			throw new NotFoundException("Survey Title doesn't exists");
		}
	}

	public boolean getRespondedRecord() {
		logger.info("\nRecord of Responded Survey :\n");
		for (RespondInfoBean respondInfoBean : respondList) {
			if ((respondInfoBean.getRespondAnswer10() != null)) {
				logger.info(respondInfoBean);
			}
		}
		return true;
	}

	public boolean getPendingRecord() {
		logger.info("\nRecord of Responded Survey :\n");
		for (RespondInfoBean respondInfoBean : respondList) {
			if ((respondInfoBean.getRespondAnswer10() == null)) {
				logger.info(respondInfoBean);
			}
		}
		return true;
	}
}
