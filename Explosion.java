import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class that runs the explosion animation
 * 
 * @author Alex Chang 
 * @version Spring 2016
 */
public class Explosion extends Actor
{
    private GifImage gif = new GifImage("Explosion Animation.gif");
    int counter =20;
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(gif.getCurrentImage());
        counter--;
        remove();
    }
    /**
     * Constructor for the Explosion class. Produces the explosion sound effect.
     */
    public Explosion()
    {
        Greenfoot.playSound("Bomb Sound.mp3");
    }
    /**
     * Removes the explosion object from the world once the animation is complete.
     */
    public void remove()
    {
        if (counter==0)
        {
            getWorld().removeObject(this);
        }
    }
}
