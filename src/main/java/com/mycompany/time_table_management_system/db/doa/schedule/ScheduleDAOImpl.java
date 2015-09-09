package com.mycompany.time_table_management_system.db.doa.schedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mycompany.time_table_management_system.db.model.Batch;
import com.mycompany.time_table_management_system.db.model.Building;
import com.mycompany.time_table_management_system.db.model.Department;
import com.mycompany.time_table_management_system.db.model.Lecturer;
import com.mycompany.time_table_management_system.db.model.Schedule;

public class ScheduleDAOImpl implements ScheduleDAO {
	
	  private JdbcTemplate jdbcTemplate;

	    public ScheduleDAOImpl(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	@Override
	public boolean insertSchedule(Schedule schedule) {
		 String sql="INSERT INTO Schedule VALUE(?,?,?,?,?,?,?)";
		 jdbcTemplate.update(sql, schedule.getTimePeriod(),schedule.getDay(),schedule.getModuleNo(),schedule.getClassroomId(),schedule.getDepartmentId(),schedule.getBatchNo(),schedule.getSemester());
		 sql="INSERT INTO Schedule_Lecturer VALUE(?,?,?,?,?,?,?,?)";
		 for (Lecturer lecturer : schedule.getLecturerList()) {
			 jdbcTemplate.update(sql, schedule.getTimePeriod(),schedule.getDay(),schedule.getModuleNo(),schedule.getClassroomId(),lecturer.getLecturerId(),schedule.getDepartmentId(),schedule.getBatchNo(),schedule.getSemester());
		}
		return true;
	}

	@Override
	public List<Schedule> getScheduleListforDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> getScheduleListforLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String getLastSemesterofBatch(Batch batch) {
		String sql="SELECT * FROM schedule s NATURAL JOIN batch b WHERE Batch_Name=? ORDER BY Semester DESC Limit 1";
		String toReturn=jdbcTemplate.query(sql,new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()){
                return rs.getString("Semester");
				}
				return "nonSemester";
			}
		}, new Object[]{batch.getBatchName()} );
		return toReturn;
	}
	
	@Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

}
