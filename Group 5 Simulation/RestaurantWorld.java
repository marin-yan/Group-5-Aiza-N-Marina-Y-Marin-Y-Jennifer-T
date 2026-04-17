import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (background image - Jennifer) 
 * @version (a version number or a date)
 */
public class RestaurantWorld extends World
{
    // Set up background image variables
    private GreenfootImage backgroundImage_player1;
    private GreenfootImage backgroundImage_player2;
    private GreenfootImage background;
<<<<<<< Updated upstream
    private GreenfootImage bg;
    private int middleLineThickness;
=======
    
    
>>>>>>> Stashed changes
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public RestaurantWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        
        // Set up background image
        background = new GreenfootImage(getWidth(), getHeight());
        backgroundImage_player1 = new GreenfootImage("backgroundImage_player1.png");
        backgroundImage_player2 = new GreenfootImage("backgroundImage_player2.png");
        background.drawImage(backgroundImage_player1, 0, 0);
        background.drawImage(backgroundImage_player2, getWidth() / 2, 1);
        setBackground (background);
        bg = getBackground();
        bg.setColor(new Color(139, 69, 19));
        middleLineThickness = 5;
        bg.fillRect((getWidth() / 2) - (middleLineThickness / 2), 0, middleLineThickness, getHeight());
    }
}
