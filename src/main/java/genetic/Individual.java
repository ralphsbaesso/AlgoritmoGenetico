package genetic;

import java.util.concurrent.ThreadLocalRandom;

public class Individual {
	
	
	// gera um individuo com genes aleatorio
	public Individual(int sizeGenes) {
		
		this.sizeGenes = sizeGenes;
		this.positions = new Footstep[sizeGenes];
		
		for(int i = 0; i < sizeGenes; i++) {
			
			positions[i] = new Footstep();
			
			int axisX = ThreadLocalRandom.current().nextInt(-1, 1 + 1);;
			int axisY = ThreadLocalRandom.current().nextInt(-1, 1 + 1);;
			positions[i].setPosition(axisX, axisY);
		}
		
	}
	
	// gera um individua a partit do genes do pais;
	public Individual(Footstep[]  genes1, Footstep[]  genes2) {
		
		this.sizeGenes = genes1.length + genes2.length;
		this.positions = new Footstep[genes1.length + genes2.length];
		
		for(int i = 0; i < positions.length; i++) {
			
			if(i < genes1.length)
				positions[i] = genes1[i];
			else
				positions[i] = genes2[i - genes1.length];
		}
		
		
	}
	
	private int sizeGenes;
	private double fitness;
	private String[] genes = new String[sizeGenes];
	private Footstep[] positions;
	
	
	public double getFitness() {
		return fitness;
	}
	
	public Footstep[] getPositions() {
		return this.positions;
	}
	
	public void setFitness(double fitnes) {
		this.fitness = fitnes;
	}
	
	public String[] getGenes() {
		return genes;
	}
	public void setGenes(String[] genes) {
		this.genes = genes;
	}

	@Override
	public String toString() {
		
		String msg = "";
		
		for(int i = 0; i < this.positions.length; i++) {
			
			msg += positions[i].getCardinal() + ", ";
		}
		
		return msg + "Fitness: " + fitness;
		
	}
	
	
}
