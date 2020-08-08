package net.ahmed.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import net.ahmed.app.bll.service.InstructorService;
import net.ahmed.app.bll.service.LookupsService;
import net.ahmed.app.dal.entity.Instructor;
import net.ahmed.app.dal.entity.InstructorField;
import net.ahmed.app.utils.CoursesConstants;
import net.ahmed.app.validator.InstructorValidator;

@Controller
@RequestMapping(value = "/instructor")
public class InstructorController {
	@Autowired
	LookupsService fields;
	@Autowired
	InstructorService instructorService;
	@Autowired
	InstructorValidator instructorValidator;
	@GetMapping("/register")
    public String registerPage(Model model) {
		try {
			model.addAttribute("instructor", new Instructor());
	        return "instructor_register";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        model.addAttribute("errors", "Error : "+e.getMessage());
			return "instructor_register";
		}
        
    }
	@ModelAttribute
	public void commonData(Model model) {
		ArrayList<String> genderList = new ArrayList<>();
		genderList.add("Male");
		genderList.add("Female");
		model.addAttribute("genderList",genderList);
		 try {
			List<InstructorField> instructorsFields = fields.findAllInstructorField();
			model.addAttribute("instrFields",instructorsFields);
			
		} catch (Exception e) {
			List<InstructorField> instructorsFields = null;
		}
		
	}
	public InstructorField populateInstructorField(InstructorField instructorField) throws Exception {
		Integer fieldId = Integer.parseInt(instructorField.getName().trim());
		for(InstructorField instField : fields.findAllInstructorField()) {
			if(instField.getId()==fieldId) {
			return instField;
			}
		}
		return null;
	}
	@SuppressWarnings("null")
	@PostMapping("/registerProcess")
	public String registerProcess(@ModelAttribute("instructor")Instructor instructor,BindingResult result) {
		instructorValidator.validate(instructor, result);
		if(result.hasErrors()) {
			return "instructor_register";
		}else {
			MultipartFile multipartImage = instructor.getProfileImage();
			MultipartFile multipartCVFile = instructor.getUserCV();
	        if (multipartImage != null || !multipartImage.isEmpty() || multipartCVFile != null || !multipartCVFile.isEmpty()) {
	        	
	            String imagePath  =  CoursesConstants.IMAGES + multipartImage.getOriginalFilename();
	            String cvFilePath = CoursesConstants.CV_FILES + multipartCVFile.getOriginalFilename();

	            try {
	            	InstructorField instrField = populateInstructorField(instructor.getInstructorField());
	            	instructor.setInstructorField(instrField);
	            	multipartImage.transferTo(new File(imagePath));
	                instructor.setPhoto(multipartImage.getOriginalFilename());
	                multipartCVFile.transferTo(new File(cvFilePath));
	                instructor.setCvFile(multipartCVFile.getOriginalFilename());
	                instructorService.addInstructor(instructor);
	                return "login";
	            } catch (Exception e) {
	                result.rejectValue("photo", e.getMessage());
	                return "instructor_register";
	            }
	        }
	        result.rejectValue("profileImage","Errors !!!");
	        return "instructor_register";
		}
		
	}
	@GetMapping("/showLogin")
	public String ShowLogin(Model model) {
		model.addAttribute("Instructor",new Instructor());
		return "login";
	}
	
	
}
