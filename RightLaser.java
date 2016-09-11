import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A laser projectile that travels forward and to the right
 * 
 * @author Alex Chang
 * @version Spring 2016
 */
public class RightLaser extends Projectile
{
    private int laserSpeed=24;
    private int damage=50;
    /**
     * Act - do whatever the laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        remove();
        if(getInWorld() ==true)
        {
            moveUp(laserSpeed);
            move(laserSpeed/5);
            dealDamage();
        }
    }
    /**
     * Constructor for the RightLaser class. Plays the laser sound effect.
     */
    public RightLaser()
    {
        Greenfoot.playSound("Laser Shot.wav");
    }
    /**
     * Accessor method for laserSpeed.
     * @return the value of laserSpeed.
     */
    public int getlaserSpeed()
    {
        return laserSpeed;
    }
    /**
     * Accessor method for the laser damage
     * @param newDamage the amount of damage that will be dealt by the laser
     */
    public void setDamage(int newDamage)
    {
        damage= newDamage;
    }
    /**
     * Accessor method for the variable damage.
     * @return damage the amount of damage dealth by the laser.
     */
    public int getDamage()
    {
        return damage;
    }        
    /**
     * Reduces the enemy's health by the damage dealt by the laser. The laser is then 
     * removed.
     */
    public void dealDamage()
    {
        Enemy enemy= (Enemy)getOneObjectAtOffset(0,0,Enemy.class);
        if (enemy !=null)
        {
            enemy.setHealth(enemy.getHealth()-damage);
            setInWorld(false);
            getWorld().removeObject(this);
        }
    }

}
