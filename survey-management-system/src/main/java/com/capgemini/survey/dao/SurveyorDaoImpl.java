package com.capgemini.survey.dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.survey.beans.SurveyorInfoBean;
import com.capgemini.survey.controller.SurveyController;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.validations.InputValidations;

public class SurveyorDaoImpl implements SurveyorDao {
	static List<SurveyorInfoBean> surveyorList = new ArrayList<SurveyorInfoBean>();
	InputValidations inputValidation = Factory.getInputValidationInstance();
	SurveyorInfoBean surveyorInfoBean = Factory.getSurveyorInfoBeanInstance();

	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);
	int counter = 0;
	Scanner sc = new Scanner(System.in);
	static {
		SurveyorInfoBean surveyorInfoBean1 = Factory.getSurveyorInfoBeanInstance();
		surveyorInfoBean1.setSurveyorId(1111);
		surveyorInfoBean1.setSurveyorName("Suyash");
		surveyorInfoBean1.setSurveyorEmail("Suyash788@gmail.com");
		surveyorInfoBean1.setSurveyorUserName("suyash788_Ram");
		surveyorInfoBean1.setSurveyorPassword("Sr@132357");
		surveyorInfoBean1.setSurveyorDob(LocalDate.of(1997, Month.MAY, 11));

		SurveyorInfoBean surveyorInfoBean2 = Factory.getSurveyorInfoBeanInstance();
		surveyorInfoBean2.setSurveyorId(2222);
		surveyorInfoBean2.setSurveyorName("Surya");
		surveyorInfoBean2.setSurveyorEmail("Surya0417@gmail.com");
		surveyorInfoBean2.setSurveyorUserName("surya45_Gattu");
		surveyorInfoBean2.setSurveyorPassword("gS#@*21551");
		surveyorInfoBean2.setSurveyorDob(LocalDate.of(1998, Month.APRIL, 17));

		SurveyorInfoBean surveyorInfoBean3 = Factory.getSurveyorInfoBeanInstance();
		surveyorInfoBean3.setSurveyorId(3333);
		surveyorInfoBean3.setSurveyorName("Nicks");
		surveyorInfoBean3.setSurveyorEmail("Nicks09@gmail.com");
		surveyorInfoBean3.setSurveyorUserName("nikhil_06P");
		surveyorInfoBean3.setSurveyorPassword("Pn@215225#*");
		surveyorInfoBean3.setSurveyorDob(LocalDate.of(1997, Month.JUNE, 8));

		surveyorList.add(surveyorInfoBean1);
		surveyorList.add(surveyorInfoBean2);
		surveyorList.add(surveyorInfoBean3);
		
		for (SurveyorInfoBean surveyorInfoBean4 : surveyorList) {
			logger.info("\n"+surveyorInfoBean4);
		}
	}

	public boolean loginSurveyor(SurveyorInfoBean surveyor) {

		logger.info("Enter Surveyor UserName (e.g rams_san11):");
		String userName2;
		userName2 = sc.next();

		while (!inputValidation.userNameValidation(userName2)) {
			logger.info("Please Enter Valid surveyor userName ");
			userName2 = sc.next();
		}

		logger.info("Enter Surveyor Password (e.g Sa*@#$%!11):");
		String password2;
		password2 = sc.next();

		while (!inputValidation.passwordValidation(password2)) {
			logger.info("Please Enter Valid Surveyor password ");
			password2 = sc.next();
		}
		for (SurveyorInfoBean surveyorInfoBean : surveyorList) {

			if ((surveyorInfoBean.getSurveyorUserName().equals(userName2))
					&& (surveyorInfoBean.getSurveyorPassword().equals(password2))) {
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

	public SurveyorInfoBean getSurveyor(int surveyorID) {
		for (SurveyorInfoBean surveyorInfoBean : surveyorList) {
			if (surveyorInfoBean.getSurveyorId() == surveyorID) {

				counter++;
				logger.info("\nSurveyor Found");
				logger.info("\nGetting surveyor details !!");
				List<SurveyorInfoBean> searchSurveyor = new ArrayList<SurveyorInfoBean>();
				searchSurveyor.add(surveyorInfoBean);
				logger.info("\n"+searchSurveyor);
			}
		}
		if (counter == 0) {
			throw new NotFoundException("Surveyor doesn't exists !!");
		}
		return null;
	}

	public boolean addSurveyor(SurveyorInfoBean surveyor) {

		Iterator<SurveyorInfoBean> surveyorInfoBean4 = surveyorList.iterator();
		logger.info("Enter Surveyor ID (range:00-9999) :");
		String surveyorId1 = sc.next();
		while (!inputValidation.idValidation(surveyorId1)) {
			logger.error("please enter valid surveyor id");
			surveyorId1 = sc.next();
		}
		int surveyorId = Integer.parseInt(surveyorId1);
		while (surveyorInfoBean4.hasNext()) {
			SurveyorInfoBean compare1 = surveyorInfoBean4.next();

			if (compare1.getSurveyorId() == surveyorId) {
				counter++;
			}
		}
		if (counter == 0) {
			SurveyorInfoBean surveyorInfoBean = Factory.getSurveyorInfoBeanInstance();
			surveyorInfoBean.setSurveyorId(surveyorId);
			logger.info("Enter Surveyor Name :");
			sc.nextLine();
			String surveyorName = sc.nextLine();
			while (!inputValidation.nameValidation(surveyorName)) {
				logger.error("please enter valid surveyor name");
				surveyorName = sc.nextLine();
			}
			surveyorInfoBean.setSurveyorName(surveyorName);

			logger.info("Enter Surveyor Email (e.g ramsan11@gmail.com):");
			String surveyorEmail = sc.next();
			while (!inputValidation.emailValidation(surveyorEmail)) {
				logger.info("Please enter valid email ");
				surveyorEmail = sc.next();
			}
			surveyorInfoBean.setSurveyorEmail(surveyorEmail);

			logger.info("Enter Surveyor UserName (e.g rams_san11):");
			String surveyorUserName = sc.next();
			while (!inputValidation.userNameValidation(surveyorUserName)) {
				logger.info("Please enter valid username ");
				surveyorUserName = sc.next();
			}
			surveyorInfoBean.setSurveyorUserName(surveyorUserName);

			logger.info("Enter Surveyor Password (e.g Sa*@#$%!11):");
			String surveyorPassword = sc.next();
			while (!inputValidation.passwordValidation(surveyorPassword)) {
				logger.info("Please enter valid Password ");
				surveyorPassword = sc.next();
			}
			surveyorInfoBean.setSurveyorPassword(surveyorPassword);

			logger.info("Enter Surveyor Date of birth (e.g yyyy/mm/dd):");
			String date = sc.next();
			while (!inputValidation.localDateValidation(date)) {
				logger.info("Please enter valid date of birth ");
				date = sc.next();
			}
			LocalDate surveyorDob = LocalDate.parse(date);
			surveyorInfoBean.setSurveyorDob(surveyorDob);

			ArrayList<SurveyorInfoBean> list = new ArrayList<SurveyorInfoBean>();
			list.add(surveyorInfoBean);

			surveyorList.addAll(list);

			if (list.isEmpty()) {
				logger.error("Surveyor not added");

			} else {
				logger.info("\nSurveyor is added \n");
			}
			return true;
		} else {
			logger.info("Surveyor already exists !!");
		}
		return false;
	}

	public boolean updateSurveyor(SurveyorInfoBean surveyor) {

		logger.info("Enter Surveyor ID (range:00-9999) :");
		int surveyorId;
		surveyorId = sc.nextInt();

		while (!inputValidation.idValidation(Integer.toString(surveyorId))) {
			logger.info("Please Enter Valid surveyor ID ");
			surveyorId = sc.nextInt();
		}
		for (SurveyorInfoBean surveyorInfoBean : surveyorList) {

			if (surveyorInfoBean.getSurveyorId() == surveyorId) {
				counter++;
			}
		}
		if (counter != 0) {

			for (SurveyorInfoBean surveyorInfoBean : surveyorList) {

				if (surveyorInfoBean.getSurveyorId() == surveyorId) {
					logger.info("Update Surveyor Name :");
					sc.nextLine();
					String surveyorName = sc.nextLine();
					while (!inputValidation.nameValidation(surveyorName)) {
						logger.info("Please enter valid name ");
						surveyorName = sc.nextLine();
					}
					surveyorInfoBean.setSurveyorName(surveyorName);

					logger.info("Update Surveyor Email (e.g ramsan11@gmail.com) :");
					String surveyorEmail = sc.next();
					while (!inputValidation.emailValidation(surveyorEmail)) {
						logger.info("Please enter valid email ");
						surveyorEmail = sc.next();
					}
					surveyorInfoBean.setSurveyorEmail(surveyorEmail);

					logger.info("Update Surveyor UserName (e.g rams_san11):");
					String surveyorUserName = sc.next();
					while (!inputValidation.userNameValidation(surveyorUserName)) {
						logger.info("Please enter valid username ");
						surveyorUserName = sc.next();
					}
					surveyorInfoBean.setSurveyorUserName(surveyorUserName);

					logger.info("Update Surveyor Password (e.g Sa*@#$%!11):");
					String surveyorPassword = sc.next();
					while (!inputValidation.passwordValidation(surveyorPassword)) {
						logger.info("Please enter valid Password ");
						surveyorPassword = sc.next();
					}
					surveyorInfoBean.setSurveyorUserName(surveyorPassword);

					logger.info("Update Surveyor Date of birth (e.g yyyy/mm/dd):");
					String date = sc.next();
					while (!inputValidation.localDateValidation(date)) {
						logger.info("Please enter valid date of birth ");
						date = sc.next();
					}
					LocalDate surveyorDob = LocalDate.parse(date);
					surveyorInfoBean.setSurveyorDob(surveyorDob);
					logger.info("\nSurveyor Updated !!");
				}
			}
			return true;
		} else {
			throw new NotFoundException("Surveyor doesn't exists !!");
		}
	}

	public boolean deleteSurveyor(int surveyorID) {
		Iterator<SurveyorInfoBean> surveyorInfoBean = surveyorList.iterator();
		while (surveyorInfoBean.hasNext()) {
			SurveyorInfoBean itr1 = surveyorInfoBean.next();
			if (itr1.getSurveyorId() == surveyorID) {
				counter++;
				surveyorInfoBean.remove();
				logger.info("\nData deleted");
			}
		}
		if (counter == 0) {
			throw new NotFoundException("Surveyor doesn't exists !!");
		}
		return true;
	}

	public List<SurveyorInfoBean> getAllSurveyors() {
		logger.info("Details of all Surveyors !!");
		for (SurveyorInfoBean surveyorInfoBean : surveyorList) {
			logger.info(surveyorInfoBean);
		}
		return surveyorList;
	}
}
