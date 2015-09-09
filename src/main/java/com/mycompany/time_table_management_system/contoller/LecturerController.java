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
import com.mycompany.time_table_management_system.db.doa.department.DepartmentDAO;
import com.mycompany.time_table_management_system.db.doa.lecturer.LecturerDAO;
import com.mycompany.time_table_management_system.db.model.Department;
import com.mycompany.time_table_management_system.db.model.Lecturer;


@RequestMapping(value="/lecturer")
@Controller
public class LecturerController {

	@Autowired
    private LecturerDAO lecturerDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
    
    @RequestMapping(value = "/viewLecturer")
    public ModelAndView viewLecturer(){
        List<Lecturer> lecturerList=lecturerDAO.getLecturerList();
        ModelAndView model= new ModelAndView("viewlecturer");
        model.addObject("LecturerList", lecturerList);
        return model;
    }
    
    @RequestMapping(value = "/insertLecturer")
    public ModelAndView insertLecturerView(){
        ModelAndView model= new ModelAndView("insertlecturer");
        List<Department> departmentList = departmentDAO.getDepartmentList();
		model.addObject("DepartmentList", departmentList);
        model.addObject("LecturerID", AutoGenerate.getNextID(lecturerDAO.getJdbcTemplate(), "Lecturer", "Lecturer_ID", "L"));
        return model;
    }
    
    @RequestMapping(value = "/addLecturer", method=RequestMethod.POST)
    public ModelAndView insertLecturer(@ModelAttribute("lecturer") Lecturer lecturer,@RequestParam("selectedDepartment") String name){
    	System.out.println(lecturer.getLecturerId()+"          "+name);
    	Department department=new Department();
    	department.setDepartmentName(name);
    	lecturer.setDepartment(departmentDAO.getDepartment(department, "Department_Name"));
    	if(lecturerDAO.insertLecturer(lecturer)){
    		return insertLecturerView().addObject("Success", "Operation is Successfully Completed....");
    	}
    	return insertLecturerView().addObject("Success", "Operation is Incompleted. Please try agian....");
    }
}
