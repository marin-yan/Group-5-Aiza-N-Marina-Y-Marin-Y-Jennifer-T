import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    
    private GreenfootImage background; // brown
    private GreenfootImage bg; // white
    private GreenfootImage bg1;
    
    //to decide winner or loser
    private int leftCoins;
    private int rightCoins;
    
    public EndScreen(int leftCoins, int rightCoins)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        background = new GreenfootImage("images/Background/customizeWorldbg.JPG");
        bg = new GreenfootImage("images/Background/characterBg.png");
        bg1 = new GreenfootImage("images/Background/characterBg.png");
        bg1.mirrorHorizontally();
        background.drawImage(bg, -25, -100);
        background.drawImage(bg1, 575, -100);
        setBackground(background);
        
        //determine the winner
        String leftResult;
        String rightResult;
        
        if (leftCoins > rightCoins)
        {
            leftResult = "WINNER";
            rightResult = "LOST";
        }
        else if (rightCoins > leftCoins)
        {
            leftResult = "LOST";
            rightResult = "WINNER";
        }
        else
        {
            leftResult = "DRAW";
            rightResult = "DRAW";
        }
        
        
        GreenfootImage textBg = getBackground();
        textBg.setColor(Color.BLACK);
        textBg.setFont(new Font(25)); //"FontName, bold, italic, size"
        textBg.drawString("Coin Count", 140, 545);
        textBg.drawString("Level", 140, 625);
        textBg.drawString(leftResult, 150, 705);
        textBg.drawString("Coin Count", 750, 545);
        textBg.drawString("Level", 750, 625);
        textBg.drawString(rightResult, 760, 705);
    }
}
