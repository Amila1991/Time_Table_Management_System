/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.time_table_management_system.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Amila
 */
@Controller
public class AdminController {

    
    @RequestMapping(value = "/admin")
    public ModelAndView viewAdmin(){
        ModelAndView model= new ModelAndView("admin");
        return model;
    }
}
