package com.cts.cit.exception;



import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
//import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;





@Controller
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(ApplicationException.class)

	public String handleException(ApplicationException error, Model model) {
		model.addAttribute("msg", error.getMessage());
		return "error1";
	}	
	@ExceptionHandler(NumberFormatException.class)
	public String handleMissingParams(NumberFormatException ex,Model model) {
	String name = "Enter value in text box";
	
	//System.out.println(name + " parameter is missing");
	model.addAttribute("msg", name);
	return "error1";
	// Actual exception handling
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex,Model model) {
	String name = "Enter value in text box";
	
	//System.out.println(name + " parameter is missing");
	model.addAttribute("msg", name);
	return "error1";
	// Actual exception handling
	}
	}

