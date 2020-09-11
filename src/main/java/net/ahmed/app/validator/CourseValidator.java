/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.validator;

import net.ahmed.app.bll.service.CourseService;
import net.ahmed.app.dal.entity.Course;
import net.ahmed.app.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Ahmed Hafez
 */
@Component
public class CourseValidator implements Validator {

    @Autowired
    CourseService courseService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Course.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Course course = (Course) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.course.title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.course.description");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coursePic", "NotEmpty.course.picture");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.course.price");
        if (course.getDescription().length() < 50) {
            errors.rejectValue("description", "length.course.description");
        }
        if (course.getCoursePic().getOriginalFilename().trim().length() < 1) {
            errors.rejectValue("coursePic", "NotEmpty.course.picture");
        }
        if (course.getStartDate() == null) {
            errors.rejectValue("startDate", "NotValid.course.startDate");
        } else {
            if (!DateUtils.checkStartDate(DateUtils.convertToLocalDateViaInstant(course.getStartDate()))) {
                errors.rejectValue("startDate", "NotValid.course.invalidStartDate");
            }
        }
        if (course.getEndDate() == null) {
            errors.rejectValue("endDate", "NotValid.course.endDate");
        }
        if (course.getStartDate() != null && course.getEndDate() != null) {
            if (!DateUtils.compareStartEndDate(DateUtils.convertToLocalDateViaInstant(course.getStartDate()), DateUtils.convertToLocalDateViaInstant(course.getEndDate()))) {
                errors.rejectValue("endDate", "NotValid.course.invalidEndDate");
            }
        }

        if (course.getPrice() < 1) {
            errors.rejectValue("price", "Negative.course.price");
        }
        if (course.getCategory().getName().isEmpty() || course.getCategory().getName().trim().equals("")) {
            errors.rejectValue("category", "NotEmpty.course.category");
        }
    }

}
