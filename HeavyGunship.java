import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An enemy ship that shoots both lasers and cannons.
 * 
 * @author Alex Chang
 * @version Spring 2016
 */
public class HeavyGunship extends Enemy
{
    /**
     * Constructor for the HeavyGunship class. This sets the value of health to 300.
     */
    public HeavyGunship()
    {
        setHealth(300);
        setPoints(100);
        setDamage(40);
    }
    /**
     * Constructor for the HeavyGunship class. This sets the values to program specific numbers.
     */
    public HeavyGunship(int health, int points, int damage, int index) 
    {
        setHealth(health);
        setPoints(points);
        setDamage(damage);
        setIndex(index);
    }
    /**
     * Act - do whatever the HeavyGunship wants to do. This method is called whenever
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
            livedAnotherDay();
        }
        if(getInWorld()==true)
        {
            if(getCannonCounter()>0)
            {
                if((int)(getCannonCounter()*Math.random())==0 && getCannonCounter()<200)
                {
                    shootLeft(-20,0);
                    shootRight(20,0);
                    setCannonCounter(getCannonCoolDown());
                }
                else
                {
                    setCannonCounter(getCannonCounter()-1);
                }
            }
            if(getCannonCounter()==0)
            {
                shootLeft(-10,0);
                shootRight(10,0);
                setCannonCounter(getCannonCoolDown());
            }
        }
        if(getInWorld()==true)
        {
            destroy();
        }
        if(getInWorld()==true)
        {
            shootLaserForward(0,40);
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
