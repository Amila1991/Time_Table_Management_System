package com.mycompany.time_table_management_system.db.doa.schedule;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mycompany.time_table_management_system.db.model.Batch;
import com.mycompany.time_table_management_system.db.model.Department;
import com.mycompany.time_table_management_system.db.model.Lecturer;
import com.mycompany.time_table_management_system.db.model.Schedule;

public interface ScheduleDAO {
	
	public boolean insertSchedule(Schedule schedule);
	public List<Schedule> getScheduleListforDepartment(Department department);
	public List<Schedule> getScheduleListforLecturer(Lecturer lecturer);
	public String getLastSemesterofBatch(Batch batch);
	public JdbcTemplate getJdbcTemplate();

}
