package com.mycompany.time_table_management_system.db.doa.batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.mycompany.time_table_management_system.db.model.Batch;
import com.mycompany.time_table_management_system.db.model.Building;
import com.mycompany.time_table_management_system.db.model.Batch;

public class BatchDAOImpl implements BatchDAO {
	
	private JdbcTemplate jdbcTemplate;

    public BatchDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public boolean insertBatch(Batch batch) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBatch(Batch batch) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBatch(Batch batch) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Batch getBatch(Batch batch, String column) {
		String value;
		if(column=="Batch_No"){
			value=batch.getBatchNo();
		}else {
			value=batch.getBatchName();
		}
		System.out.println(value);
		String sql = "SELECT * FROM batch where "+column+"=?";
		batch=jdbcTemplate.query(sql,new ResultSetExtractor<Batch>() {

			@Override
			public Batch extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				Batch batch = new Batch();

            	batch.setBatchNo(rs.getString("Batch_No"));
                batch.setBatchName(rs.getString("Batch_Name"));

                System.out.println("abc "+batch.getBatchNo());
                return batch;
			}
		}, new Object[]{value} );
		return batch;
	}

	@Override
	public List<Batch> getBatchList() {
		String sql = "SELECT * FROM Batch";
        List<Batch> listUser = jdbcTemplate.query(sql, new RowMapper<Batch>() {

            @Override
            public Batch mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Batch batch = new Batch();

            	batch.setBatchNo(rs.getString("Batch_No"));
                batch.setBatchName(rs.getString("Batch_Name"));

                return batch;
            }

        });

        return listUser;
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	}

}
