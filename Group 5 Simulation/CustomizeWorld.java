import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CustomizeWorld here.
 * 
 * @author (Aiza)(Jennifer)
 * @version (a version number or a date)
 */
public class CustomizeWorld extends World
{
    private GreenfootImage background;
    
    /**
     * Constructor for objects of class CustomizeWorld.
     * 
     */
    public CustomizeWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        background = new GreenfootImage("images/Background/customizeWorldbg.JPG");
        setBackground(background);
    }
}
