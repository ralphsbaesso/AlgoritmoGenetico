package genetic;

public class Population {
	
	Population(int amountIndividual){
		this.individuals = new Individual[amountIndividual];
	}
	
	private int generation = 0;
	private Individual[] individuals;

}
