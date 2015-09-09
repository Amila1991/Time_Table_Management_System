/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.time_table_management_system.db.doa.module;

import com.mycompany.time_table_management_system.db.model.Module;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Amila
 */
public interface ModuleDAO {

    public boolean insertModule(Module module);
    public boolean updateModule(Module module);
    public boolean deleteModule(Module module);
    public Module getModule(Module module,String column);
    public List<Module> getModuleList();
    public JdbcTemplate getJdbcTemplate();
}
