import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The drone is a ship that flies fast but has no firing capabilities.
 * 
 * @author Alex Chang 
 * @version Spring 2016.
 */
public class Drone extends Enemy
{
    /**
     * Constructor for the Drone class. This sets the value of health to 100.
     */
    public Drone()
    {
            setHealth(100);
            setPoints(25);
            setDamage(25);
    }
    /**
     * Constructor for the Drone class. This sets the values to program specific numbers.
     */
    public Drone(int health, int points, int damage, int index)
    {
        setHealth(health);
        setPoints(points);
        setDamage(damage);
        setIndex(index);
    }
    /**
     * Act - do whatever the Drone wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getInWorld()==true)
        {
            moveUp(-2);
            remove();
        }
        if(getInWorld()==true)
        {
            destroy();
        }
        if(getInWorld()==true)
        {
            crashIntoPlayer();
        }
    }
    
}
