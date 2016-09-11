import java.util.*;

/**
 * Class Genetic - Creates a template for chromosomes and genes and implements methods to rearrange them
 * over subsequent generations. Uses the Chromosome class.
 * 
 * @author Bhavin Gupta
 * @version AP Computer Science A
 */
public class Genetic
{
    private int numGenesInChromosome; //number of genes in chromosome d'oh
    private int numChromosomes;   //number of chromosomes d'oh
    public ArrayList<Chromosome> genome; //all the chromosomes = genome
    private double crossoverFraction; //rate at which crossovers occur
    private double mutationFraction;  //rate at which mutations occur d'oh
    private int[] wheelOfFortune;    //list of indexes into genome; it is NOT a one-to-one
    private int wheelSize;           //d'oh
    
    /*
     * Constructor for the Genetic class. Given 4 initial constants (set in TestGenetic), it initialises a genome and a random wheel for mutation
     * 
     * @param genes_in_chromosome number of genes in each chromosome
     * @param num_chromosomes the number of chromosomes in each generation
     * @param crossover_fraction describes the frequency at which crossovers occur
     * @param mutation_fraction describes the frequency at which mutations occur
     * 
     */public Genetic ( int genes_in_chromosome, int num_chromosomes, double crossover_fraction, double mutation_fraction){
        //assign variables
        numGenesInChromosome = genes_in_chromosome;
        numChromosomes = num_chromosomes;
        crossoverFraction = crossover_fraction;
        mutationFraction = mutation_fraction;
        
        //initialize and randomize genome
        genome = new ArrayList<Chromosome>(numChromosomes);
        for (int i = 0; i < numChromosomes; i++) {
            genome.add(i, new Chromosome(numGenesInChromosome));
        }
        
        for (Chromosome chr : genome) {
            for (int j = 0; j < numGenesInChromosome; j++) {
                chr.setGene(j, Math.random() < 0.5);
            }
        }
        
        sortGenome();
        
        //define the weighted wheel
        wheelSize = 0;
        
        for (int i = 1; i < numGenesInChromosome + 1; i++){
            wheelSize += i;
        }
        wheelOfFortune = new int[wheelSize];
        
        int index = 0;
        int allowance = numGenesInChromosome;
        for (int i = 0; i < numChromosomes; i++){
            //NOTE: Since sorted, only fittest chromosomes are added to wheel
            for (int j = 0; j < allowance; j++) {
                wheelOfFortune[index] = i;
                index++;
            }
            allowance--;
            //Only the first few fittest chromosomes get to be in the wheel
        }
    }
    
   /*
    * Convenience contstructor that allows TestGenetic to call the main constructor with fewer variable arguments.
    * 
    * @param genes_in_chromosome number of genes in each chromosome
    * @param num_chromosomes the number of chromosomes in each generation
    * 
    */public Genetic ( int genes_in_chromosome, int num_chromosomes ) {
        this(genes_in_chromosome, num_chromosomes, 0.8, 0.01);
    }
    
    /*
     * Uses the Chromosome Comparator in order to arrange the genome in order of fitness 
     * 
     * 
     */public void sortGenome() {
        Collections.sort(genome, new ChromosomeComparator()); //stack overflow guided me to collections.sort - makes this a very easy method to implement
    }
    
    /*
     * can be called to return a specific single gene given an indexPath (chromosome # -> gene #)
     * 
     * @param chromosome the specific chromosome
     * @param gene the specific gene
     * @return boolean the T/F value of the gene
     * 
     * 
     */public boolean getGene(int chromosome, int gene) {
        return genome.get(chromosome).getGene(gene);
    }
    
    /*
     * Allows the user to set a particular gene to a value - used primarily for mutation / crossovers
     * 
     * @param chromosome the specific chromosome
     * @param gene the specific gene
     * @param value desired value of the gene
     * 
     */public void setGene(int chromosome, int gene, boolean value) {
        genome.get(chromosome).setGene(gene, value);
    }
    
    /*
     * Given a single generation, calculates the appropriate number of crossovers to conduct and
     * performs them. the numCrosses is heavily dependent on the crossoverFraction value the user passed
     * in the constructor, and only the best few chromosomes are used as crossover material.
     * 
     */public void crossover(){
        int numCrosses = (int) (numChromosomes * crossoverFraction);
        
        for (int i = numCrosses; i > 0; i--) {
            int c1 = (int) ((wheelSize - 1) * Math.random());
            int c2 = (int) ((wheelSize - 1) * Math.random());
            int c3 = 1 + (int) ((numChromosomes - 1) * Math.random());
            c1 = wheelOfFortune[c1];
            c2 = wheelOfFortune[c2];
           
            if (c1 != c2) {
                int crossPoint = 1 + (int) ((numGenesInChromosome - 2) * Math.random());
                for (int j = 0; j < numGenesInChromosome; j++){
                    if (j < crossPoint) setGene(c3, j, getGene(c1, j));
                    else setGene(c3, j, getGene(c2, j));
                 }
            }
            
            else {
                int crossPoint = 1 + (int) ((numGenesInChromosome - 2) * Math.random());
                for (int j = 0; j < numGenesInChromosome; j++){
                    if (j < crossPoint) setGene(c3, j, getGene(c1, j));
                 }
             }
            
        }
            
    }
    
    /*
     * Given a single generation, calculates the appropriate number of mutations to conduct and
     * performs them. the number of mutations is heavily dependent on the mutationFraction value the user passed
     * in the constructor, and chromosomes are randomly selected for mutation.
     * 
     */public void mutate(){
        int num = (int) (numChromosomes * mutationFraction);
        
        for (int i = 0; i < num; i++){
            int c = 2 + (int) ((numChromosomes - 2) * Math.random());
            int g = (int) (numGenesInChromosome * Math.random());
            
            setGene(c, g, !getGene(c, g));
        }
    }
    
    /*
     * eliminates a common problem where crossovers are useless because many of the chromosomes are the same. 
     * Identifies if two chromosomes are the same and flips a gene in the worse one
     * 
     */public void removeDuplicates(){
        for (int i = numChromosomes - 1; i > 3; i--){
            for (int j = 0; j < i; j++) {
                int g = (int) (numGenesInChromosome * Math.random());
                setGene(i, g, !getGene(i, g));
                break;
            }
        }
    }
    
    /*
     * The main method for each generation. This method integrates all of the other methods and is called by TestGenetic in order to advance
     * each generation. it first ranks and sorts the genome, mutates it to create the next version, and then edits out duplicates.
     * 
     * 
     */public void evolve() {
        crossover();
        mutate();
        removeDuplicates();
        randomizeGenome();
    }
    
    public void randomizeGenome() {
        for (int i = 0; i < numChromosomes*3; i++) {
            int index1 = (int) (Math.random() * numChromosomes);
            int index2 = (int) (Math.random() * numChromosomes);
            
            Chromosome temp = genome.get(index1); //swaps the chromosomes
            genome.set(index1, genome.get(index2));
            genome.set(index2, temp);
        }
        
    }
   
    /*
     * Method in order to visualize the chromosome output, when called by TestGenetic prints the genome / fitness values
     * and a metadata summary of the genome's average fitness / other stats
     * 
     */public void printResult() {
        double sum = 0;
        for (int i=0; i<numChromosomes; i++) {
            System.out.println( genome.get(i) );
            sum += genome.get(i).getFitness();
        }
        sum /= (double) numChromosomes;
        System.out.println("Average fitness: " + sum );
        System.out.println("Best fitness for this generation: " + genome.get(0).getFitness());
    }
    
    
}