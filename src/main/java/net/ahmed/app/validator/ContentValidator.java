/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.validator;

import net.ahmed.app.bll.service.ContentService;
import net.ahmed.app.bll.service.CourseService;
import net.ahmed.app.dal.entity.Content;
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
public class ContentValidator implements Validator {

    @Autowired
    ContentService contentService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Content.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Content content = (Content) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.content.title");
        if (content.getDescription().length() < 50 || content.getDescription().isEmpty() || content.getDescription() == null) {
            errors.rejectValue("description", "length.content.description");
        }
        if (content.getLessonVideo().getOriginalFilename().trim().length() < 1) {
            errors.rejectValue("lessonVideo", "NotEmpty.content.lesson");
        }
        if (content.getTopicId() == null || content.getTopicId().isEmpty() || content.getTopicId().length() < 1) {
            errors.rejectValue("topicId", "NotEmpty.content.topic");
        }
    }

}
