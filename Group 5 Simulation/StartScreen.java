import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    private Button startButton;

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        setBackground (new GreenfootImage ("images/Background/StartScreen1.png"));
        startButton = new Button("Start", 150);
        addObject(startButton, getWidth() / 2, getHeight() / 5 * 4);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(startButton)) {
            Greenfoot.setWorld(new RestaurantWorld()); 
        }
    }

}
