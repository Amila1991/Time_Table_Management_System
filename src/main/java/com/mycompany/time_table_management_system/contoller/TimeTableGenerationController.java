package com.mycompany.time_table_management_system.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.time_table_management_system.db.doa.department.DepartmentDAO;
import com.mycompany.time_table_management_system.db.doa.lecturer.LecturerDAO;
import com.mycompany.time_table_management_system.db.doa.module.ModuleDAO;
import com.mycompany.time_table_management_system.db.doa.schedule.ScheduleDAO;
import com.mycompany.time_table_management_system.db.model.Batch;
import com.mycompany.time_table_management_system.db.model.Building;
import com.mycompany.time_table_management_system.db.model.Classroom;
import com.mycompany.time_table_management_system.db.model.Department;
import com.mycompany.time_table_management_system.db.model.Lecturer;
import com.mycompany.time_table_management_system.db.model.Module;
import com.mycompany.time_table_management_system.db.model.Schedule;
import com.mycompany.time_table_management_system.db.model.ScheduleList;
import com.mycompany.time_table_management_system.db.model.ScheduleSearch;
import com.mycompany.time_table_management_system.timetablegenarator.controller.GenerateTimeTable;
import com.mycompany.time_table_management_system.timetablegenarator.controller.IndivitualEncoder;
import com.mycompany.time_table_management_system.timetablegenarator.geneticalgorithm.Individual;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.mycompany.time_table_management_system.componentconntroller.AutoGenerate;
import com.mycompany.time_table_management_system.db.doa.batch.BatchDAO;
import com.mycompany.time_table_management_system.db.doa.classroom.ClassroomDAO;
import com.mycompany.time_table_management_system.db.doa.common.CommonDAO;

@RequestMapping(value = "/timetable")
@Controller
public class TimeTableGenerationController {
	
	@Autowired
	private ScheduleDAO scheduleDAO;

	@Autowired
	private ClassroomDAO classroomDAO;

	@Autowired
	private DepartmentDAO departmentDAO;

	@Autowired
	private ModuleDAO moduleDAO;
	
	@Autowired
	private LecturerDAO lecturerDAO;
	
	@Autowired
	private BatchDAO batchDAO;
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private IndivitualEncoder indivitualEncoder;

