package net.ahmed.app.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

public class Validation {	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	public static boolean validateEmailPattern(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public static boolean validateInput(String input) {
		if (input.isEmpty() || input == null || input.equals(""))
			return true;
		return false;
	}
	public boolean validatePassword(String password1,String password2) {
		if(password1.equals(password2))
			return true;
		return false;
	}
}
