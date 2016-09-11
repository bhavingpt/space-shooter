import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bullet the enemy ships shoot from the left side.
 * 
 * @author Alex Chang
 * @version Spring 2016
 */
public class LeftBullet extends EnemyProjectile
{
    private int bulletSpeed=1;
    private int damage=10;
    /**
     * Act - do whatever the LeftBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getInWorld()==true)
        {
            remove();
        }
        if(getInWorld()==true)
        {
            move(-bulletSpeed);
            dealDamage();
        }
    }   
    /**
     * Accessor method for bulletSpeed.
     * @return the value of bulletSpeed.
     */
    public int getBulletSpeed()
    {
        return bulletSpeed;
    }
    /**
     * Accessor method for the variable damage.
     * @return damage the amount of damage dealt by the LeftBullet.
     */
    public int getDamage()
    {
        return damage;
    }        
    /**
     * Reduces the player's health by the damage dealt by the LeftBullet. The LeftBullet is then 
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
