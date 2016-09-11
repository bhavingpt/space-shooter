import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class for the player's ship. Includes movement and firing capabilities.
 * 
 * @author Alex Chang 
 * @version Spring 2016
 */
public class Player extends Actor
{
    public static final int WIDTH=60;
    public static final int HEIGHT=60;
    private int missileCounter = 200;
    private int missileCoolDown =90;
    private int myHealth=100;
    private int laserCounter = 180;
    private int laserCoolDown = 40;
    private int scoreCounter=60;
    private boolean inWorld = true;
    private boolean hasMissiles = true;
    private int weaponLevel=1;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (inWorld)
        {
            movement();
            shoot();
            incrementScore();
            if (missileCounter>0&& hasMissiles == true)
            {
                missileCounter--;
            }
            if (laserCounter>0)
            {
                laserCounter--;
            }
            if (scoreCounter>0)
            {
                scoreCounter--;
            }
            destroy();
        }
    }
    /**
     * Constructor for the Player Class
     */
    public Player()
    {
        
    }
    /**
     * Controls the player's overall movement.
     */
    public void movement()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            if(getX()>=WIDTH/2)
            {
                move(-4);
            }
        }
        if (Greenfoot.isKeyDown("right"))
        {
            if(getX()< getWorld().getWidth()-WIDTH/2)
            {
                move(4);
            }
        }
        if (Greenfoot.isKeyDown("up"))
        {
            if(getY()>HEIGHT/2)
            {
                moveUp(5);
            }
        }
        if (Greenfoot.isKeyDown("down"))
        {
            if(getY()< getWorld().getHeight()-75)
            {
                moveUp(-5);
            }
        }        
    }
    /**
     * Moves the player up or down by the specified number of units.
     * @param distance the distance the player covers over a unit of time.
     */
    public void moveUp(int distance)
    {
        setLocation(getX(),getY()-distance);
    }
    /**
     * Shoots the players weapons.
     */
    public void shoot()
    {
        if(weaponLevel ==1)
        {
            shootLevel1();
        }
        if(weaponLevel ==2)
        {
            shootLevel2();
        }
        if(weaponLevel ==3)
        {
            shootLevel3();
        }
        if(weaponLevel ==4)
        {
            shootLevel4();
        }
        if(weaponLevel ==5)
        {
            shootLevel5();
        }
        if(weaponLevel ==6)
        {
            shootLevel6();
        }
        if(weaponLevel ==7)
        {
            shootLevel7();
        }
        if(weaponLevel ==8)
        {
            shootLevel8();
        }
        if(weaponLevel ==9)
        {
            shootLevel9();
        }
        if(weaponLevel >=10)
        {
            shootLevel10();
        }
    }
    /**
     * Rank 1 firing capabilities
     */
    public void shootLevel1()
    {
        if(laserCounter==0)
        {
            getWorld().addObject(new Laser(),getX(),getY()-20);
            laserCounter+=laserCoolDown;
        }
    }
    /**
     * Rank 2 firing capabilities
     */
    public void shootLevel2()
    {
        if(laserCounter==0)
        {
                getWorld().addObject(new Laser(),getX()-6,getY()-8);
                getWorld().addObject(new Laser(),getX()+6,getY()-8); 
                laserCounter+=laserCoolDown;
        }
    }
    /**
     * Rank 3 firing capabilities
     */
    public void shootLevel3()
    {
        laserCoolDown=28;
        if(laserCounter==0)
        {
                getWorld().addObject(new Laser(),getX()-6,getY()-8);
                getWorld().addObject(new Laser(),getX()+6,getY()-8); 
                laserCounter+=laserCoolDown;
        }
    }
    /**
     * Rank 4 firing capabilities
     */
    public void shootLevel4()
    {
        laserCoolDown=40;
        if (laserCounter ==0)
        {
                getWorld().addObject(new Laser(),getX()-6,getY()-8);
                getWorld().addObject(new Laser(),getX()+6,getY()-8); 
                getWorld().addObject(new RightLaser(),getX()+10,getY()-5); 
                getWorld().addObject(new LeftLaser(),getX()-10,getY()-5); 
                laserCounter+=laserCoolDown;
        }
    }
    /**
     * Rank 5 firing capabilities
     */
    public void shootLevel5()
    {
        laserCoolDown=28;
        if (laserCounter ==0)
        {
                getWorld().addObject(new Laser(),getX()-6,getY()-8);
                getWorld().addObject(new Laser(),getX()+6,getY()-8); 
                getWorld().addObject(new RightLaser(),getX()+10,getY()-5); 
                getWorld().addObject(new LeftLaser(),getX()-10,getY()-5); 
                laserCounter+=laserCoolDown;
        }
    }
    /**
     * Rank 6 firing capabilities
     */
    public void shootLevel6()
    {
        laserCoolDown=38;
            if (laserCounter ==0)
            {
                getWorld().addObject(new Laser(),getX()-9,getY()-8);
                getWorld().addObject(new Laser(),getX(),getY()-20);
                getWorld().addObject(new Laser(),getX()+9,getY()-8); 
                getWorld().addObject(new RightLaser(),getX()+10,getY()-5); 
                getWorld().addObject(new LeftLaser(),getX()-10,getY()-5); 
                laserCounter+=laserCoolDown;
            }
    }
    /**
     * Rank 7 firing capabilities
     */
    public void shootLevel7()
    {
        laserCoolDown= 25;
            if (laserCounter ==0)
            {
                getWorld().addObject(new Laser(),getX()-6,getY()-8);
                getWorld().addObject(new Laser(),getX(),getY()-20);
                getWorld().addObject(new Laser(),getX()+6,getY()-8); 
                getWorld().addObject(new RightLaser(),getX()+10,getY()-5); 
                getWorld().addObject(new LeftLaser(),getX()-10,getY()-5); 
                laserCounter+=laserCoolDown;
            }
    }
    /**
     * Rank 8 firing capabilities
     */
    public void shootLevel8()
    {
        laserCoolDown=28;
            if (missileCounter ==0)
            {
                getWorld().addObject(new LeftMissile(),getX()-25,getY()+10); 
                getWorld().addObject(new RightMissile(),getX()+25,getY()+10); 
                missileCounter+=missileCoolDown;
            }
            if (laserCounter ==0)
            {
                getWorld().addObject(new Laser(),getX()-6,getY()-8);
                getWorld().addObject(new Laser(),getX(),getY()-20);
                getWorld().addObject(new Laser(),getX()+6,getY()-8); 
                getWorld().addObject(new RightLaser(),getX()+10,getY()-5); 
                getWorld().addObject(new LeftLaser(),getX()-10,getY()-5); 
                laserCounter+=laserCoolDown;
            }
    }
    /**
     * Rank 9 firing capabilities
     */
    public void shootLevel9()
    {
        laserCoolDown=20;
        missileCoolDown = 50;
            if (missileCounter ==0)
            {
                getWorld().addObject(new LeftMissile(),getX()-25,getY()+10); 
                getWorld().addObject(new RightMissile(),getX()+25,getY()+10); 
                missileCounter+=missileCoolDown;
            }
            if (laserCounter ==0)
            {
                getWorld().addObject(new Laser(),getX()-6,getY()-8);
                getWorld().addObject(new Laser(),getX(),getY()-20);
                getWorld().addObject(new Laser(),getX()+6,getY()-8); 
                getWorld().addObject(new RightLaser(),getX()+10,getY()-5); 
                getWorld().addObject(new LeftLaser(),getX()-10,getY()-5); 
                laserCounter+=laserCoolDown;
            }
    }
    /**
     * Rank 10 firing capabilities
     */
    public void shootLevel10()
    {
        laserCoolDown=25;
        missileCoolDown = 45;
            if (missileCounter ==0)
            {
                getWorld().addObject(new Missile(),getX()-17,getY()-3);
                getWorld().addObject(new Missile(),getX()+17,getY()-3); 
                getWorld().addObject(new LeftMissile(),getX()-25,getY()+10); 
                getWorld().addObject(new RightMissile(),getX()+25,getY()+10); 
                missileCounter+=missileCoolDown;
            }
            if (laserCounter ==0)
            {
                getWorld().addObject(new Laser(),getX()-6,getY()-8);
                getWorld().addObject(new Laser(),getX(),getY()-20);
                getWorld().addObject(new Laser(),getX()+6,getY()-8); 
                getWorld().addObject(new RightLaser(),getX()+10,getY()-5); 
                getWorld().addObject(new LeftLaser(),getX()-10,getY()-5); 
                laserCounter+=laserCoolDown;
            }
    }
    /**
     * Accessor method for the variable myHealth.
     * @return the player's health
     */
    public int getHealth()
    {
        return myHealth;
    }
    /**
     * Modifier method for the variable myHealth.
     * @param health the new value for myHealth
     */
    public void setHealth(int health)
    {
        myHealth = health;
    }
    /**
     * Accessor method for the variable missileCoolDown.
     * @return the missile cooldown timer.
     */
    public int getMissileCoolDown()
    {
        return missileCoolDown;
    }
    /**
     * Modifier method for the variable missileCoolDown.
     * @param coolDown the amount of time before the missiles are shot again
     */
    public void setMissileCoolDown(int coolDown)
    {
        missileCoolDown = coolDown;
    }
    /**
     * Accessor method for the variable laserCoolDown.
     * @return the laser cooldown timer.
     */
    public int getLaserCoolDown()
    {
        return laserCoolDown;
    }
    /**
     * Modifier method for the variable laserCoolDown.
     * @param coolDown the amount of time before the lasers are shot again
     */
    public void setLaserCoolDown(int coolDown)
    {
        laserCoolDown = coolDown;
    }
    /**
     * Accessor method for the field HEIGHT.
     * @return the height of the player's ship
     */
    public int getHeight()
    {
        return HEIGHT;
    }
    /**
     * Accessor method for the field WIDTH.
     * @return the width of the player's ship
     */
    public int getWidth()
    {
        return WIDTH;
    }
    /**
     * Removes the player from the world when its health reaches 0.
     */
    public void destroy()
    {
        if (myHealth<=0)
        {
            createExplosion();
            setInWorld(false);
            getWorld().removeObject(this);
        }
    }
    /**
     * Creates explosion when the Player dies.
     */
    public void createExplosion()
    {
        getWorld().addObject(new Explosion(),getX(),getY());
    }
    /**
     * Accessor method for the variable inWorld.
     * @return inWorld which is true if the player is in the world.
     */
    public boolean getInWorld()
    {
        return inWorld;
    }
    /**
     * Modifier method for the variable inWorld
     * @param world whether or not the player is in the world or not.
     */
    public void setInWorld(boolean world)
    {
        inWorld = world;
    }
    /**
     * Accessor method for the has method variable
     * @return whether or not the player has the capability to shoot missiles.
     */
    public boolean getHasMissiles()
    {
        return hasMissiles;
    }
    /**
     * Modifier method for the has method variable.
     * @param true if the player has the capability to shoot missiles, or false 
     * if otherwise.
     */
    public void setHasMissiles(boolean missiles)
    {
        hasMissiles = missiles;
    }
    /**
     * Accessor method for the weaponLevel variable
     * @return the level of the player's weapons
     */
    public int getWeaponLevel()
    {
        return weaponLevel;
    }
    /**
     * Adds 1 to the player's weapon level
     */
    public void incrementWeaponLevel()
    {
        weaponLevel++;
    }
    /**
     * Increments 1 to the score
     */
    public void incrementScore()
    {
        if (scoreCounter==0)
        {
            ((MyWorld)getWorld()).getCounter().add(1);
            scoreCounter = 60;
        }
    }
    
}
