package genetic;

public class Individual {
	
	// gera um individuo com genes aleatorio
	public Individual() {
		
	}
	
	// gera um individua a partit do cruzamento dos pais
	public Individual(Individual ind1, Individual ind2) {
		
	}
	
	private double fitnes = 0;
	private String[] genes = new String[10];
	private Position position = new Position();
	
	
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
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}

}
