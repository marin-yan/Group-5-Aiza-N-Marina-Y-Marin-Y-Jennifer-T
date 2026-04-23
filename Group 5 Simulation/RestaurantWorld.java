import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (background image - Jennifer) (Buttons -- Aiza) 
 * @version (a version number or a date)
 */
public class RestaurantWorld extends World
{
    // Set up background image variables
    private GreenfootImage backgroundImage_player1;
    private GreenfootImage backgroundImage_player2;
    private GreenfootImage background;
    private GreenfootImage bg;
    private int middleLineThickness;
    
    //variables for buttons
    private int player1Index = 0;
    private int player2Index = 0;
    //Arrays for the player to choose background
    private GreenfootImage[] player1Backgrounds;
    private GreenfootImage[] player2Backgrounds;    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public RestaurantWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        
        // Set up background image
        background = new GreenfootImage(getWidth(), getHeight());
        backgroundImage_player1 = new GreenfootImage("images/Background/backgroundImage_player1.png");
        backgroundImage_player2 = new GreenfootImage("images/Background/backgroundImage_player2.png");
        background.drawImage(backgroundImage_player1, 0, 0);
        background.drawImage(backgroundImage_player2, getWidth() / 2, 1);
        setBackground (background);
        
        bg = getBackground();
        bg.setColor(new Color(139, 69, 19));
        middleLineThickness = 5;
        bg.fillRect((getWidth() / 2) - (middleLineThickness / 2), 0, middleLineThickness, getHeight());

        addObject(new Customer(), 0, 0);
    }
    
    public void changeBackground(int player, int direction)
    {
        if (player == 1)
        {
            player1Index += direction;
        }
        else
        {
            player2Index += direction;
        }
    
        //all the logic after this
    }
}
