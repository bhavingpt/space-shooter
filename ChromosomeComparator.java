import java.util.*;
/**
 * Allows you to compare Chromosomes based on their fitness levels
 * 
 * @author Bhavin 
 * @version AP Computer Science A
 */
public class ChromosomeComparator implements Comparator<Chromosome>
{
    
    
    /*
     * Given two chromosomes, return a value that corresponds to a comparing of 
     * their relative fitness. Genetic class uses Collections.sort in conjunction with this.
     * 
     * @param a first chromosome 
     * @param b second chromosome
     * @return returns positive number if b > a, returns negative number if a > b, else returns 0
     * 
     */public int compare(Chromosome a, Chromosome b)
    {
        double result = b.getFitness() - a.getFitness();
        return (int) (1000*result);
    }

    
}