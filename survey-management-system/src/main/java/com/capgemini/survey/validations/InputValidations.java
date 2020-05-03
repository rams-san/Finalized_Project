package com.capgemini.survey.validations;

public interface InputValidations {
	public boolean idValidation(String id);
	
	public boolean nameValidation(String name);

	public boolean localDateValidation(String date);

	public boolean choiceValidate(String choice);
	
	public boolean choice1Validate(String choice1);
	
	public boolean choice2Validate(String choice1);
	
	public boolean choice3Validate(String choice1);
	
	public boolean choice4Validate(String choice1);

	public boolean emailValidation(String email);
	
	public boolean passwordValidation(String password);
	
	public boolean userNameValidation(String userName);
	
	public boolean titleValidation(String title); 
	
	public boolean descriptionValidation(String description);
	
	public boolean questionValidation(String question);
	
	public boolean answerValidation(String answer);
}