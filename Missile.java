import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class for the player's missile weapon.
 * 
 * @author Alex Chang
 * @version 2016
 */
public class Missile extends Projectile
{
    private int missileSpeed=10;
    private int damage=50;
    /**
     * Act - do whatever the Missile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        remove();
        if(getInWorld() ==true)
        {
            moveUp(missileSpeed/3);
            missileSpeed+=1;
            dealDamage();
        }
    }
    /**
     * Accessor method for missileSpeed.
     * @return the value of missileSpeed.
     */
    public int getMissileSpeed()
    {
        return missileSpeed;
    }
    /**
     * Accessor method for the variable damage.
     * @return damage the amount of damage dealth by the missile.
     */
    public int getDamage()
    {
        return damage;
    }        
    /**
     * Reduces the enemy's health by the damage dealt by the missile. The missile is then 
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
