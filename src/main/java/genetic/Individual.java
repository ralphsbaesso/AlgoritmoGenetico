package genetic;

import java.util.concurrent.ThreadLocalRandom;

public class Individual {
	
	// gera um individuo com genes aleatorio
	public Individual() {
		
		for(Footstep position : positions) {
			
			int axisX = ThreadLocalRandom.current().nextInt(-1, 1 + 1);;
			int axisY = ThreadLocalRandom.current().nextInt(-1, 1 + 1);;
			position.setPosition(axisX, axisY);
		}
	}
	
	// gera um individua a partit do cruzamento dos pais
	public Individual(Individual ind1, Individual ind2) {
		
	}
	
	private int size = 10;
	private double fitnes = 0;
	private String[] genes = new String[size];
	private Footstep[] positions = new Footstep[size];
	
	
	public double getFitnes() {
		return fitnes;
	}
	public void setFitnes(double fitnes) {
		this.fitnes = fitnes;
	}
	public String[] getGenes() {
		return genes;
	}
	public void setGenes(String[] genes) {
		this.genes = genes;
	}

}
