package genetic;

import javax.swing.JOptionPane;

public class Main {
	
	private static int MAX_GENERATION = 1000;

	public static void main(String[] args) {
		
//		System.out.print("Digite o número de passo como objetivo:");
		
		int x = Integer.valueOf(JOptionPane.showInputDialog("Digite a coordenada para 'x': "));
		int y = Integer.valueOf(JOptionPane.showInputDialog("Digite a coordenada para 'y': "));

		// gerar primeira população
		Population population = new Population(10, x, y); 
		
		String msg = "";
		
		// avaliar a população até chegar na solução
		do {
			
			population = population.algorithm.sortFitness(population);
			
			
			System.out.println("Geração: " + population.getGeneration()
			+ ". Melhor resultado: " + population.getIndividuals()[0].toString());
			
			msg += "Geração: " + population.getGeneration()
				+ ". Melhor resultado: " + population.getIndividuals()[0].toString() + "\n";
			
			population = population.algorithm.crossing(population);
			
			population.algorithm.mutation();
			

			
			population.increaseGeneration();
			
			
			if(population.getGeneration() % 10 == 0) {
				
				JOptionPane.showMessageDialog(null, msg);
				msg = "";
			}
			
		} while(!population.algorithm.hasSolution(population) && population.getGeneration() < MAX_GENERATION);
		
		JOptionPane.showMessageDialog(null, msg);
		
		try {
			System.out.println("Geração: " + population.getGeneration()
			+ ". Objetivo alcançado: " + population.getIndividualWinner().toString());
			
			JOptionPane.showMessageDialog(null, "Geração: " + population.getGeneration()
			+ ". Objetivo alcançado: " + population.getIndividualWinner().toString());
		}catch(Exception e) {
			System.err.println("O objetivo não foi alcançado em 100 gerações");
		}
	}

}
