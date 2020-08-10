package net.ahmed.app.validator;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import net.ahmed.app.bll.service.InstructorService;
import net.ahmed.app.bll.service.UserService;
import net.ahmed.app.dal.entity.Instructor;
import net.ahmed.app.utils.DateUtils;

@Component
public class InstructorValidator implements Validator{
	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	
        @Autowired
	InstructorService instructorService;
        @Autowired
	       UserService userService;
	
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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instructorField", "NotEmpty.InstructorForm.instructorField");		
		if(instructor.getBirthDate()==null) {
			errors.rejectValue("birthDate", "NotValid.InstructorForm.birthDate");
		}else {
			if(!DateUtils.compareBirthDate(DateUtils.convertToLocalDateViaInstant(instructor.getBirthDate()))) {
				errors.rejectValue("birthDate", "NotValid.InstructorForm.invalidBirthDate");
			}
		}
		if(!emailValidator.valid(instructor.getEmail())){
			errors.rejectValue("email", "Pattern.InstructorForm.email");
		}
		if(instructor.getDescription().length()<50){
			errors.rejectValue("description", "NotEmpty.InstructorForm.description");
		}
		if(instructor.getInstructorField().getName().isEmpty() || instructor.getInstructorField().getName().trim().equals("")){
			errors.rejectValue("instructorField", "NotEmpty.InstructorForm.instructorField");
		}
		if(instructor.getPassword().length()<8 || instructor.getPassword().isEmpty() || instructor.getPassword().equals("")){
			errors.rejectValue("password", "NotEmpty.InstructorForm.password");
		}
		if(instructor.getYearOfExp()==null || instructor.getYearOfExp()<=0){
			errors.rejectValue("yearOfExp", "NotEmpty.InstructorForm.yearOfExp");
		}
		
		if (!instructor.getPassword().equals(instructor.getConfrimPassword())) {
			errors.rejectValue("confrimPassword", "Diff.Instructorform.confirmPassword");
		}
		if(instructor.getUserCV().getOriginalFilename().trim().length()<1) {
			errors.rejectValue("userCV","NotEmpty.InstructorForm.cvFile");
		}
		if(instructor.getProfileImage().getOriginalFilename().trim().length()<1) {
			errors.rejectValue("profileImage","NotEmpty.InstructorForm.profileImage");
		}
		try {
			if (userService.checkEmail(instructor.getEmail())) {
				errors.rejectValue("email", "Exists.InstructorForm.email");
			}
		} catch (Exception e) {
			errors.rejectValue("email", e.getMessage());
		}
	}
}
