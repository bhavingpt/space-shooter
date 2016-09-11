import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A superclass for all the powerups the player can pick up
 * 
 * @author Alex Chang
 * @version Spring 2016.
 */
public class PowerUp extends Actor
{
    private boolean inWorld = true;
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    /**
     * Accessor method for the inWorld variable
     * @return true if the PowerUp is in the world, false if otherwise.
     */
    public boolean getInWorld()
    {
        return inWorld;
    }
    /**
     * Modifier method for the variable inWorld
     * @param world whether or not the PowerUp is in the world or not.
     */
    public void setInWorld(boolean world)
    {
        inWorld = world;
    }
    /**
     * Removes PowerUp if it reaches the lower boundary of the screen.
     */
    public void remove()
    {
        if (getY()==getWorld().getHeight()-1)
        {
            setInWorld(false);
            getWorld().removeObject(this);
        }
    }
    /**
     * Moves the projectile up or down by the specified number of units.
     * @param distance the distance the projectile covers over a unit of time.
     */
    public void moveUp(int distance)
    {
        setLocation(getX(),getY()+distance);
    }
     
}
