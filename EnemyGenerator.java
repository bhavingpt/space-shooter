import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class that generates enemies and manages level difficulty.
 * 
 * @author Bhavin Gupta
 * @version Spring 2016
 * 
 * getWorld().addObject(new Drone(),(int)(Math.random()*(getWorld().getWidth()-50)+25),0);
 * getWorld().addObject(new LightGunship(),(int)(Math.random()*(getWorld().getWidth()-50)+25),0);
 * getWorld().addObject(new HeavyGunship(),(int)(Math.random()*(getWorld().getWidth()-50)+25),0);
 * 
 */
public class EnemyGenerator extends Actor
{
    private int droneDelay = 50;
    private boolean currentlySpawningEnemies = false;
    private static Genetic experiment;
    private int tick = 0;
    private int numEnemies=3;

    private int indexOfEnemy = 0;
    private int levelDelay = 400;
    
    /**
     * Act - do whatever the EnemyGenerator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (tick == 0) {
             experiment = new Genetic (9, 20, 0.85, 0.45);
             tick++;
        }
        
        if (currentlySpawningEnemies) {
            spawnEnemy();
        } else if (levelDelay == 0) {
            levelDelay = 400;
            currentlySpawningEnemies = true;
            experiment.sortGenome();
            experiment.evolve();           
        } else { levelDelay--; }
        
    }    
    
    /*
     * Checks to ensure all the enemies in one level do not spawn simultaneously
     * If go-ahead is given, calls addEnemyToWorld()
     * 
     */public void spawnEnemy() {
        if (droneDelay == 0 ) {
                addEnemyToWorld();
                droneDelay = (int) (Math.random()*50 + 50);
            } else { droneDelay--; } 
    }
    
    /*
     * Physically adds the enemy to the world using the index currently in play
     * calls each helper method to get attributes of enemy from the chromosome with the 
     * correct index
     * 
     */public void addEnemyToWorld() {
        if (indexOfEnemy == 20 || indexOfEnemy*20 > ((MyWorld)getWorld()).getCounter().getValue()) {
            indexOfEnemy = 0;
            currentlySpawningEnemies = false;
            return;
        }
        Chromosome enemy = experiment.genome.get(indexOfEnemy);
        int type = getType(enemy);
        int health = getHealth(enemy);
        int points = getPoints(enemy);
        int damage = getDamage(enemy);
        
        if (type < 3) { 
            getWorld().addObject(new Drone(health, points, damage, indexOfEnemy),(int)(Math.random()*(getWorld().getWidth()-50)+25),0);
        } else if (type < 6) {
            getWorld().addObject(new LightGunship(health, points, damage, indexOfEnemy),(int)(Math.random()*(getWorld().getWidth()-50)+25),0);
        } else {
            getWorld().addObject(new HeavyGunship(health, points, damage, indexOfEnemy),(int)(Math.random()*(getWorld().getWidth()-50)+25),0);
        }
        
        indexOfEnemy++;
    }
    
    /*
     * Gets the type of the enemy from the chromosome
     * 
     * @param chr chromosome to be parsed
     * @return number from 0-8 signaling enemy type
     * 
     */public int getType(Chromosome chr) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (chr.getGene(i)) sum++;
        }
        return sum;
    }
    
    /*
     * Gets the health of the enemy from the chromosome
     * 
     * @param chr chromosome to be parsed
     * @return number from 100-300 signaling enemy health
     * 
     */public int getHealth(Chromosome chr) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if (chr.getGene(i)) sum += Math.pow(2, 2-i);
        }
        return 100 + (sum)*25;
    }
    
    /*
     * Gets the point value of the enemy from the chromosome
     * 
     * @param chr chromosome to be parsed
     * @return number from 25-100 signaling enemy points
     * 
     */public int getPoints(Chromosome chr) {
        int sum = 0;
        for (int i = 3; i < 6; i++) {
            if (chr.getGene(i)) sum += Math.pow(2, 5-i);
        }
        return 25 + (sum)*10;
    }
    
    /*
     * Gets the damage dealed by the enemy from the chromosome
     * 
     * @param chr chromosome to be parsed
     * @return number from 25-40 signaling enemy damage
     * 
     */public int getDamage(Chromosome chr) {
        int sum = 0;
        for (int i = 6; i < 9; i++) {
            if (chr.getGene(i)) sum += Math.pow(2, 8-i);
        }
        return 25 + (sum)*2;
    }
    
    /*
     * accepts two values from a defeated enemy (one identifying, one informational) and
     * uses them to update the fitness value of the chromosome
     * 
     * @param index identifies which chromosome created this enemy
     * @param timeSurvived identifies how successful this enemy was
     * 
     */public static void updateFitness(int index, int timeSurvived) {
        experiment.genome.get(index).setFitness( timeSurvived );
    }
   
}
