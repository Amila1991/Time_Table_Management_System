package com.mycompany.time_table_management_system.db.doa.batch;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mycompany.time_table_management_system.db.model.Batch;

public interface BatchDAO {
	 public boolean insertBatch(Batch batch);
	    public boolean updateBatch(Batch batch);
	    public boolean deleteBatch(Batch batch);
	    public Batch getBatch(Batch batch,String column);
	    public List<Batch> getBatchList();
	    public JdbcTemplate getJdbcTemplate();
}
