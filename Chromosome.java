import java.util.*;

/**
 * Specific chromosome that is going to have a sequence of genes such as '01101001010'
 * 
 * @author Bhavin Gupta 
 * @version AP Computer Science A
 */
public class Chromosome
{
    private ArrayList<Boolean> chromosome;
    private double fitness = 0; //ouch

    /*
     * Constructor for the chromosome class. Creates a single chromosome which is 
     * represented in the form of an arraylist of booleans, all false for now.
     * 
     * @param num_genes the length of the ArrayList
     * 
     */public Chromosome(int num_genes)
    {
        chromosome = new ArrayList<Boolean>(num_genes);
        for (int i = 0; i < num_genes; i++) {
            chromosome.add(i, false);
        }
    }
    
    /*
     * Returns the current value of the chromosomes fitness (instance variable)
     * 
     * @return fitness value
     * 
     */public double getFitness() {
        return fitness;
    }
    
    /*
     * Allows the program to set a fitness value - normal setter for an instance variable
     * 
     * @param newFit new fitness value to be set
     * 
     */public void setFitness(double newFit){
        fitness = newFit;
    }
    
    /*
     * Allows the program to get a particular gene from this chromosome
     * given its index.
     * 
     * @param i index of desired gene
     * @return current value of gene
     * 
     */public boolean getGene(int i) {
        return chromosome.get(i);
    }

    /*
     * Allows the user/program to artificially set the value of a gene with index i to newVal
     * 
     * @param i index of desired gene
     * @param newVal value to set the gene to
     * 
     */public void setGene(int i, boolean newVal) {
        chromosome.set(i, newVal);
    }
    
    /*
     * Converts the chromosome to a string. the method is called toString() for ease
     * of use when using print on the Genetic class to display an entire generation.
     * 
     */public String toString(){
        String result = "[ Chromosome: fitness: " + fitness + ", sequence: ";
        for (int i = 0; i < chromosome.size(); i++){
            if (chromosome.get(i)) result += "1";
            else result += "0";
        }
        result += " ]";
        return result;
    }
    
   
    
    
}