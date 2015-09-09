package com.mycompany.time_table_management_system.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.time_table_management_system.componentconntroller.AutoGenerate;
import com.mycompany.time_table_management_system.db.doa.building.BuildingDAO;
import com.mycompany.time_table_management_system.db.doa.classroom.ClassroomDAO;
import com.mycompany.time_table_management_system.db.model.Building;
import com.mycompany.time_table_management_system.db.model.Classroom;

@RequestMapping(value = "/classroom")
@Controller
public class ClassroomController {

	@Autowired
	private BuildingDAO buildingDAO;
	@Autowired
	private ClassroomDAO classroomDAO;

	@RequestMapping(value = "/insertClassroom")
	public ModelAndView insertClassroomView() {
		ModelAndView model = new ModelAndView("insertclassroom");
		List<Building> buildingList = buildingDAO.getBuildingList();
		model.addObject("ClassroomID",AutoGenerate.getNextID(classroomDAO.getJdbcTemplate(), "Classroom", "Classroom_ID", "C"));
		model.addObject("BuildingList", buildingList);
		return model;
	}
	
	@RequestMapping(value = "/addClassroom", method=RequestMethod.POST)
    public ModelAndView insertClassroom(@ModelAttribute("classroom") Classroom classroom,@RequestParam("selectedBuilding") String name){
		Building building=new Building();
		building.setBuildingName(name);
    	classroom.setBuilding(buildingDAO.getBuilding(building, "Building_Name"));
		System.out.println(classroomDAO.insertClassroom(classroom));
        System.out.println(classroom.getClassroomId()+"          "+name+" ");
        return insertClassroomView().addObject("Success", "Operation is Successfully Completed....");
    }

}
