import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (Marina) 
 * @version (a version number or a date)
 */
public class StartWorld extends World
{
    private Button startButton;
    
    public StartWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        setBackground(new GreenfootImage("images/Background/StartWorld.png"));
        startButton = new Button("Start", 150);
        addObject(startButton, getWidth() / 2, getHeight() / 5 * 4 + 20);
        Greenfoot.setWorld(this);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(startButton)) {
            Greenfoot.setWorld(new StoryWorld()); 
        }
    }
}