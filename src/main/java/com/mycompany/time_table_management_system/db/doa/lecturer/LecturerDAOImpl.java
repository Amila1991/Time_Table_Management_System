/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.time_table_management_system.db.doa.lecturer;

import com.mycompany.time_table_management_system.db.model.Building;
import com.mycompany.time_table_management_system.db.model.Department;
import com.mycompany.time_table_management_system.db.model.Lecturer;
import com.mycompany.time_table_management_system.db.model.Module;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amila
 */
public class LecturerDAOImpl implements LecturerDAO {

    private JdbcTemplate jdbcTemplate;

    public LecturerDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public List<Lecturer> getLecturerList() {
        String sql = "SELECT * FROM lecturer";
        List<Lecturer> listUser = jdbcTemplate.query(sql, new RowMapper<Lecturer>() {

            @Override
            public Lecturer mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Lecturer lecturer = new Lecturer();
            	lecturer.setLecturerId(rs.getString("Lecturer_ID"));
            	lecturer.setLecturerName(rs.getString("Lecturer_Name"));
            	lecturer.setContactNo(rs.getString("Contact_No"));
            	lecturer.setEmail(rs.getString("Email"));
            	lecturer.setDepartment( new Department(rs.getString("Department_ID")));

                return lecturer;
            }

        });

        return listUser;
    }

    @Override
    @Transactional
    public boolean insertLecturer(Lecturer lecturer) {
        String sql="INSERT INTO Lecturer VALUE(?,?,?,?,?)";
        jdbcTemplate.update(sql,lecturer.getLecturerId(),lecturer.getLecturerName(),lecturer.getContactNo(),lecturer.getEmail(),lecturer.getDepartment().getDepartmentId());
        return true;
    }

    @Override
    public boolean updateLecturer(Lecturer lecturer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteLecturer(Lecturer lecturer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

	@Override
	public Lecturer getLecturer(Lecturer lecturer,String column) {
		String value;
		if(column=="Lecturer_ID"){
			value=lecturer.getLecturerId();
		}else {
			value=lecturer.getLecturerName();
		}
		System.out.println(value);
		String sql = "SELECT * FROM lecturer where "+column+"=?";
		lecturer=jdbcTemplate.query(sql,new ResultSetExtractor<Lecturer>() {

			@Override
			public Lecturer extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				Lecturer lecturer = new Lecturer();
            	lecturer.setLecturerId(rs.getString("Lecturer_ID"));
            	lecturer.setLecturerName(rs.getString("Lecturer_Name"));
            	lecturer.setContactNo(rs.getString("Contact_No"));
            	lecturer.setEmail(rs.getString("Email"));
            	lecturer.setDepartment( new Department(rs.getString("Department_ID")));

                return lecturer;
			}
		}, new Object[]{value} );
		return lecturer;
	}

}
