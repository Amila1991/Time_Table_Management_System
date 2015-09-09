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
import com.mycompany.time_table_management_system.db.doa.module.ModuleDAO;
import com.mycompany.time_table_management_system.db.model.Building;
import com.mycompany.time_table_management_system.db.model.Classroom;
import com.mycompany.time_table_management_system.db.model.Department;
import com.mycompany.time_table_management_system.db.model.Module;

@RequestMapping("/module")
@Controller
public class ModuleController {
	
	@Autowired
	private ModuleDAO moduleDAO;
	@Autowired
	private DepartmentDAO departmentDAO;

	@RequestMapping(value = "/insertModule")
	public ModelAndView insertModuleView() {
		ModelAndView model = new ModelAndView("insertmodule");
		List<Department> departmentList = departmentDAO.getDepartmentList();
		model.addObject("DepartmentList", departmentList);
		return model;
	}
	
	@RequestMapping(value = "/addModule", method=RequestMethod.POST)
    public ModelAndView insertModule(@ModelAttribute("module")Module module,@RequestParam("selectedDepartment") String name){
	    	System.out.println(module.getModuleNo()+module.getModuleTitle()+module.getCredit()+"          "+name);
	    	Department department=new Department();
	    	department.setDepartmentName(name);
	    	module.setDepartmentId(departmentDAO.getDepartment(department, "Department_Name").getDepartmentId());
	    	if(moduleDAO.insertModule(module)){
	    		return insertModuleView().addObject("Success", "Operation is Successfully Completed....");
	    	}
	    	return insertModuleView().addObject("Success", "Operation is Incompleted. Please try agian....");
    }

}
