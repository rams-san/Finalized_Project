package com.capgemini.survey.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.survey.dao.AdminDao;
import com.capgemini.survey.dao.AdminDaoImpl;
import com.capgemini.survey.dao.RespondentDao;
import com.capgemini.survey.dao.RespondentDaoImpl;
import com.capgemini.survey.dao.SurveyDao;
import com.capgemini.survey.dao.SurveyDaoImpl;
import com.capgemini.survey.dao.SurveyorDao;
import com.capgemini.survey.dao.SurveyorDaoImpl;
import com.capgemini.survey.exceptions.NotFoundException;
import com.capgemini.survey.factory.Factory;
import com.capgemini.survey.service.AdminService;
import com.capgemini.survey.service.RespondService;
import com.capgemini.survey.service.RespondentService;
import com.capgemini.survey.service.SurveyService;
import com.capgemini.survey.service.SurveyorService;
import com.capgemini.survey.validations.InputValidations;

public class SurveyController {
	static AdminDao adminDao = new AdminDaoImpl();
	static SurveyorDao surveyorDao = new SurveyorDaoImpl();
	static RespondentDao respondentDao = new RespondentDaoImpl();
	static SurveyDao surveyDao = new SurveyDaoImpl();
	public static org.apache.log4j.Logger logger = Logger.getLogger(SurveyController.class);

