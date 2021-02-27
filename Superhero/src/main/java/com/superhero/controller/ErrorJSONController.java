package com.superhero.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.superhero.model.response.Response;
import com.superhero.model.response.message.ErrorMessage;
import com.superhero.model.response.message.ErrorMessage.EDescription;

@ControllerAdvice(annotations=RestController.class)
public class ErrorJSONController {
	 private static final Logger logger = LoggerFactory.getLogger(ErrorJSONController.class);
	    
	    @ExceptionHandler
	    @ResponseBody
	    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	    public Response handleException(Exception ex, HttpServletRequest request) {
	        logger.info("Exception executing Hiberus API. More information:");
	        logger.error(ex.getMessage());
	  
	        StringWriter sw = new StringWriter();
	        ex.printStackTrace(new PrintWriter(sw));
	  
	        return new Response(null, new ErrorMessage(EDescription.ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value() +"-" + ex.getMessage()), false);

	    }
}
