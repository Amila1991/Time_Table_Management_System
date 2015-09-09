/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.time_table_management_system.db.doa.department;

import com.mycompany.time_table_management_system.db.model.Department;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Amila
 */
public interface DepartmentDAO {

    public boolean insertDepartment(Department department);
    public boolean updateDepartment(Department department);
    public boolean deleteDepartment(Department department);
    public Department getDepartment(Department department,String column);
    public List<Department> getDepartmentList();
    public JdbcTemplate getJdbcTemplate();
}
