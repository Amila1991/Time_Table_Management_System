/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.time_table_management_system.contoller;

import com.mycompany.time_table_management_system.componentconntroller.AutoGenerate;
import com.mycompany.time_table_management_system.db.doa.building.BuildingDAO;
import com.mycompany.time_table_management_system.db.model.Building;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Amila
 */
@RequestMapping("/building")
@Controller
public class BuildingController {
    
    @Autowired
    private BuildingDAO buildingDAO;
    
    @RequestMapping(value = "/viewBuilding")
    public ModelAndView viewBuilding(){
        List<Building> buildingList=buildingDAO.getBuildingList();
        ModelAndView model= new ModelAndView("home");
        model.addObject("BuildingList", buildingList);
        return model;
    }
    
    @RequestMapping(value = "/insertBuilding")
    public ModelAndView insertBuildingView(){
        ModelAndView model= new ModelAndView("insertbuilding");
        model.addObject("BuildingID", AutoGenerate.getNextID(buildingDAO.getJdbcTemplate(), "Building", "Building_ID", "B"));
        return model;
    }
    
    @RequestMapping(value = "/addBuilding", method=RequestMethod.POST)
    public ModelAndView insertBuilding(@ModelAttribute("building") Building building){
    	System.out.println(building.getBuildingId()+"          "+building.getBuildingName());
    	System.out.println(buildingDAO.insertBuilding(building));
        return insertBuildingView().addObject("Success", "Operation is Successfully Completed....");
    }
    
   /* @RequestMapping(value = "/addBuilding", method=RequestMethod.POST)
    public ModelAndView insertBuilding(@RequestParam("buildingName") String name,@RequestParam("buildingId") String id){
        ModelAndView model= new ModelAndView("insertbuilding");
        System.out.println(name+"          "+id);
        model.addObject("BuildingID", AutoGenerate.getNextID(buildingDAO.getJdbcTemplate(), "Building", "Building_ID", "B"));
        return model;
    }*/
}
