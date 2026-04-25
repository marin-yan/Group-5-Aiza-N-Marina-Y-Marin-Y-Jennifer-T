import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CustomizeWorld here.
 * 
 * @author (Aiza)(Jennifer)
 * Credit: Pinterest "Bg for edits" - zeee
 *         Pinterest -JUNGLORS
 * @version (a version number or a date)
 */
public class CustomizeWorld extends World
{
    // Background 
    private GreenfootImage background; // brown
    private GreenfootImage bg; // white
    private GreenfootImage bg1;
    
    /**
     * Constructor for objects of class CustomizeWorld.
     * 
     */
    public CustomizeWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        // Set up backgrounds
        super(1200, 800, 1);
        background = new GreenfootImage("images/Background/customizeWorldbg.JPG");
        bg = new GreenfootImage("images/Background/characterBg.png");
        bg1 = new GreenfootImage("images/Background/characterBg.png");
        bg1.mirrorHorizontally();
        background.drawImage(bg, -25, -100);
        background.drawImage(bg1, 575, -100);
        setBackground(background);
        
        // Left display 
        addObject(new CharacterDisplay(0), 280, 300);
        addObject(new Button("❮", 80), 190, 405);
        addObject(new Button("❯", 80), 395, 405);
        
        // Right display 
        addObject(new CharacterDisplay(0), 880, 300);
        addObject(new Button("❮", 80), 790, 405);
        addObject(new Button("❯", 80), 995, 405);
    }
}
