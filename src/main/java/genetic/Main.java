package genetic;

import java.util.Scanner;

public class Main {
	
	private static int MAX_GENERATION = 1000;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite o número de passo como objetivo:");
		
		int step = scanner.nextInt();

		// gerar primeira população
		Population population = new Population(10,step); 
		
		
		
		// avaliar a população até chegar na solução
		do {
			
			population = population.algorithm.sortFitness(population);
			
			
			System.out.println("Geração: " + population.getGeneration()
			+ ". Melhor resultado: " + population.getIndividuals()[0].toString());
			
			population = population.algorithm.crossing(population);
			
			population.algorithm.mutation();
			

			
			population.increaseGeneration();
			
		} while(!population.algorithm.hasSolution(population) && population.getGeneration() < MAX_GENERATION);
		
		try {
			System.out.println("Geração: " + population.getGeneration()
			+ ". Objetivo alcançado: " + population.getIndividualWinner().toString());
		}catch(Exception e) {
			System.err.println("O objetivo não foi alcançado em 100 gerações");
		}
	}

}
