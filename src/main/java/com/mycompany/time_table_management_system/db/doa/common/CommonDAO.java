package com.mycompany.time_table_management_system.db.doa.common;

import java.util.List;

public interface CommonDAO {

	public List<String> getResultList(String table,String column,String searchColumn,String value);
}
