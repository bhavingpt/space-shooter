import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A test class for generating enemies randomly at the top of the screen.
 * 
 * @author Alex Chang
 * @version Spring 2016
 */
public class EnemyGeneratorTest extends Actor
{
    private int droneTimer=500;
    private int droneDelay=200;
    /**
     * Act - do whatever the EnemyGeneratorTest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addDrone();
        if(droneTimer>0)
        {
            droneTimer--;
        }
    }   
    /**
     * Generates Enemies at the top of the screen.
     */
    public void addDrone()
    {
        if (droneTimer==0)
        {
            getWorld().addObject(new Drone(),(int)(Math.random()*(getWorld().getWidth()-50)+25),0);
            droneTimer =droneDelay;
            getWorld().addObject(new LightGunship(),(int)(Math.random()*(getWorld().getWidth()-50)+25),0);
            getWorld().addObject(new HeavyGunship(),(int)(Math.random()*(getWorld().getWidth()-50)+25),0);
            if(droneDelay >3)
            {
                droneDelay-=2;
            }
        }
    }
    /**
     * Accessor method for the droneDelay variable.
     * @return the time before another Drone is added to the screen.
     */
    public int getDroneDelay()
    {
        return droneDelay;
    }
    /**
     * Modifier method for the droneDelay variable.
     * @param delay the time before another Drone is added to the screen.
     */
    public void setDroneDelay(int delay)
    {
        droneDelay=delay;
    }
}
