import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CustomizeWorld here.
 * 
 * @author (Aiza) 
 * @version (a version number or a date)
 */
public class CustomizeWorld extends World
{
    private SelectionButton select;
    /**
     * Constructor for objects of class CustomizeWorld.
     * 
     */
    public CustomizeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        setBackground(new GreenfootImage("customization background.png"));
        Greenfoot.setWorld(this);
    }
    
    
    public void act()
    {
        if (Greenfoot.mouseClicked(select)) {
            Greenfoot.setWorld(new StoryWorld()); 
        }
    }
}
