/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.time_table_management_system.timetablegenarator.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mycompany.time_table_management_system.db.model.Batch;
import com.mycompany.time_table_management_system.db.model.Lecturer;
import com.mycompany.time_table_management_system.db.model.Module;
import com.mycompany.time_table_management_system.db.model.Schedule;
import com.mycompany.time_table_management_system.timetablegenarator.geneticalgorithm.Individual;

/**
 *
 * @author Amila
 */
public class IndivitualEncoderImpl implements IndivitualEncoder {

	private JdbcTemplate jdbcTemplate;

	public IndivitualEncoderImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Individual[] Encode(List<Schedule> scheduleList, Batch[] batches,String[] semesters ) {
		Individual[] toReturn = new Individual[scheduleList.size()];
		for (int i = 0; i <scheduleList.size(); i++) {
			byte[] classroomEncode=createConstraintInSchedule("Classroom_ID", scheduleList.get(i).getClassroomId(),batches,semesters);
			byte[] lecturerEncode=createLecturerConstraint(scheduleList.get(i).getLecturerList(),batches,semesters);
			Individual individual=new Individual();
			for (int j = 0; j < individual.size(); j++) {
				 if(classroomEncode[j]==1 || lecturerEncode[j]==1){
					  
				 }else{
					 individual.setGene(j, (byte)(i+1));
				 }
	         toReturn[i]=individual;   	
			}
		}
		return toReturn;
	}
	
	@Override
	public List<Schedule> deocdeAllPossibles(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> deocdeAutomatic(Individual individual,List<Module> moduleList,List<Schedule> scheduleList) {
		List<Schedule> toReturn=new ArrayList<Schedule>();
		System.out.println("test123");
		for (int i=0;i<moduleList.size();i++) {
			int j=0,count=0;
			while (moduleList.get(i).getLectureHours()>count) {
				if(individual.getGene(j)==(i+1)){
					Schedule schedule=scheduleList.get(scheduleList.indexOf(new Schedule(0, 0, moduleList.get(i).getModuleNo(), "", "", "", "")));
					Schedule schedule2=new Schedule((j%9)+1, (j/9)+1, schedule.getModuleNo(), schedule.getClassroomId(), schedule.getDepartmentId(), schedule.getBatchNo(), schedule.getSemester(),schedule.getLecturerList());
					toReturn.add(schedule2);
					count++;
				}
				j++;
			}
		}
		return toReturn;
	}


	public byte[] createConstraintInSchedule(String column, String value, Batch[] batches,String[] semesters) {
		byte[] toReturn = new byte[45];
		String sql = "SELECT * FROM Schedule WHERE " + column + "='" + value + "' AND ((Batch_No='"+batches[0].getBatchNo()+"' AND Semester='"+semesters[0]+"') OR (Batch_No='"+batches[1].getBatchNo()+"' AND Semester='"+semesters[1]+"') OR (Batch_No='"+batches[2].getBatchNo()+"' AND Semester='"+semesters[2]+"') OR (Batch_No='"+batches[3].getBatchNo()+"' AND Semester='"+semesters[3]+"')) ORDER BY Day,Time_period";
		List<Schedule> listSchedule = jdbcTemplate.query(sql, new RowMapper<Schedule>() {

			@Override
			public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
				Schedule schedule = new Schedule();

				schedule.setTimePeriod(rs.getInt("Time_period"));
				schedule.setDay(rs.getInt("Day"));
				schedule.setClassroomId(rs.getString("Classroom_ID"));
				schedule.setDepartmentId(rs.getString("Department_ID"));
				schedule.setModuleNo(rs.getString("Module_No"));

				return schedule;
			}

		});

		for (Schedule schedule : listSchedule) {
			toReturn[(((schedule.getDay() - 1) * 9) + schedule.getTimePeriod())-1] = 1;
		}
		return toReturn;
	}
	
	public byte[] createLecturerConstraint(List<Lecturer> lecturerList, Batch[] batches,String[] semesters) {
		byte[] toReturn = new byte[45];
		ArrayList<Schedule> constratint=new ArrayList<Schedule>();
		for (Lecturer lecturer : lecturerList) {
			String sql = "SELECT * FROM Schedule_Lecturer WHERE  Lecturer_ID='" + lecturer.getLecturerId() +"' AND ((Batch_No='"+batches[0].getBatchNo()+"' AND Semester='"+semesters[0]+"') OR (Batch_No='"+batches[1].getBatchNo()+"' AND Semester='"+semesters[1]+"') OR (Batch_No='"+batches[2].getBatchNo()+"' AND Semester='"+semesters[2]+"') OR (Batch_No='"+batches[3].getBatchNo()+"' AND Semester='"+semesters[3]+"')) ORDER BY Day,Time_period";
			List<Schedule> listSchedule = jdbcTemplate.query(sql, new RowMapper<Schedule>() {

				@Override
				public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
					Schedule schedule = new Schedule();

					schedule.setTimePeriod(rs.getInt("Time_period"));
					schedule.setDay(rs.getInt("Day"));
					schedule.setClassroomId(rs.getString("Classroom_ID"));
					schedule.setDepartmentId(rs.getString("Department_ID"));
					schedule.setModuleNo(rs.getString("Module_No"));

					return schedule;
				}

			});
			
			constratint.addAll(listSchedule);

		}
		
		for (Schedule schedule : constratint) {
			toReturn[(((schedule.getDay() - 1) * 9) + schedule.getTimePeriod())-1] = 1;
		}
		return toReturn;
	}


}
