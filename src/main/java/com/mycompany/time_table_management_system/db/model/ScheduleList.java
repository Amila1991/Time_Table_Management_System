package com.mycompany.time_table_management_system.db.model;

import java.util.List;

/**
 * @author Amila
 *
 */
public class ScheduleList {

	List<ScheduleSearch>  schedules;
	public ScheduleList() {
		// TODO Auto-generated constructor stub
	}
	public ScheduleList(List<ScheduleSearch> schedules) {
		this.schedules = schedules;
	}
	/**
	 * @return the schedules
	 */
	public List<ScheduleSearch> getSchedules() {
		return schedules;
	}
	/**
	 * @param schedules the schedules to set
	 */
	public void setSchedules(List<ScheduleSearch> schedules) {
		this.schedules = schedules;
	}

	
	
}
