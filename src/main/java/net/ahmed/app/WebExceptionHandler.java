/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;
import net.ahmed.app.utils.RecordNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Ahmed Hafez
 */
@EnableWebMvc
@ControllerAdvice
public class WebExceptionHandler {
   	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle(Exception ex) {
	    return "redirect:/404";
	}
        @ExceptionHandler(RecordNotFoundException.class)
	public String handleRecordNotFound(Exception ex) {
            return "redirect:/400";
	}
        

	
}
