import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A powerup that replenishes a portion of the player's health.
 * 
 * @author Alex Chang
 * @version Spring 2016
 */
public class RepairKit extends PowerUp
{
    private int health = 40;
    /**
     * Act - do whatever the RepairKit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getInWorld()==true)
        {
            moveUp(2);
        }
        if(getInWorld()==true)
        {
            touchPlayer();
        }
        if(getInWorld()==true)
        {
            remove();
        }
    }    
    /**
     * Restores part of the player's health when the RepairKit comes into contact
     * with the player.
     */
    public void touchPlayer()
    {
        Player player= (Player)getOneObjectAtOffset(0,0,Player.class);
        if (player !=null)
        {
            if (player.getHealth()<=100-health)
            {
                player.setHealth(player.getHealth()+health);
                ((MyWorld)getWorld()).getHealthBar().add(health);
                setInWorld(false);
                getWorld().removeObject(this);
            }
            else
            {
                player.setHealth(100);
                ((MyWorld)getWorld()).getHealthBar().setValue(100);
                setInWorld(false);
                getWorld().removeObject(this);
            }
        }        
    }
    /**
     * Accessor method for the health variable;
     * @return the amount of health the health pack restores.
     */
    public int getHealth()
    {
        return health;
    }
}
