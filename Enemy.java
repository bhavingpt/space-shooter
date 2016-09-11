import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A superclass for all enemy ships.
 * 
 * @author Alex Chang
 * @version Spring 2016
 */
public class Enemy extends Actor
{
    private int myHealth = 0;
    private int points = 0;
    private int damage = 0;
    private int laserCounter =30;
    private int laserCoolDown = 150;
    private int cannonCounter=200;
    private int cannonCoolDown= 300;
    private boolean inWorld = true;
    private int myChromosomeIndex=0;
    private int ticksSurvived=0;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    /**
     * Moves the enemy up or down by the specified number of units.
     * @param distance the distance the enemy covers for each unit of time.
     */
    public void moveUp(int distance)
    {
        setLocation(getX(),getY()-distance);
    }
    /**.
     * Accessor method for the variable myHealth.
     * @return health the amount of health the enemy has.
     */
    public int getHealth()
    {
        return myHealth;
    }
    /**
     * Modifier method for the variable myHealth.
     * @param the new value for myHealth
     */
    public void setHealth(int health)
    {
        myHealth = health;
    }
    /**
     * Removes enemy if it reaches the lower boundary of the screen.
     */
    public void remove()
    {
        if (getY()==getWorld().getHeight()-1)
        {
            EnemyGenerator.updateFitness(myChromosomeIndex, ticksSurvived);
            setInWorld(false);
            getWorld().removeObject(this);
        }
    }
    /**
     * Destroys enemy if myHealth is less than or equal to 0.
     */
    public void destroy()
    {
        if (myHealth<=0)
        {
            EnemyGenerator.updateFitness(myChromosomeIndex, ticksSurvived);
            ((MyWorld)getWorld()).getCounter().add(points);
            createExplosion();
            setInWorld(false);
            getWorld().removeObject(this);
        }
    }    
    /**
     * Accessor method for the points variable.
     * @return the point value of the enemy.
     */
    public int points()
    {
        return points;
    }
    /**
     * Modifier method for the points variable.
     * @param the point value of the enemy
     */
    public void setPoints(int value)
    {
        points = value;
    }
    /**
     * Creates explosion when the Enemy dies.
     */
    public void createExplosion()
    {
        getWorld().addObject(new Explosion(),getX(),getY());
    }
    /**
     * Accessor method for the damage variable
     * @return the ammount of damage the enemy inflicts when it contacts the player
     */
    public int getDamage()
    {
        return damage;
    }
    /**
     * Modifier method for the damage variable. Takes the new damage as a parameter.
     * @param the amount of damage the enemy inflicts when it contacts the player.
     */
    public void setDamage(int num)
    {
        damage = num;
    }
    /**
     * Accessor method for the inWorld variable
     * @return true if the enemy is in the world, false if otherwise.
     */
    public boolean getInWorld()
    {
        return inWorld;
    }
    /**
     * Modifier method for the inWorld variable
     * @param whether or not the enemy is in the world or not
     */
    public void setInWorld(boolean in)
    {
        inWorld = in;
    }
    /**
     * Accessor method for the laserCoolDown variable.
     * @return the amount of time between enemy laser shots
     */
    public int getLaserCoolDown()
    {
        return laserCoolDown;
    }
    /**
     * Modifier method for the laserCoolDown variable.
     * @param the amount of time between enemy laser shots
     */
    public void setLaserCoolDown(int coolDown)
    {
        laserCoolDown = coolDown;
    }
    /**
     * Accessor method for the laserCounter variable.
     * @return how long before the enemy shoots lasers again.
     */
    public int getLaserCounter()
    {
        return laserCounter;
    }
    /**
     * Modifier method for the laserCounter variable.
     * @param how long before the enemy shoots lasers again.
     */
    public void setLaserCounter(int counter)
    {
        laserCounter=counter;
    }
    /**
     * Accessor method for the cannonCoolDown variable.
     * @return the amount of time between enemy cannon shots
     */
    public int getCannonCoolDown()
    {
        return cannonCoolDown;
    }
    /**
     * Modifier method for the cannonCoolDown variable.
     * @param the amount of time between enemy cannon shots
     */
    public void setCannonCoolDown(int coolDown)
    {
        cannonCoolDown = coolDown;
    }
    /**
     * Accessor method for the CannonCounter variable.
     * @return how long before the enemy shoots its cannons again.
     */
    public int getCannonCounter()
    {
        return cannonCounter;
    }
    /**
     * Modifier method for the laserCounter variable.
     * @param how long before the enemy shoots its cannons again.
     */
    public void setCannonCounter(int counter)
    {
        cannonCounter=counter;
    }
    /**
     * Shoots the cannons on the left side of the enemy ship.
     * @param offsetX is the horizontal offset of the cannon shot from the center
     * of the enemy.
     * @param offsetY is the vertical offset of the cannon shot from the center of
     * the enemy.
     */
    public void shootLeft(int offsetX, int offsetY)
    {
        getWorld().addObject(new LeftBullet(),getX() + offsetX,getY() + offsetY);        
    }
    /**
     * Shoots the cannons on the right side of the enemy ship.
     * @param offsetX is the horizontal offset of the cannon shot from the center
     * of the enemy.
     * @param offsetY is the vertical offset of the cannon shot from the center of
     * the enemy.
     */
    public void shootRight(int offsetX, int offsetY)
    {
        getWorld().addObject(new RightBullet(),getX() + offsetX,getY() + offsetY);
    }
    /**
     * Shoots the lasers forward everytime the laserCounter hits 0;
     * @param the horizontal offset of the laser with respect to the enemy
     * @param the vertical offset of the laser with respect to the enemy
     */
    public void shootLaserForward(int horizontal, int vertical)
    {
        if(laserCounter==0)
        {
            getWorld().addObject(new EnemyLaser(),getX()+horizontal,getY()+vertical);
            laserCounter+=laserCoolDown;
        }
    }
    /**
     * Inflicts damage on the player when the enemy comes into contact
     */
    public void crashIntoPlayer()
    {
        Player player= (Player)getOneObjectAtOffset(0,0,Player.class);
        if (player !=null)
        {
            EnemyGenerator.updateFitness(myChromosomeIndex, ticksSurvived);
            player.setHealth(player.getHealth()-damage);
            ((MyWorld)getWorld()).getHealthBar().subtract(damage);
            setInWorld(false);
            getWorld().addObject(new Explosion(),getX(),getY());
            getWorld().removeObject(this);
        }        
    }
    /**
     * Accessor method for the ticksSurvived variable.
     * @return ticksSurvived the duration for which the enemy ship survives.
     */
    public int getTicksSurvived()
    {
        return ticksSurvived;
    }
    /**
     * Accessor method for the myChromosomeIndex variable
     * @return myChromsomeIndex the index of the genetic unit
     */
    public int getMyChromosomeIndex()
    {
        return myChromosomeIndex;
    }
    /**
     * Modifier method for the index variable.
     * @param the chromosome value of the enemy
     */
    public void setIndex(int index)
    {
        myChromosomeIndex = index;
    }
    /**
     * Tracks how long the enemy has survived
     * If called, increases the survival tick count by 1
     */
    public void livedAnotherDay()
    {
    	ticksSurvived++;
    }


}