	public static void main(String[] args) {
		InputValidations inputValidation = Factory.getInputValidationInstance();

		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4 = true;

		do {
			Properties props = new Properties();
			try {
				props.load(new FileInputStream(
						"F:\\assesments\\survey-management-system\\src\\main\\java\\com\\capgemini\\survey\\controller\\db.properties"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String userName = props.getProperty("userName");
			String password = props.getProperty("password");

			System.out.println("\nUser Name : " + userName);
			System.out.println("Password : " + password);
			
			logger.info("\nChoose your option");
			logger.info("1. Admin Login");
			logger.info("2. Exit");
			String choice = sc.next();
			while (!inputValidation.choiceValidate(choice)) {
				logger.info("Please enter valid choice :");
				choice = sc.next();
			}
			try {
				int switchChoice = Integer.parseInt(choice);
				switch (switchChoice) {
				case 1:
					AdminService adminService = Factory.getAdminServiceInstance();
					boolean b = adminService.validateLoginAdmin(Factory.getAdminInfoBeanInstance());
					if (b) {
						logger.info("Admin login Successful !!");

						do {
							logger.info("\nInside Admin");
							logger.info("\nChoose your option");
							logger.info("1. Add Surveyor");
							logger.info("2. Add Respondent");
							logger.info("3. Login as Surveyor");
							logger.info("4. Login as Respondent");
							logger.info("5. Services");
							logger.info("6. logout");
							String choice1 = sc.next();
							while (!inputValidation.choice1Validate(choice1)) {
								logger.info("Please enter valid choice :");
								choice1 = sc.next();
							}
							try {
								int switchChoice1 = Integer.parseInt(choice1);
								switch (switchChoice1) {
								case 1:
									SurveyorService surveyorService = Factory.getSurveyorServiceInstance();
									surveyorService.validateAddSurveyor(Factory.getSurveyorInfoBeanInstance());
									break;
								case 2:
									RespondentService respondentService = Factory.getRespondentServiceInstance();
									respondentService.validateAddRespondent(Factory.getRespondentInfoBeanInstance());
									break;
								case 3:
									SurveyorService surveyorService1 = Factory.getSurveyorServiceInstance();
									boolean b1 = surveyorService1.validateLoginSurveyor(Factory.getSurveyorInfoBeanInstance());
									if (b1) {
										logger.info("Surveyor login Successful !!");

										do {
											logger.info("\nInside Surveyor");
											logger.info("\nChoose your option");
											logger.info("1. Create Survey");
											logger.info("2. Update Survey");
											logger.info("3. Delete Survey");
											logger.info("4. Get Survey Details");
											logger.info("5. Get All Survey Details");
											logger.info("6. Distribute Surveys");
											logger.info("7. Record of Responded surveys");
											logger.info("8. Record of Pending surveys");
											logger.info("9. Logout");
											String choice2 = sc.next();
											while (!inputValidation.choice2Validate(choice2)) {
												logger.info("Please enter valid choice :");
												choice2 = sc.next();
											}
											try {
												int switchChoice2 = Integer.parseInt(choice2);
												switch (switchChoice2) {
												case 1:
													SurveyService surveyService = Factory.getSurveyServiceInstance();
													surveyService.validateAddSurvey(Factory.getSurveyInfoBeanInstance());
													break;
												case 2:
													SurveyService surveyService1 = Factory.getSurveyServiceInstance();
													surveyService1.validateUpdateSurvey(Factory.getSurveyInfoBeanInstance());
													break;
												case 3:
													SurveyService surveyService2 = Factory.getSurveyServiceInstance();

													logger.info("Enter Survey Title : ");
													sc.nextLine();
													String title1 = sc.nextLine();
													surveyService2.validateDeleteSurvey(title1);
													break;
												case 4:
													SurveyService surveyService3 = Factory.getSurveyServiceInstance();

													logger.info("Enter Survey Title : ");
													sc.nextLine();
													String title = sc.nextLine();
													surveyService3.validateGetSurvey(title);
													break;
												case 5:
													SurveyService surveyService4 = Factory.getSurveyServiceInstance();
													surveyService4.validateGetAllSurveys();
													break;
												case 6:
													RespondService respondService = Factory.getRespondServiceInstance();
													if(respondService.validateAddRespondId(Factory.getRespondInfoBeanInstance())) {
													
													RespondService respondService1 = Factory.getRespondServiceInstance();
													respondService1.validateAddRespondTitle(Factory.getRespondInfoBeanInstance());
													}
													break;
												case 7:
													RespondService respondService2 = Factory.getRespondServiceInstance();
													respondService2.validateGetRespondedRecord();
													break;
												case 8:
													RespondService respondService3 = Factory.getRespondServiceInstance();
													respondService3.validateGetPendingRecord();
													break;
												case 9:
													logger.info("Logged out from Surveyor!");
													flag2 = false;
													break;
												default:
													flag2 = false;
													logger.info("Please enter correct option :");
												}
											} catch (NotFoundException e) {
												String s = e.getMessage();
												logger.error(s);
											}
										} while (flag2);
									} else {
										logger.error("Invalid username or password !");
									}
									break;
								case 4:
									RespondentService respondentService1 = Factory.getRespondentServiceInstance();
									boolean b2 = respondentService1.validateLoginRespondent(Factory.getRespondentInfoBeanInstance());
									if (b2) {
										logger.info("Respondent login Successful !!");

										do {
											logger.info("\nInside Respondent");
											logger.info("\nChoose your option");
											logger.info("1. Respond to a survey");
											logger.info("2. List of responded survey");
											logger.info("3. Logout");
											
											String choice3 = sc.next();
											while (!inputValidation.choice3Validate(choice3)) {
												logger.info("Please enter valid choice :");
												choice3 = sc.next();
											}
											try {
												int switchChoice3 = Integer.parseInt(choice3);
												switch (switchChoice3) {
												case 1:
													RespondService respondService = Factory.getRespondServiceInstance();
													respondService.validateGetListOfRespondTitle();
													break;
												case 2:
													RespondService respondService1 = Factory.getRespondServiceInstance();
													if(respondService1.validateGetListOfRespondTitle()) {
													
													RespondService respondService2 = Factory.getRespondServiceInstance();
													respondService2.validateAddRespondQuestions(Factory.getRespondInfoBeanInstance());
													
													RespondService respondService3 = Factory.getRespondServiceInstance();
													respondService3.validateAddRespondAnswers(Factory.getRespondInfoBeanInstance());
													}
													break;
												case 3:
													logger.info("Logged out from Respondent!");
													flag3 = false;
													break;
												default:
													flag3 = false;
													logger.info("Please enter correct option :");
												}
											} catch (NotFoundException e) {
												String s = e.getMessage();
												logger.error(s);
											}
										} while (flag3);
									} else {
										logger.error("Invalid username or password !");
									}
									break;
								case 5:
									do {
										logger.info("\nInside Admin Services");
										logger.info("\nChoose your option");
										logger.info("1. Update Surveyor");
										logger.info("2. Update Respondent");
										logger.info("3. Delete Surveyor");
										logger.info("4. Delete Respondent");
										logger.info("5. Get Surveyor Details");
										logger.info("6. Get Respondent Details");
										logger.info("7. Get All Surveyors Details");
										logger.info("8. Get All Respondents Details");
										logger.info("9. Create Survey");
										logger.info("10. Update Survey");
										logger.info("11. Delete Survey");
										logger.info("12. Get Survey Details");
										logger.info("13. Get All Survey Details");
										logger.info("14. Distribute Surveys");
										logger.info("15. Record of Responded surveys");
										logger.info("16. Record of Pending surveys");
										logger.info("17. Respond to a survey");
										logger.info("18. List of responded survey");
										logger.info("19. List of pending survey");
										logger.info("20. List of responded and pending surveys");
										logger.info("21. Exit");
										
										String choice4 = sc.next();
										while (!inputValidation.choice4Validate(choice4)) {
											logger.info("Please enter valid choice :");
											choice4 = sc.next();
										}
										try {
											int switchChoice4 = Integer.parseInt(choice4);
											switch (switchChoice4) {
											case 1:
												SurveyorService surveyorService2 = Factory.getSurveyorServiceInstance();
												surveyorService2.validateUpdateSurveyor(Factory.getSurveyorInfoBeanInstance());
												break;
											case 2:
												RespondentService respondentService2 = Factory.getRespondentServiceInstance();
												respondentService2.validateUpdateRespondent(Factory.getRespondentInfoBeanInstance());
												break;
											case 3:
												SurveyorService surveyorService3 = Factory.getSurveyorServiceInstance();

												logger.info("Enter Surveyor Id : ");
												String surveyorTitle1 = sc.next();
												surveyorService3.validateDeleteSurveyor(surveyorTitle1);
												break;
											case 4:
												RespondentService respondentService3 = Factory.getRespondentServiceInstance();

												logger.info("Enter Respondent Id : ");
												String respondentTitle1 = sc.next();
												respondentService3.validateDeleteRespondent(respondentTitle1);
												break;
											case 5:
												SurveyorService surveyorService4 = Factory.getSurveyorServiceInstance();

												logger.info("Enter Surveyor Id : ");
												String surveyorTitle2 = sc.next();
												surveyorService4.validateGetSurveyor(surveyorTitle2);
												break;
											case 6:
												RespondentService respondentService4 = Factory.getRespondentServiceInstance();

												logger.info("Enter Respondent Id : ");
												String respondentTitle2 = sc.next();
												respondentService4.validateGetRespondent(respondentTitle2);
												break;
											case 7:
												SurveyorService surveyorService5 = Factory.getSurveyorServiceInstance();
												surveyorService5.validateGetAllSurveyors();
												break;
											case 8:
												RespondentService respondentService5 = Factory.getRespondentServiceInstance();
												respondentService5.validateGetAllRespondents();
												break;
											case 9:
												SurveyService surveyService = Factory.getSurveyServiceInstance();
												surveyService.validateAddSurvey(Factory.getSurveyInfoBeanInstance());
												break;
											case 10:
												SurveyService surveyService1 = Factory.getSurveyServiceInstance();
												surveyService1.validateUpdateSurvey(Factory.getSurveyInfoBeanInstance());
												break;
											case 11:
												SurveyService surveyService2 = Factory.getSurveyServiceInstance();

												logger.info("Enter Survey Title : ");
												sc.nextLine();
												String title1 = sc.nextLine();
												surveyService2.validateDeleteSurvey(title1);
												break;
											case 12:
												SurveyService surveyService3 = Factory.getSurveyServiceInstance();

												logger.info("Enter Survey Title : ");
												sc.nextLine();
												String title = sc.nextLine();
												surveyService3.validateGetSurvey(title);
												break;
											case 13:
												SurveyService surveyService4 = Factory.getSurveyServiceInstance();
												surveyService4.validateGetAllSurveys();
												break;
											case 14:
												RespondService respondService = Factory.getRespondServiceInstance();
												if(respondService.validateAddRespondId(Factory.getRespondInfoBeanInstance())) {
												
												RespondService respondService1 = Factory.getRespondServiceInstance();
												respondService1.validateAddRespondTitle(Factory.getRespondInfoBeanInstance());
												}
												break;
											case 15:
												RespondService respondService2 = Factory.getRespondServiceInstance();
												respondService2.validateGetRespondedRecord();
												break;
											case 16:
												RespondService respondService3 = Factory.getRespondServiceInstance();
												respondService3.validateGetPendingRecord();
												break;
											case 17:
												RespondService respondService4 = Factory.getRespondServiceInstance();
												if(respondService4.validateGetListOfRespondTitle()) {
												
												RespondService respondService5 = Factory.getRespondServiceInstance();
												respondService5.validateAddRespondQuestions(Factory.getRespondInfoBeanInstance());
												
												RespondService respondService6 = Factory.getRespondServiceInstance();
												respondService6.validateAddRespondAnswers(Factory.getRespondInfoBeanInstance());
												}
												break;
											case 18:
												RespondService respondService7 = Factory.getRespondServiceInstance();
												respondService7.validateGetRespondedList();
												break;
											case 19:
												RespondService respondService8 = Factory.getRespondServiceInstance();
												respondService8.validateGetPendingRespondList();
												break;
											case 20:
												RespondService respondService9 = Factory.getRespondServiceInstance();
												respondService9.validateGetAllResponds();
												break;
											case 21:
												logger.info("\nExited from Admin Services");
												flag4 = false;
												break;
											default:
												flag4 = false;
												logger.info("Please enter correct option :");
											}
										} catch (NotFoundException e) {
											String s = e.getMessage();
											logger.error(s);
										}
									} while (flag4);
									break;
								case 6:
									logger.info("\nLogged out from Admin!");
									flag1 = false;
									break;
								default:
									flag1 = false;
									logger.info("Please enter correct option :");
								}
							} catch (NotFoundException e) {
								String s = e.getMessage();
								logger.error(s);
							}
						} while (flag1);
					} else {
						logger.error("Invalid username or password !");
					}
					break;
				case 2:
					logger.info("Exited !");
					flag = false;
					break;
				default:
					flag = false;
					logger.info("Please enter correct option :");
				}
			} catch (NotFoundException e) {
				String s = e.getMessage();
				logger.error(s);
			}
		} while (flag);
		sc.close();
	}
}
