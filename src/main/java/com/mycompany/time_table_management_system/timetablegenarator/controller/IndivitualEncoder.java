package com.mycompany.time_table_management_system.timetablegenarator.controller;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.time_table_management_system.db.model.Batch;
import com.mycompany.time_table_management_system.db.model.Module;
import com.mycompany.time_table_management_system.db.model.Schedule;
import com.mycompany.time_table_management_system.timetablegenarator.geneticalgorithm.Individual;

public interface IndivitualEncoder {
	
	public Individual[] Encode(List<Schedule> scheduleList, Batch[] batches,String[] semesters ) ;
	public List<Schedule> deocdeAllPossibles(Individual individual);
	public List<Schedule> deocdeAutomatic(Individual individual,List<Module> moduleList,List<Schedule> scheduleList);

}
