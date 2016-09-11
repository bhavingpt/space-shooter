import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A missile that is shot to the right and curves up.
 * 
 * @author Alex Chang 
 * @version Spring 2016
 */
public class RightMissile extends Projectile
{
    private int missileSpeed=4;
    private int turnCounter=30;
    private int damage=50;
    private int accelerationDelay=18;
    /**
     * Act - do whatever the RightMissile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        remove();
        if(getInWorld() ==true)
        {
            move(missileSpeed/4);
            if(turnCounter>0)
            {
                turn(-3);
                turnCounter--;
            }
            if(accelerationDelay==0)
            {
                missileSpeed+=1;
            }
            if(accelerationDelay>0)
            {
                accelerationDelay--;
            }
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
    /**
     * Accessor method for the variable turnCounter.
     * @return for how many steps the missile turns.
     */
    public int getTurnCounter()
    {
        return turnCounter;
    }
    /**
     * Accessor method for the accelerationDelay variable.
     * @return how long before the missile starts accelerating.
     */
    public int getAccelerationDelay()
    {
        return accelerationDelay;
    }

}
