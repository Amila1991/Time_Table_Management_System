/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.time_table_management_system.timetablegenarator.geneticalgorithm;

/**
 *
 * @author Amila
 */
public class GeneticAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // Set a candidate solution
        //FitnessCalc.setSolution("0000000111100000000000000000000000000000000000000011110000000000");
        byte[] solution={4,2,2,4,2,3,2,4};
        FitnessCalc.setSolution(solution);
        // Create an initial population
        Individual[] individuals= new Individual[8];
        for (int i = 0; i < 8; i++) {
            Individual individual=new Individual();
            System.out.println("In "+i);
            for (int j = 0; j < individual.size(); j++) {
                byte gene = (byte) (Math.round(Math.random())*(i+1));
                individual.setGene(j, gene);
                System.out.print(gene+" ,");
            }
            System.out.println("\n");
            individuals[i]=individual;
        }
        
        Population myPop =  new Population(individuals);//new Population(50, true);
        
        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
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

    }
    
}
