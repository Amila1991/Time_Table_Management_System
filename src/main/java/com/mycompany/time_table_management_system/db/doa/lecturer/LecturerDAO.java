/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.time_table_management_system.db.doa.lecturer;

import com.mycompany.time_table_management_system.db.model.Lecturer;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Amila
 */
public interface LecturerDAO {

    public boolean insertLecturer(Lecturer lecturer);
    public boolean updateLecturer(Lecturer lecturer);
    public boolean deleteLecturer(Lecturer lecturer);
    public Lecturer getLecturer(Lecturer lecturer,String column);
    public List<Lecturer> getLecturerList();
    public JdbcTemplate getJdbcTemplate();
}
