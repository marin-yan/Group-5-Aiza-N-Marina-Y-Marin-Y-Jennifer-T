import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.World;

/**
 * Write a description of class StartButton here.
 * 
 * @author (Aiza) 
 * @version (a version number or a date)
 */
public class StartButton extends Button
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public StartButton()
    {
        super("Start", 150);
    }

    public void onClick()
    {
        Greenfoot.setWorld(new RestaurantWorld(0, 0)); // or whatever your game world is
    }
}