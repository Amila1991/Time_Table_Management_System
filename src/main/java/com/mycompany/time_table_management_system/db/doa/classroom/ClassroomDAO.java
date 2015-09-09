package com.mycompany.time_table_management_system.db.doa.classroom;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mycompany.time_table_management_system.db.model.Classroom;

public interface ClassroomDAO {

	public boolean insertClassroom(Classroom classroom);
	public boolean deleteClassroom(Classroom classroom);
	public boolean updateClassroom(Classroom classroom);
	public Classroom getClassroom(Classroom classroom,String column);
	public List<Classroom> getClassroomList();
	public JdbcTemplate getJdbcTemplate();
}
