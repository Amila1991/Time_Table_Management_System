package com.mycompany.time_table_management_system.db.doa.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;


public class CommonDAOImpl implements CommonDAO {

	private JdbcTemplate jdbcTemplate;

    public CommonDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	@Override
	@Transactional
	public List<String> getResultList(String table, final String column, String searchColumn, String value) {
		 String sql = "SELECT * FROM "+table+" WHERE "+searchColumn+"='"+value+"'";
		 	System.out.println(column);
	        List<String> resultList = jdbcTemplate.query(sql, new RowMapper<String>() {

	            @Override
	            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
	                return rs.getString(column);
	            }

	        });
	       
		return resultList;
	}

}
