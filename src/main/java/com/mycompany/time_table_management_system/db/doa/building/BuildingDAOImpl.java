/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.time_table_management_system.db.doa.building;

import com.mycompany.time_table_management_system.db.model.Building;
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
public class BuildingDAOImpl implements BuildingDAO {

    private JdbcTemplate jdbcTemplate;

    public BuildingDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public List<Building> getBuildingList() {
        String sql = "SELECT * FROM building";
        List<Building> buildingList = jdbcTemplate.query(sql, new RowMapper<Building>() {

            @Override
            public Building mapRow(ResultSet rs, int rowNum) throws SQLException {
                Building building = new Building();

                building.setBuildingId(rs.getString("Building_ID"));
                building.setBuildingName(rs.getString("Building_Name"));

                return building;
            }

        });

        return buildingList;
    }

    @Override
    @Transactional
    public boolean insertBuilding(Building building) {
        String sql="INSERT INTO Building VALUE(?,?)";
        jdbcTemplate.update(sql, building.getBuildingId(),building.getBuildingName());
        return true;
    }

    @Override
    public boolean updateBuilding(Building building) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteBuilding(Building building) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

	@Override
	public Building getBuilding(Building building,String column) {
		// TODO Auto-generated method stub
		String value;
		if(column=="Building_ID"){
			value=building.getBuildingId();
		}else {
			value=building.getBuildingName();
		}
		System.out.println(value);
		String sql = "SELECT * FROM building where "+column+"=?";
		building=jdbcTemplate.query(sql,new ResultSetExtractor<Building>() {

			@Override
			public Building extractData(ResultSet rs) throws SQLException, DataAccessException {
				Building building = new Building();
				rs.next();
                building.setBuildingId(rs.getString("Building_ID"));
                building.setBuildingName(rs.getString("Building_Name"));

                return building;
			}
		}, new Object[]{value} );
		return building;
	}

}
