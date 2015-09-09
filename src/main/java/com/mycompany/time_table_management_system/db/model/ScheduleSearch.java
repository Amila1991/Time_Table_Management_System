package com.mycompany.time_table_management_system.db.model;

import java.util.List;

public class ScheduleSearch {
	
	private int timePeriod;
    private int day;
    private String moduleTitle;
    private String classroomName;
    private String departmentName;
    private String batchNo; 
    private String semester;
    private List<String> lecturerNames;

    public ScheduleSearch() {
		// TODO Auto-generated constructor stub
	}

	public ScheduleSearch(int timePeriod, int day, String moduleTitle, String classroomName, String departmentName,
			String batchNo, String semester) {
		super();
		this.timePeriod = timePeriod;
		this.day = day;
		this.moduleTitle = moduleTitle;
		this.classroomName = classroomName;
		this.departmentName = departmentName;
		this.batchNo = batchNo;
		this.semester = semester;
	}

	public ScheduleSearch(int timePeriod, int day, String moduleTitle, String classroomName, String departmentName,
			String batchNo, String semester, List<String> lecturerNames) {
		super();
		this.timePeriod = timePeriod;
		this.day = day;
		this.moduleTitle = moduleTitle;
		this.classroomName = classroomName;
		this.departmentName = departmentName;
		this.batchNo = batchNo;
		this.semester = semester;
		this.lecturerNames = lecturerNames;
	}

	/**
	 * @return the timePeriod
	 */
	public int getTimePeriod() {
		return timePeriod;
	}

	/**
	 * @param timePeriod the timePeriod to set
	 */
	public void setTimePeriod(int timePeriod) {
		this.timePeriod = timePeriod;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the moduleTittle
	 */
	public String getModuleTitle() {
		return moduleTitle;
	}

	/**
	 * @param moduleTittle the moduleTittle to set
	 */
	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}

	/**
	 * @return the classroomName
	 */
	public String getClassroomName() {
		return classroomName;
	}

	/**
	 * @param classroomName the classroomName to set
	 */
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the batchNo
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * @param batchNo the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	/**
	 * @return the lecturerNames
	 */
	public List<String> getLecturerNames() {
		return lecturerNames;
	}

	/**
	 * @param lecturerNames the lecturerNames to set
	 */
	public void setLecturerNames(List<String> lecturerNames) {
		this.lecturerNames = lecturerNames;
	}
    
	
	
}
