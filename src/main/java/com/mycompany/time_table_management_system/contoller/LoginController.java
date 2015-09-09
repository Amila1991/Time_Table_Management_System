package com.mycompany.time_table_management_system.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	 @RequestMapping(value = "/logging")
	    public ModelAndView viewAdmin(){
	        ModelAndView model= new ModelAndView("login");
	        return model;
	    }
}
