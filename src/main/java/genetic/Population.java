package genetic;

import java.util.concurrent.ThreadLocalRandom;

public class Population {
	
	public Population(int amountIndividual, int sizeGenes){
		
		this.sizeGenes = sizeGenes;		
		this.size = amountIndividual;
		GOAL_X = sizeGenes;
		GOAL_Y = sizeGenes;
		GOAL = GOAL_X + GOAL_Y;
		
		this.individuals = new Individual[amountIndividual];
		
		for(int i = 0; i < individuals.length; i++) {
			individuals[i] = new Individual(sizeGenes);
		}
	}
	

	private final int GOAL_X;
	private final int GOAL_Y;
	private final int GOAL;
	
	private int size;
	private int sizeGenes;
	private int generation = 1;
	private Individual[] individuals;
	
	private Individual individualWinner;
	
	public GeneticAlgorithm algorithm = new GeneticAlgorithm();
	
	public int getSizeGenes() {
		return sizeGenes;
	}
	public void setSizeGenes(int sizeGenes) {
		this.sizeGenes = sizeGenes;
	}
	public int getGeneration() {
		return generation;
	}
	public void increaseGeneration() {
		this.generation++;
	}
	public Individual[] getIndividuals() {
		return individuals;
	}
	public void setIndividuals(Individual[] individuals) {
		this.individuals = individuals;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public Individual getIndividualWinner() {
		return individualWinner;
	}
//	public void setIndividualWinner(Individual individualWinner) {
//		this.individualWinner = individualWinner;
//	}

	// Classe do algoritmo
	public class GeneticAlgorithm {

		private final static double PERCENTAGE = 0.2;
		
		public Population sortFitness(Population population) {
			
			classify();
			
			// classifica do maior para o menor, quanto maior mais próximo do objetivo
//			Individual individuals[] = population.getIndividuals();
			boolean hasChange = true;
			
			while(hasChange) {
				
				hasChange = false;
				
				for(int i = 0; i < individuals.length -1; i++){
					
					Individual indAux = null;
					
					if(individuals[i].getFitness() < individuals[i + 1].getFitness()) {
						indAux = individuals[i];
						individuals[i] = individuals[i + 1];
						individuals[i + 1] = indAux;
						hasChange = true;
					}
				}
			}
			population.setIndividuals(individuals);
			return population;
		}
		
		public Population crossing(Population population) {
			
			// seleciona os melhores individuas conforme a porcentagem
			double qtdeSelected = population.getIndividuals().length * PERCENTAGE;
			
			// deixar a qtde sempre como número par
			if((int) qtdeSelected % 2 != 0)
				qtdeSelected -= 1;
			
			Individual[] bestIndividuals = new Individual[(int) qtdeSelected];
			
			for(int i = 0; i < bestIndividuals.length; i++) {
				bestIndividuals[i] = population.getIndividuals()[i];
			}
			
			
			Individual[] newIndividuals = new Individual[population.getSize()];
			
			int sizeNewInvidual = 0;
			while(sizeNewInvidual < newIndividuals.length) {
				
				// ponto de corte do genes
				int cutoff = ThreadLocalRandom.current().nextInt(0, population.getSizeGenes() + 1);
				
				Footstep[] footstep1 = new Footstep[cutoff];
				Footstep[] footstep2 = new Footstep[population.getSizeGenes() - cutoff];
				
					
				for(int m = 0; m < bestIndividuals.length; m++) {
					for(int n = 0; n < bestIndividuals.length; n++) {
						
						for (int j = 0; j < population.getSizeGenes(); j++) {
							
							if(j < cutoff)
								footstep1[j] = bestIndividuals[m].getPositions()[j];
							else
								footstep2[j - cutoff] = bestIndividuals[n].getPositions()[j];
							
						}
						
						if(sizeNewInvidual == newIndividuals.length) {
							population.setIndividuals(newIndividuals);
							classify();
							return population;
						}
						newIndividuals[sizeNewInvidual++] = new Individual(footstep1, footstep2);
						if(sizeNewInvidual == newIndividuals.length) {
							population.setIndividuals(newIndividuals);
							classify();
							return population;
						}
						newIndividuals[sizeNewInvidual++] = new Individual(footstep2, footstep1);
					}			

				}
			}
			
			population.setIndividuals(newIndividuals);
			classify();
			return population;
		}
		
		public boolean hasSolution(Population population) {
			
			Individual[] individual = population.getIndividuals();
			
			for(int i = 0; i < individual.length; i++) {
				if((int) individual[i].getFitness() == GOAL) {
					individualWinner = individual[i];
					return true;
				}
			}
			
			return false;		
		}
		
		
		public void mutation() {
			
			for(int i = 0; i < individuals.length; i++){
				
				if(0 != ThreadLocalRandom.current().nextInt(0, 5))
					continue;
				int sizePosition = individuals[i].getPositions().length;
					
					int z = ThreadLocalRandom.current().nextInt(0, sizePosition);
					
					int axisX = ThreadLocalRandom.current().nextInt(-1, 1 + 1);
					int axisY = ThreadLocalRandom.current().nextInt(-1, 1 + 1);
					
					Footstep foot = new Footstep();
					foot.setPosition(axisX, axisY);
//					System.out.println(individuals[i]);
					individuals[i].getPositions()[z] = foot;
//					System.out.println(individuals[i] + " - " + z +" - " + axisX + " - " + axisY  );
			}
			
			classify();
		}
		
		
		private void classify() {
			
			// verifica a posição
			for(int i = 0; i < individuals.length; i++){
				int x = 0;
				int y = 0;
				
				Footstep[] position = individuals[i].getPositions();
				
				for(int j = 0; j < position.length; j++) {
					
					x += position[j].getAxisX();
					y += position[j].getAxisY();
				}
				individuals[i].setFitness(x + y);
			}
		}
	}

}
