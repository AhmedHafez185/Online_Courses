/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app;

import java.nio.file.AccessDeniedException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ahmed Hafez
 */
@ControllerAdvice("net.ahmed.app")
@Order(Ordered.LOWEST_PRECEDENCE)
public class WebExceptionHandler {
    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handleForbiddenException(AccessDeniedException exp){
        return new ModelAndView("error/403");
    }
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleForbiddenException(NotFoundException exp){
        return new ModelAndView("error/404");
    }
}
