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
import com.mycompany.time_table_management_system.db.doa.department.DepartmentDAO;
import com.mycompany.time_table_management_system.db.model.Building;
import com.mycompany.time_table_management_system.db.model.Classroom;
import com.mycompany.time_table_management_system.db.model.Department;

@RequestMapping(value = "/department")
@Controller
public class DepartmentController {

	@Autowired
	private BuildingDAO buildingDAO;
	@Autowired
	private DepartmentDAO departmentDAO;

	@RequestMapping(value = "/insertDepartment")
	public ModelAndView insertDepartmentView() {
		ModelAndView model = new ModelAndView("insertdepartment");
		List<Building> buildingList = buildingDAO.getBuildingList();
		model.addObject("DepartmentID",AutoGenerate.getNextID(departmentDAO.getJdbcTemplate(), "Department", "Department_ID", "D"));
		model.addObject("BuildingList", buildingList);
		return model;
	}
	
	@RequestMapping(value = "/addDepartment", method=RequestMethod.POST)
    public ModelAndView insertDepartment(@ModelAttribute("department") Department department,@RequestParam("selectedBuilding") String name){
		Building building=new Building();
		building.setBuildingName(name);
    	department.setBuilding(buildingDAO.getBuilding(building, "Building_Name"));
		System.out.println(departmentDAO.insertDepartment(department));
        System.out.println(department.getDepartmentId()+"          "+name+" ");
        return insertDepartmentView().addObject("Success", "Operation is Successfully Completed....");
    }
}
