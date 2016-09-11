import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An object that randomly generates powerups
 * 
 * @author Alex Chang
 * @version Spring 2016
 */
public class PowerUpGenerator extends Actor
{
    private int weaponUpgradeCounter=6500; 
    private int repairKitCounter=2700;
    private int weaponUpgradeDelay=4000;
    private int repairKitDelay=2700;
    /**
     * Act - do whatever the PowerUpGenerator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(repairKitCounter>0)
        {
            repairKitCounter--;
        }
        if(weaponUpgradeCounter>0)
        {
            weaponUpgradeCounter--;
        }
        if(repairKitCounter==0)
        {
            getWorld().addObject(new RepairKit(),(int)(Math.random()*(getWorld().getWidth()-50)+25),0);            
            repairKitCounter+=repairKitDelay;
            repairKitDelay*=1.2;
        }
        if (weaponUpgradeCounter==0)
        {
            getWorld().addObject(new WeaponUpgrade(),(int)(Math.random()*(getWorld().getWidth()-50)+25),0);
            weaponUpgradeCounter+=weaponUpgradeDelay;
            weaponUpgradeDelay*=1.1;
        }
    }    
    /**
     * Accessor method for the weaponUpgradeDelay variable
     * @return how long before each weaponUpgrade powerup is spawned.
     */
    public int getWeaponUpgradeDelay()
    {
        return weaponUpgradeDelay;
    }
    /**
     * Accessor method for the repairKitDelay variable
     * @return how long before each RepairKit powerup is spawned
     */
    public int getRepairKitDelay()
    {
        return repairKitDelay;
    }
    /**
     * Accessor method for the repairKitCounter variable
     * @return how long before another RepairKit powerup is spawned
     */
    public int getRepairKitCounter()
    {
        return repairKitCounter;
    }
    /**
     * Accessor method for the weaponUpgradeCounter variable
     * @return how long before another WeaponUpgrade powerup is spawned
     */
    public int getWeaponUpgradeCounter()
    {
        return weaponUpgradeCounter;
    }
}
