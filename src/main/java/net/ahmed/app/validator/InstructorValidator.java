package net.ahmed.app.validator;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import net.ahmed.app.bll.service.InstructorService;
import net.ahmed.app.dal.entity.Instructor;

@Component
public class InstructorValidator implements Validator{
	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	
	@Autowired
	InstructorService instructorService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Instructor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Instructor instructor = (Instructor) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.InstructorForm.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.InstructorForm.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.InstructorForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "profileImage", "NotEmpty.InstructorForm.picture");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userCV", "NotEmpty.InstructorForm.cvFile");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confrimPassword","NotEmpty.InstructorForm.confirmPassword");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.InstructorForm.gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.InstructorForm.country");
		
		if(instructor.getBirthDate()==null) {
			errors.rejectValue("birthDate", "NotValid.InstructorForm.birthDate");
		}
		if(!emailValidator.valid(instructor.getEmail())){
			errors.rejectValue("email", "Pattern.InstructorForm.email");
		}
	
		if(instructor.getGender().equals("notSelected")){
			errors.rejectValue("gender", "NotEmpty.InstructorForm.gender");
		}
		if(instructor.getDescription().length()<50){
			errors.rejectValue("description", "NotEmpty.InstructorForm.description");
		}
		if(instructor.getPassword().length()<8 || instructor.getPassword().isEmpty() || instructor.getPassword().equals("")){
			errors.rejectValue("description", "NotEmpty.InstructorForm.password");
		}
		if(instructor.getYearOfExp()==null || instructor.getYearOfExp()<=0){
			errors.rejectValue("yearOfExp", "NotEmpty.InstructorForm.yearOfExp");
		}
		
		if (!instructor.getPassword().equals(instructor.getConfrimPassword())) {
			errors.rejectValue("confrimPassword", "Diff.Instructorform.confirmPassword");
		}
		
		try {
			if (instructorService.checkEmail(instructor.getEmail())) {
				errors.rejectValue("email", "Exists.InstructorForm.email");
			}
		} catch (Exception e) {
			errors.rejectValue("email", e.getMessage());
		}
	}
}
