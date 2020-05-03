package com.capgemini.survey.dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.survey.beans.RespondentInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.validations.InputValidations;

public class RespondentDaoImpl implements RespondentDao {
	static List<RespondentInfoBean> respondentList = new ArrayList<RespondentInfoBean>();
	InputValidations inputValidation = Factory.getInputValidationInstance();
	RespondentInfoBean respondentInfoBean = Factory.getRespondentInfoBeanInstance();

	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	int counter = 0;
	Scanner sc = new Scanner(System.in);
	static {
		RespondentInfoBean respondentInfoBean1 = Factory.getRespondentInfoBeanInstance();
		respondentInfoBean1.setRespondentId(111);
		respondentInfoBean1.setRespondentName("Sneha");
		respondentInfoBean1.setRespondentEmail("Sneha05@gmail.com");
		respondentInfoBean1.setRespondentUserName("sneha0805_Ram");
		respondentInfoBean1.setRespondentPassword("SnR15@#215");
		respondentInfoBean1.setRespondentDob(LocalDate.of(1999, Month.AUGUST, 5));

		RespondentInfoBean respondentInfoBean2 = Factory.getRespondentInfoBeanInstance();
		respondentInfoBean2.setRespondentId(222);
		respondentInfoBean2.setRespondentName("Akash");
		respondentInfoBean2.setRespondentEmail("AksahR17@gmail.com");
		respondentInfoBean2.setRespondentUserName("Akash1709_Ram");
		respondentInfoBean2.setRespondentPassword("aK1@#857");
		respondentInfoBean2.setRespondentDob(LocalDate.of(1996, Month.SEPTEMBER, 17));

		RespondentInfoBean respondentInfoBean3 = Factory.getRespondentInfoBeanInstance();
		respondentInfoBean3.setRespondentId(333);
		respondentInfoBean3.setRespondentName("Shraddha");
		respondentInfoBean3.setRespondentEmail("ShraddhaRam03@gmail.com");
		respondentInfoBean3.setRespondentUserName("siddhi09_Ram");
		respondentInfoBean3.setRespondentPassword("riddhiSR@*9276");
		respondentInfoBean3.setRespondentDob(LocalDate.of(1999, Month.SEPTEMBER, 3));
		respondentList.add(respondentInfoBean1);
		respondentList.add(respondentInfoBean2);
		respondentList.add(respondentInfoBean3);

		for (RespondentInfoBean respondentInfoBean4 : respondentList) {
			logger.info("\n" + respondentInfoBean4);
		}
	}

	public boolean loginRespondent(RespondentInfoBean respondent) {

		logger.info("Enter Respondent UserName (e.g rams_san11):");
		String userName3;
		userName3 = sc.next();

		while (!inputValidation.userNameValidation(userName3)) {
			logger.info("Please enter valid respondent userName ");
			userName3 = sc.next();
		}

		logger.info("Enter Respondent Password (e.g Sa*@#$%!11):");
		String password3;
		password3 = sc.next();

		while (!inputValidation.passwordValidation(password3)) {
			logger.info("Please enter valid respondent password ");
			password3 = sc.next();
		}
		for (RespondentInfoBean respondentInfoBean : respondentList) {

			if ((respondentInfoBean.getRespondentUserName().equals(userName3))
					&& (respondentInfoBean.getRespondentPassword().equals(password3))) {
				counter++;
			}
		}
		if (counter != 0) {
			logger.info("Login Done");
			return true;
		} else
			logger.info("Invalid credentials please try again");
		return false;
	}

	public RespondentInfoBean getRespondent(int respondentID) {
		for (RespondentInfoBean respondentInfoBean : respondentList) {
			if (respondentInfoBean.getRespondentId() == respondentID) {
				counter++;
				logger.info("\nRespondent found !!");
				logger.info("\nGetting respondent details !!");
				List<RespondentInfoBean> searchRespondent = new ArrayList<RespondentInfoBean>();
				searchRespondent.add(respondentInfoBean);
				logger.info("\n" + searchRespondent);
			}
		}
		if (counter == 0) {
			throw new NotFoundException("Respondent doesn't exists");
		}
		return null;
	}

