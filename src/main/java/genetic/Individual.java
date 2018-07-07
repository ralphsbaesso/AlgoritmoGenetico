package genetic;

import java.util.concurrent.ThreadLocalRandom;

public class Individual {
	private int sizeGenes;
	private double fitness;
	private String[] genes;
	private Footstep[] positions;

	// gera um individuo com genes aleatorio
	public Individual(int sizeGenes) {
		this.sizeGenes = sizeGenes;
		this.positions = new Footstep[sizeGenes];
		this.genes = new String[sizeGenes];

		for (int i = 0; i < sizeGenes; i++) {
			positions[i] = new Footstep();

			int axisX = ThreadLocalRandom.current().nextInt(-1, 1 + 1);
			int axisY = ThreadLocalRandom.current().nextInt(-1, 1 + 1);
			positions[i].setPosition(axisX, axisY);
		}
	}

	// gera um individua a partit do genes do pais;
	public Individual(Footstep[] genes1, Footstep[] genes2) {
		this.sizeGenes = genes1.length + genes2.length;
		this.positions = new Footstep[genes1.length + genes2.length];
		this.genes = new String[this.sizeGenes];

		for (int i = 0; i < positions.length; i++) {
			if (i < genes1.length)
				positions[i] = genes1[i];
			else
				positions[i] = genes2[i - genes1.length];
		}
	}

	public int getSizeGenes() {
		return sizeGenes;
	}

	public void setSizeGenes(int sizeGenes) {
		this.sizeGenes = sizeGenes;
	}

	public double getFitness() {
		return fitness;
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

	public Footstep[] getPositions() {
		return this.positions;
	}

	public void setPositions(Footstep[] positions) {
		this.positions = positions;
	}

	@Override
	public String toString() {
		String msg = "";

		for (int i = 0; i < this.positions.length; i++) {
			msg += positions[i].getCardinal() + ", ";
		}

		msg = msg.substring(0, msg.length() - 2);
		return msg + " Falta para o objetivo: " + fitness;
	}
}