package com.baosight.library.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController { 

	  private static final String ERROR_PATH = "/error"; 

	@RequestMapping(value=ERROR_PATH) 
	public String handleError(){ 
	    return "login"; 
	} 

	@Override
	public String getErrorPath() { 
	      // TODO Auto-generated method stub 
	      return ERROR_PATH; 
	    } 

}
