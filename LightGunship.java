import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An enemy ship that shoots lasers.
 * 
 * @author Alex Chang
 * @version Spring 2016
 */
public class LightGunship extends Enemy
{
    /**
     * Constructor for the LightGunship class. This sets the value of health to 300.
     */
    public LightGunship()
    {
        setHealth(150);
        setPoints(50);
        setDamage(30);
    }
    /**
     * Constructor for the LightGunship class. This sets the values to program specific numbers.
     */
    public LightGunship(int health, int points, int damage, int index)
    {
        setHealth(health);
        setPoints(points);
        setDamage(damage);
        setIndex(index);
    }
    /**
     * Act - do whatever the LightGunship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getInWorld()==true)
        {
            moveUp(-1);
            remove();
        }
        if(getInWorld()==true)
        {
            destroy();
        }
        if(getInWorld()==true)
        {
            shootLaserForward(0,15);
        }
        if(getInWorld()==true)
        {
            crashIntoPlayer();
        }
        if(getLaserCounter()>0)
        {
            setLaserCounter(getLaserCounter()-1);
        }
    }    
}
