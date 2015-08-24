package com.mycompany.time_table_management_system.componentconntroller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class AutoGenerate {
    
    public static String getNextID(JdbcTemplate jdbcTemplate,String table,String column,String prefix) {
        String id = prefix+"0000";
        String sql= "SELECT "+column+" FROM "+table+" ORDER BY 1 DESC Limit 1";
        
        List<String> list = jdbcTemplate.query(sql, new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1); 
            }
        });
        try {
            if(!list.isEmpty()){
                id=list.get(0);
            }
            System.out.println(id);
            int index = 0;
            for (int i = id.length() - 1; i >= 0; i--) {
                try {
                    Integer.parseInt(id.substring(i));
                } catch (Exception e) {
                    index = i + 1;
                    break;
                }
                System.out.println(id+" "+ index);
            }
            String newID = id.substring(index);
            int n = Integer.parseInt(newID);
            n++;
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(4);
            nf.setGroupingUsed(false);//no more  100,000
//            nf.setMaximumFractionDigits(2);   nf.setMinimumFractionDigits(2) ;//
             id=id.substring(0, index) + nf.format(n);
        } catch (Exception ex) {
            Logger.getLogger(AutoGenerate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;      
    }
    
}
