import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The class the dictates the world.
 * 
 * @author Alex Chang
 * @version Spring 2016
 */
public class MyWorld extends World
{
    private Counter score;
    private Bar healthBar;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 600, 1); 
        setBackground("Nebula Background.jpg");
        addObject(new EnemyGenerator(),0,0);
        score = new Counter("Score: ");
        addObject(score,100,getHeight()-25);
        healthBar = new Bar("HP"," ",100,100);
        addObject(healthBar,getWidth()-100,getHeight()-25);
        addObject(new Player(),getWidth()/2,getHeight()-100);
        addObject(new PowerUpGenerator(),0,0);
    }
    /**
     * Accessor method for the score object.
     * @return the score object
     */
    public Counter getCounter()
    {
        return score;
    }    
    /**
     * Accessor method for the healthBar object
     * @return the healthBar object
     */
    public Bar getHealthBar()
    {
        return healthBar;
    }
}
