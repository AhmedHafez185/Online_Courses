package net.ahmed.app.validator;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import net.ahmed.app.bll.service.InstructorService;
import net.ahmed.app.bll.service.StudentService;
import net.ahmed.app.bll.service.UserService;
import net.ahmed.app.dal.entity.Instructor;
import net.ahmed.app.dal.entity.Student;
import net.ahmed.app.utils.DateUtils;

@Component
public class studentValidator implements Validator{
	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	
        @Autowired
	       StudentService studentService;
        @Autowired
	       UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.InstructorForm.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.InstructorForm.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.InstructorForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "profileImage", "NotEmpty.InstructorForm.picture");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.InstructorForm.confirmPassword");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.InstructorForm.gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.InstructorForm.country");
		if(student.getBirthDate()==null) {
			errors.rejectValue("birthDate", "NotValid.InstructorForm.birthDate");
		}else {
			if(!DateUtils.compareBirthDateStudent(DateUtils.convertToLocalDateViaInstant(student.getBirthDate()))) {
				errors.rejectValue("birthDate", "NotValid.InstructorForm.invalidBirthDate");
			}
		}
		if(!emailValidator.valid(student.getEmail())){
			errors.rejectValue("email", "Pattern.InstructorForm.email");
		}	
		if(student.getPassword().length()<8 || student.getPassword().isEmpty() || student.getPassword().equals("")){
			errors.rejectValue("password", "NotEmpty.InstructorForm.password");
		}
		if (!student.getPassword().equals(student.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Diff.Instructorform.confirmPassword");
		}
		
		if(student.getProfileImage().getOriginalFilename().trim().length()<1) {
			errors.rejectValue("profileImage","NotEmpty.InstructorForm.profileImage");
		}
		try {
			if (userService.checkEmail(student.getEmail())) {
				errors.rejectValue("email", "Exists.InstructorForm.email");
			}
		} catch (Exception e) {
			errors.rejectValue("email", e.getMessage());
		}
	}
}
