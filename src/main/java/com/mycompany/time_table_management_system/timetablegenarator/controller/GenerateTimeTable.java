package com.mycompany.time_table_management_system.timetablegenarator.controller;

import java.util.List;

import com.mycompany.time_table_management_system.db.model.Module;
import com.mycompany.time_table_management_system.db.model.Schedule;
import com.mycompany.time_table_management_system.db.model.ScheduleList;
import com.mycompany.time_table_management_system.timetablegenarator.geneticalgorithm.Algorithm;
import com.mycompany.time_table_management_system.timetablegenarator.geneticalgorithm.FitnessCalc;
import com.mycompany.time_table_management_system.timetablegenarator.geneticalgorithm.Individual;
import com.mycompany.time_table_management_system.timetablegenarator.geneticalgorithm.Population;

public class GenerateTimeTable {
	
	Population  myPop;
	byte[] solution;
	int generationCount = 0;
	
	public GenerateTimeTable() {
		// TODO Auto-generated constructor stub
	}

	public GenerateTimeTable(Population population) {
		this.myPop = population;
	}
	
	public GenerateTimeTable(Individual[] individuals,List<Module> moduleList) {
		 myPop=new Population(individuals);
		solution=new byte[moduleList.size()];
		for (int i = 0; i < moduleList.size(); i++) {
			solution[i]=(byte)moduleList.get(i).getLectureHours();				
		}
		FitnessCalc.setSolution(solution);
	}
	
	public Individual generate() {
		// Evolve our population until we reach an optimum solution
        generationCount = 0;
        while (generationCount<1000 && myPop.getFittest().getFitness(8) < FitnessCalc.getMaxFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness(8));
            myPop = Algorithm.evolvePopulation(myPop);
            System.out.println("Genesskk:");
            System.out.println(myPop.getFittest());
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFittest());
		
		return myPop.getFittest();
		
	}
	

}