	public boolean addRespondent(RespondentInfoBean respondent) {

		Iterator<RespondentInfoBean> respondentInfoBean4 = respondentList.iterator();

		logger.info("Enter Respondent ID (range:00-9999):");
		String respondentId1 = sc.next();
		while (!inputValidation.idValidation(respondentId1)) {
			logger.error("please enter valid respondent id");
			respondentId1 = sc.next();
		}
		int respondentId = Integer.parseInt(respondentId1);
		while (respondentInfoBean4.hasNext()) {
			RespondentInfoBean compare2 = respondentInfoBean4.next();

			if (compare2.getRespondentId() == respondentId) {
				counter++;
			}
		}
		if (counter == 0) {
			RespondentInfoBean respondentInfoBean = Factory.getRespondentInfoBeanInstance();

			respondentInfoBean.setRespondentId(respondentId);

			logger.info("Enter Respondent Name :");
			sc.nextLine();
			String respondentName = sc.nextLine();

			while (!inputValidation.nameValidation(respondentName)) {
				logger.error("please enter valid respondent name");
				respondentName = sc.nextLine();
			}
			respondentInfoBean.setRespondentName(respondentName);

			logger.info("Enter Respondent Email (e.g ramsan11@gmail.com):");
			String respondentEmail = sc.next();
			while (!inputValidation.emailValidation(respondentEmail)) {
				logger.info("Please enter valid email ");
				respondentEmail = sc.next();
			}
			respondentInfoBean.setRespondentEmail(respondentEmail);

			logger.info("Enter Respondent UserName (e.g rams_san11):");
			String respondentUserName = sc.next();
			while (!inputValidation.userNameValidation(respondentUserName)) {
				logger.info("Please enter valid username ");
				respondentUserName = sc.next();
			}
			respondentInfoBean.setRespondentUserName(respondentUserName);

			logger.info("Enter Respondent Password (e.g Sa*@#$%!11):");
			String respondentPassword = sc.next();
			while (!inputValidation.passwordValidation(respondentPassword)) {
				logger.info("Please enter valid Password ");
				respondentPassword = sc.next();
			}
			respondentInfoBean.setRespondentPassword(respondentPassword);

			logger.info("Enter Respondent Date of birth (e.g yyyy/mm/dd):");
			String date = sc.next();
			while (!inputValidation.localDateValidation(date)) {
				logger.info("Please enter valid date of birth ");
				date = sc.next();
			}
			LocalDate respondentDob = LocalDate.parse(date);
			respondentInfoBean.setRespondentDob(respondentDob);

			ArrayList<RespondentInfoBean> list1 = new ArrayList<RespondentInfoBean>();
			list1.add(respondentInfoBean);

			respondentList.addAll(list1);

			if (list1.isEmpty()) {
				logger.error("\nRespondent not added");
			} else {
				logger.info("\nRespondent is added");
			}
			return true;
		} else {
			logger.info("\nRespondent already exists !!");
		}
		return false;
	}

	public boolean updateRespondent(RespondentInfoBean respondent) {

		logger.info("Enter Respondent ID (range:00-9999):");
		String respondentId1;
		respondentId1 = sc.next();

		while (!inputValidation.idValidation(respondentId1)) {
			logger.info("Please Enter Valid respondent ID ");
			respondentId1 = sc.next();
		}
		int respondentId = Integer.parseInt(respondentId1);

		for (RespondentInfoBean respondentInfoBean : respondentList) {

			if (respondentInfoBean.getRespondentId() == respondentId) {
				counter++;
			}
		}
		if (counter != 0) {
			for (RespondentInfoBean respondentInfoBean : respondentList) {

				if (respondentInfoBean.getRespondentId() == respondentId) {
					logger.info("Update Respondent Name :");
					sc.nextLine();
					String respondentName = sc.nextLine();
					while (!inputValidation.nameValidation(respondentName)) {
						logger.info("Please enter valid name ");
						respondentName = sc.nextLine();
					}
					respondentInfoBean.setRespondentName(respondentName);

					logger.info("Update Respondent Email (e.g ramsan11@gmail.com):");
					String respondentEmail = sc.next();
					while (!inputValidation.emailValidation(respondentEmail)) {
						logger.info("Please enter valid email ");
						respondentEmail = sc.next();
					}
					respondentInfoBean.setRespondentEmail(respondentEmail);

					logger.info("Update Respondent UserName (e.g rams_san11):");
					String respondentUserName = sc.next();
					while (!inputValidation.userNameValidation(respondentUserName)) {
						logger.info("Please enter valid username ");
						respondentUserName = sc.next();
					}
					respondentInfoBean.setRespondentUserName(respondentUserName);

					logger.info("Update Respondent Password (e.g Sa*@#$%!11):");
					String respondentPassword = sc.next();
					while (!inputValidation.passwordValidation(respondentPassword)) {
						logger.info("Please enter valid Password ");
						respondentPassword = sc.next();
					}
					respondentInfoBean.setRespondentPassword(respondentPassword);

					logger.info("Update Respondent Date of birth (e.g yyyy/mm/dd):");
					String date = sc.next();
					while (!inputValidation.localDateValidation(date)) {
						logger.info("Please enter valid date of birth ");
						date = sc.next();
					}
					LocalDate respondentDob = LocalDate.parse(date);
					respondentInfoBean.setRespondentDob(respondentDob);
					logger.info("\nRespondent Updated !!");
				}
			}
			return true;
		} else {
			throw new NotFoundException("Respondent doesn't exists");
		}
	}

	public boolean deleteRespondent(int respondentID) {
		Iterator<RespondentInfoBean> respondentInfoBean = respondentList.iterator();
		while (respondentInfoBean.hasNext()) {
			RespondentInfoBean itr1 = respondentInfoBean.next();
			if (itr1.getRespondentId() == respondentID) {
				counter++;
				respondentInfoBean.remove();
				logger.info("\nData deleted");
			}
		}
		if (counter == 0) {
			throw new NotFoundException("Respondent doesn't exists");
		}
		return true;
	}

	public List<RespondentInfoBean> getAllRespondents() {
		logger.info("Details of all Respondents !!");
		for (RespondentInfoBean respondentInfoBean : respondentList) {
			logger.info(respondentInfoBean);
		}
		return respondentList;
	}
}
