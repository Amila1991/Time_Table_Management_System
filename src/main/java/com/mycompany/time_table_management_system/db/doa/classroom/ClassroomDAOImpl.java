 package com.mycompany.time_table_management_system.db.doa.classroom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.mycompany.time_table_management_system.db.model.Building;
import com.mycompany.time_table_management_system.db.model.Classroom;

public class ClassroomDAOImpl implements ClassroomDAO {
	
	 private JdbcTemplate jdbcTemplate;

	public ClassroomDAOImpl(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean insertClassroom(Classroom classroom) {
		String sql="INSERT INTO Classroom VALUE(?,?,?,?)";
        jdbcTemplate.update(sql, classroom.getClassroomId(),classroom.getClassroomName(),classroom.getClassroomSize(),classroom.getBuilding().getBuildingId());
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
	public Classroom getClassroom(Classroom classroom, String column) {
		String value;
		if(column=="Classroom_ID"){
			value=classroom.getClassroomId();
		}else {
			value=classroom.getClassroomName();
		}
		System.out.println(value);
		String sql = "SELECT * FROM classroom where "+column+"=?";
		classroom=jdbcTemplate.query(sql,new ResultSetExtractor<Classroom>() {

			@Override
			public Classroom extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
            	Classroom classroom = new Classroom();

            	classroom.setClassroomId(rs.getString("Classroom_ID"));
                classroom.setClassroomName(rs.getString("Classroom_Name"));
                classroom.setBuilding(new Building(rs.getString("Building_ID")));

                System.out.println("abc "+classroom.getClassroomId());
                return classroom;
			}
		}, new Object[]{value} );
		return classroom;
	}

	@Override
	public List<Classroom> getClassroomList() {
		String sql = "SELECT * FROM classroom";
        List<Classroom> classroomList = jdbcTemplate.query(sql, new RowMapper<Classroom>() {

            @Override
            public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {
                Classroom classroom=new Classroom();

                classroom.setClassroomId(rs.getString("Classroom_ID"));
                classroom.setClassroomName(rs.getString("Classroom_Name"));
                classroom.setClassroomSize(rs.getInt("Classroom_Size"));
                classroom.setBuilding(new Building(rs.getString("Building_ID")));

                return classroom;
            }

        });

        return classroomList;
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}
