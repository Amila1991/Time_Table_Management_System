 package com.mycompany.time_table_management_system.db.doa.classroom;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mycompany.time_table_management_system.db.model.Classroom;

public class ClassroomDAOImpl implements ClassroomDAO {
	
	 private JdbcTemplate jdbcTemplate;

	public ClassroomDAOImpl(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean insertClassroom(Classroom classroom) {
		String sql="INSERT INTO Building VALUE(?,?)";
        //jdbcTemplate.update(sql, building.getBuildingId(),building.getBuildingName());
        return true;
	}

	@Override
	public boolean deleteClassroom(Classroom classroom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateClassroom(Classroom classroom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Classroom getClassroom(Classroom classroom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Classroom> getClassroomList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}
