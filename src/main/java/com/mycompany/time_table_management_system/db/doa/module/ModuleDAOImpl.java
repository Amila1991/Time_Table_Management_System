/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.time_table_management_system.db.doa.module;

import com.mycompany.time_table_management_system.db.model.Building;
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
public class ModuleDAOImpl implements ModuleDAO {

    private JdbcTemplate jdbcTemplate;

    public ModuleDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public List<Module> getModuleList() {
        String sql = "SELECT * FROM module";
        List<Module> listUser = jdbcTemplate.query(sql, new RowMapper<Module>() {

            @Override
            public Module mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Module module = new Module();

            	module.setModuleNo(rs.getString("Module_No"));
            	module.setModuleTitle(rs.getString("Module_Title"));
            	module.setCredit(rs.getInt("Credit"));
            	module.setIsGpa(rs.getBoolean("IsGPA"));
            	module.setLectureHours(rs.getInt("Lecture_hours"));
            	module.setPracticalHours(rs.getInt("Practical_hours"));
            	module.setDepartmentId(rs.getString("Department_ID"));

                return module;
            }

        });

        return listUser;
    }

    @Override
    @Transactional
    public boolean insertModule(Module module) {
        String sql="INSERT INTO Module VALUE(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, module.getModuleNo(),module.getModuleTitle(),module.getCredit(),module.getIsGpa(),module.getLectureHours(),module.getPracticalHours(),module.getDepartmentId());
        return true;
    }

    @Override
    public boolean updateModule(Module module) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteModule(Module module) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

	@Override
	public Module getModule(Module module,String column) {
		String value;
		if(column=="Module_No"){
			value=module.getModuleNo();
		}else {
			value=module.getModuleTitle();
		}
		System.out.println(value);
		String sql = "SELECT * FROM module where "+column+"=?";
		module=jdbcTemplate.query(sql,new ResultSetExtractor<Module>() {

			@Override
			public Module extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
            	Module module = new Module();

            	module.setModuleNo(rs.getString("Module_No"));
            	module.setModuleTitle(rs.getString("Module_Title"));
            	module.setCredit(rs.getInt("Credit"));
            	module.setIsGpa(rs.getBoolean("IsGPA"));
            	module.setLectureHours(rs.getInt("Lecture_hours"));
            	module.setPracticalHours(rs.getInt("Practical_hours"));
            	module.setDepartmentId(rs.getString("Department_ID"));
            	
            	System.out.println("abc"+module.getModuleNo());

                return module;
			}
		}, new Object[]{value} );
		return module;
	}

}