	@RequestMapping(value = "/timetablegeneration")
	public ModelAndView viewTimeGeneratingInput(HttpSession session) {
		ModelAndView model = new ModelAndView("timetablegenerator");
		String[] test=batchList("Semester 7", "Batch'11");
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]+" , ");
		}
		System.out.println();
		
		test=batchList("Semester 5", "Batch'12");
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]+" , ");
		}
		System.out.println();
		
		test=batchList("Semester 3", "Batch'13");
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]+" , ");
		}
		System.out.println();
		
		test=batchList("Semester 2", "Batch'14");
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]+" , ");
		}
		System.out.println();
		
		
		
		List<Department> departmentList = departmentDAO.getDepartmentList();
		List<Module> moduleList = moduleDAO.getModuleList();
		List<Classroom> classroomList = classroomDAO.getClassroomList();
		List<Batch> batchList = batchDAO.getBatchList();
		for (Batch batch : batchList) {
			System.out.println(batch.getBatchName());
		}
		model.addObject("DepartmentList", departmentList);
		model.addObject("ModuleList", moduleList);
		model.addObject("ClassroomList", classroomList);
		model.addObject("BatchList", batchList);
		session.setAttribute("aa", "Amila");
		return model;
	}
	@RequestMapping(value = "/generatetimetable" ,method=RequestMethod.POST)
	public ModelAndView viewTimeGeneratingInput1(@ModelAttribute("schedules")ScheduleList scheduleList, @RequestParam("department0") String departmentName,@RequestParam("batch") String batchName,@RequestParam("semester") String semester,HttpSession session) {
		System.out.println(session.getAttribute("aa"));
		System.out.println(departmentName);
		System.out.println(batchName);
		System.out.println(semester);
		List<Schedule> schedules=new ArrayList<Schedule>();
		List<Module> moduleList=new ArrayList<Module>();
		
		Department department=new Department();
		department.setDepartmentName(departmentName);
		Batch batch=new Batch();
		batch.setBatchName(batchName);
		
		for (ScheduleSearch schedule : scheduleList.getSchedules()) {
			Module module=new Module();
			module.setModuleTitle(schedule.getModuleTitle());
			module=moduleDAO.getModule(module,"Module_Title");
			moduleList.add(module);
			Classroom classroom=new Classroom();
			classroom.setClassroomName(schedule.getClassroomName());
			Schedule schedule2=new Schedule(0, 0, module.getModuleNo(),classroomDAO.getClassroom(classroom,"Classroom_Name").getClassroomId(),departmentDAO.getDepartment(department, "Department_Name").getDepartmentId() , batchDAO.getBatch(batch, "Batch_Name").getBatchNo(), semester);
			List<Lecturer> lecturers=new ArrayList<Lecturer>();
			for (String string : schedule.getLecturerNames()) {
				Lecturer lecturer=new Lecturer();
				lecturer.setLecturerName(string);
				lecturer=lecturerDAO.getLecturer(lecturer,"Lecturer_Name");
				lecturers.add(lecturer);
			}
			schedule2.setLecturerList(lecturers);
			schedules.add(schedule2);
			System.out.println(schedule.getModuleTitle());
			System.out.println(schedule.getDepartmentName());
			for (String string : schedule.getLecturerNames()) {
				System.out.println(string);
			}
		}
		String[] temp=batchList(semester, batchName);
		Batch[] batches=new Batch[temp.length+1];
		String[] semesters=new String[temp.length+1];
		for (int i=0;i<temp.length;i++) {
			Batch batch1=new Batch(); 
			batch1.setBatchName(temp[i]);
			batches[i]=batchDAO.getBatch(batch1, "Batch_Name");
			semesters[i]=scheduleDAO.getLastSemesterofBatch(batch1);
		}
		batches[temp.length]=batch;
		semesters[temp.length]=semester;
		
		Individual[] individuals=indivitualEncoder.Encode(schedules, batches, semesters);
		for (Individual individual : individuals) {
			System.out.println(individual.toString());
		}
		GenerateTimeTable generateTimeTable=new GenerateTimeTable(individuals, moduleList);
		Individual individual=generateTimeTable.generate();
		
		schedules=indivitualEncoder.deocdeAutomatic(individual, moduleList, schedules);
		String[][] timetable=new String[9][5];
		for (Schedule schedule : schedules) {
			String temp1=schedule.getModuleNo().trim()+" - "+moduleList.get(moduleList.indexOf(new Module(schedule.getModuleNo(), "", ""))).getModuleTitle().trim()+"<br>("+classroomDAO.getClassroom(new Classroom(schedule.getClassroomId()), "Classroom_ID").getClassroomName().trim()+")";
			timetable[schedule.getTimePeriod()-1][schedule.getDay()-1]=temp1;
			System.out.println(schedule.getTimePeriod()+" "+schedule.getDay()+" "+schedule.getModuleNo()+" "+schedule.getClassroomId());
		}
				
		session.setAttribute("scheduleList", schedules);
		session.setAttribute("SolutionIndivitual", individual);
		ModelAndView model = new ModelAndView("generatedtimetable");
		model.addObject("TimeTable",timetable);
		return model;
	}
	
	@RequestMapping(value = "/savetimetable")
	public ModelAndView saveTimeGeneratingTumeTable(HttpSession session) {
		List<Schedule> scheduleList=(List<Schedule>)session.getAttribute("scheduleList");
		for (Schedule schedule : scheduleList) {
			scheduleDAO.insertSchedule(schedule);
		}
		return viewTimeGeneratingInput(session);
	}
	
	@RequestMapping(value = "/abc", method = RequestMethod.POST/*,produces="application/json"*/)
	public @ResponseBody String fillModule(@RequestParam("department") String department) {
	    // fetch the userid to be deleted from the userDetails
	    // remebmer the id of user to be deleted will be set in the ajax call
		System.out.println("abc");
		System.out.println(department);
	    List<String> modules=commonDAO.getResultList("module m NATURAL JOIN department d", "module_Title", "d.department_Name", department);
	    List<String> lecturers=commonDAO.getResultList("lecturer l NATURAL JOIN department d", "Lecturer_Name", "d.department_Name", department);
	    String toReturn="";
	    if(modules.isEmpty()){
	    	toReturn+=" ";
	    }
	    for (String string : modules) {
			toReturn+=string+",";
		}
	    toReturn=toReturn.substring(0, toReturn.length()-1);
	    toReturn+="//";
	    if(lecturers.isEmpty()){
	    	toReturn+=" ";
	    }
	    for (String string : lecturers) {
			toReturn+=string+",";
		}
	    return toReturn.substring(0, toReturn.length()-1);
	}
	
	private String[] batchList(String semester,String batch) {
		String[] toReturn=new String[3];
		System.out.println(semester.substring(semester.length()-1));
		System.out.println(batch.substring(batch.length()-2));
		if(Integer.parseInt(semester.substring(semester.length()-1))==7 || Integer.parseInt(semester.substring(semester.length()-1))==8){
			for (int i = 0; i < toReturn.length; i++) {
				System.out.println("a");
				toReturn[i]=batch.substring(0, batch.length()-2)+(Integer.parseInt(batch.substring(batch.length()-2))+(i+1));
			}
		}else if(Integer.parseInt(semester.substring(semester.length()-1))==5){
			System.out.println("b");
			toReturn[0]=batch.substring(0, batch.length()-2)+(Integer.parseInt(batch.substring(batch.length()-2))-1);
			for (int i = 1; i < toReturn.length; i++) {
				toReturn[i]=batch.substring(0, batch.length()-2)+(Integer.parseInt(batch.substring(batch.length()-2))+i);
			}
			
		}else if(Integer.parseInt(semester.substring(semester.length()-1))==3 || Integer.parseInt(semester.substring(semester.length()-1))==4){
			System.out.println("c");
			for (int i = 1; i < toReturn.length; i++) {
				toReturn[i]=batch.substring(0, batch.length()-2)+(Integer.parseInt(batch.substring(batch.length()-2))-i);
			}
			toReturn[0]=batch.substring(0, batch.length()-2)+(Integer.parseInt(batch.substring(batch.length()-2))+1);
		}else{
			System.out.println("d");
			for (int i = 0; i < toReturn.length; i++) {
				toReturn[i]=batch.substring(0, batch.length()-2)+(Integer.parseInt(batch.substring(batch.length()-2))-(i+1));
			}
		}
		return toReturn;
	}
}
