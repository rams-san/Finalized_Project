package com.capgemini.survey.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidationsImpl implements InputValidations {

	Pattern pat = null;
	Matcher mat = null;

	public boolean idValidation(String id) {
		pat = Pattern.compile("\\d{2,4}");
		mat = pat.matcher(id);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean nameValidation(String name) {
		pat = Pattern.compile("^[a-zA-Z a-zA-Z a-zA-Z]{2,30}$");
		mat = pat.matcher(name);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	public boolean localDateValidation(String date) {
		if (date.matches("^(\\d{4})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")) {
			return true;
		}
		return false;
	}

	public boolean choiceValidate(String choice) {
		pat = Pattern.compile("[1-2]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean choice1Validate(String choice1) {
		pat = Pattern.compile("[1-6]");
		mat = pat.matcher(choice1);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean choice2Validate(String choice1) {
		pat = Pattern.compile("[1-9]");
		mat = pat.matcher(choice1);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	public boolean choice3Validate(String choice1) {
		pat = Pattern.compile("[1-3]");
		mat = pat.matcher(choice1);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean choice4Validate(String choice1) {
		pat = Pattern.compile("([1-9]|1[1-9]|2[0-1])");
		mat = pat.matcher(choice1);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean emailValidation(String email) {
		pat = Pattern.compile("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
		mat = pat.matcher(email);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	public boolean passwordValidation(String password) {
		pat = Pattern.compile("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[*@#$%!]).{8,40})");
		mat = pat.matcher(password);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	public boolean userNameValidation(String userName) {
		pat = Pattern.compile("[A-Za-z0-9_]{1,20}");
		mat = pat.matcher(userName);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean titleValidation(String title) {
		pat = Pattern.compile("[a-zA-Z a-zA-Z]{1,20}");
		mat = pat.matcher(title);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean descriptionValidation(String description) {
		pat = Pattern.compile("[a-zA-Z .]*");
		mat = pat.matcher(description);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean questionValidation(String question) {
		pat = Pattern.compile("[a-zA-Z ?]{10,50}]*");
		mat = pat.matcher(question);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean answerValidation(String answer) {
		pat = Pattern.compile("([a-zA-Z .]{1,140}|[0-9][0-9])");
		mat = pat.matcher(answer);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
}
