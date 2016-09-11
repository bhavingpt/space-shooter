import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The enemy ships' laser projectile
 * 
 * @author Alex Chang 
 * @version Spring 2016
 */
public class EnemyLaser extends EnemyProjectile
{
    private int laserSpeed=12;
    private int damage=5;
    /**
     * Act - do whatever the EnemyLaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        remove();
        if(getInWorld() ==true)
        {
            moveUp(laserSpeed);
            dealDamage();
        }
    }
    /**
     * Accessor method for laserSpeed.
     * @return the value of laserSpeed.
     */
    public int getLaserSpeed()
    {
        return laserSpeed;
    }
    /**
     * Accessor method for the variable damage.
     * @return damage the amount of damage dealth by the EnemyLaser.
     */
    public int getDamage()
    {
        return damage;
    }        
    /**
     * Reduces the player's health by the damage dealt by the EnemyLaser. The EnemyLaser is then 
     * removed.
     */
    public void dealDamage()
    {
        Player player= (Player)getOneObjectAtOffset(0,0,Player.class);
        if (player !=null)
        {
            player.setHealth(player.getHealth()-damage);
            ((MyWorld)getWorld()).getHealthBar().subtract(damage);
            setInWorld(false);
            getWorld().removeObject(this);
        }
    }
 
}
