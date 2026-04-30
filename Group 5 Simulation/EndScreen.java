import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (Jennifer)
 * Credit: Pinterest - "coffee place" by Random Art
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    private GreenfootImage endImage;
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        endImage = new GreenfootImage("images/Background/end.JPG");
        setBackground(endImage);
        
        GreenfootImage textBg = getBackground();
        textBg.setColor(Color.BLACK);
        textBg.setFont(new Font("Monospaced", true, false, 100));
        textBg.drawString("THE END", 425, 280);
    }
}