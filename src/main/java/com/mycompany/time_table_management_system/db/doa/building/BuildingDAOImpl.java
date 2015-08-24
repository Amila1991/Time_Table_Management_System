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
import org.springframework.jdbc.core.JdbcTemplate;
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
        List<Building> listUser = jdbcTemplate.query(sql, new RowMapper<Building>() {

            @Override
            public Building mapRow(ResultSet rs, int rowNum) throws SQLException {
                Building building = new Building();

                building.setBuildingId(rs.getString("Building_ID"));
                building.setBuildingName(rs.getString("Building_Name"));

                return building;
            }

        });

        return listUser;
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
	public Building getBuilding(Building building) {
		// TODO Auto-generated method stub
		return null;
	}

}
