import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A powerup that upgrades the players weapons
 * 
 * @author Alex Chang
 * @version Spring 2016
 */
public class WeaponUpgrade extends PowerUp
{
    /**
     * Act - do whatever the WeaponUpgrade wants to do. This method is called whenever
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
     * Upgrades the player's weapons when the RepairKit comes into contact
     * with the player.
     */
    public void touchPlayer()
    {
        Player player= (Player)getOneObjectAtOffset(0,0,Player.class);
        if (player !=null)
        {
            player.incrementWeaponLevel();
            setInWorld(false);
            getWorld().removeObject(this);
        }        
    }
}
