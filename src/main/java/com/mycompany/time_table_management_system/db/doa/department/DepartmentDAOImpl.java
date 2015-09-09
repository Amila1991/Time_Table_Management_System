/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.time_table_management_system.db.doa.department;

import com.mycompany.time_table_management_system.db.model.Building;
import com.mycompany.time_table_management_system.db.model.Department;
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
public class DepartmentDAOImpl implements DepartmentDAO {

    private JdbcTemplate jdbcTemplate;

    public DepartmentDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public List<Department> getDepartmentList() {
        String sql = "SELECT * FROM department";
        List<Department> listUser = jdbcTemplate.query(sql, new RowMapper<Department>() {

            @Override
            public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Department department = new Department();

            	department.setDepartmentId(rs.getString("Department_ID"));
                department.setDepartmentName(rs.getString("Department_Name"));
                department.setBuilding(new Building(rs.getString("Building_ID")));

                return department;
            }

        });

        return listUser;
    }

    @Override
    @Transactional
    public boolean insertDepartment(Department department) {
        String sql="INSERT INTO Department VALUE(?,?,?)";
        jdbcTemplate.update(sql, department.getDepartmentId(),department.getDepartmentName(),department.getBuilding().getBuildingId());
        return true;
    }

    @Override
    public boolean updateDepartment(Department department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteDepartment(Department department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

	@Override
	public Department getDepartment(Department department,String column) {
		String value;
		if(column=="Department_ID"){
			value=department.getDepartmentId();
		}else {
			value=department.getDepartmentName();
		}
		System.out.println(value);
		String sql = "SELECT * FROM department where "+column+"=?";
		department=jdbcTemplate.query(sql,new ResultSetExtractor<Department>() {

			@Override
			public Department extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
            	Department department = new Department();

            	department.setDepartmentId(rs.getString("Department_ID"));
                department.setDepartmentName(rs.getString("Department_Name"));
                department.setBuilding(new Building(rs.getString("Building_ID")));

                System.out.println("abc "+department.getDepartmentId());
                return department;
			}
		}, new Object[]{value} );
		return department;
	}

}
