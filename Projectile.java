import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The projectiles that the player shoots.
 * 
 * @author Alex Chang 
 * @version Spring 2016
 */
public class Projectile extends Actor
{
    private boolean inWorld = true;
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    /**
     * Moves the projectile up or down by the specified number of units.
     * @param distance the distance the projectile covers over a unit of time.
     */
    public void moveUp(int distance)
    {
        setLocation(getX(),getY()-distance/4);
    }
    /**
     * Removes projectile if it hits to upper boundary of the screen.
     */
    public void remove()
    {
        if (getY()==0||getY()==getWorld().getHeight()-1||getX()==0||getX()==getWorld().getWidth()-1)
        {
            inWorld = false;
            getWorld().removeObject(this);
        }
    }
    /**
     * Accessor method for the variable inWorld.
     * @return inWorld which is true if the 
     */
    public boolean getInWorld()
    {
        return inWorld;
    }
    /**
     * Modifier method for the variable inWorld
     * @param world whether or not the projectile is in the world or not.
     */
    public void setInWorld(boolean world)
    {
        inWorld = world;
    }
    
}
