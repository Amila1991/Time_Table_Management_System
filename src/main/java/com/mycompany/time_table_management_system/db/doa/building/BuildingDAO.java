/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.time_table_management_system.db.doa.building;

import com.mycompany.time_table_management_system.db.model.Building;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Amila
 */
public interface BuildingDAO {

    public boolean insertBuilding(Building building);
    public boolean updateBuilding(Building building);
    public boolean deleteBuilding(Building building);
    public Building getBuilding(Building building,String column);
    public List<Building> getBuildingList();
    public JdbcTemplate getJdbcTemplate();
}
