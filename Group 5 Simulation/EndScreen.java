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
    private int character1;
    private int character2;
    
    Actor leftCharacter;
    Actor rightCharacter;
    
    //to decide winner or loser
    private int leftCoins;
    private int rightCoins;
    int coinsPerLevel = 8;
    int leftLevel;
    int rightLevel;
    
    public EndScreen(int leftCoins, int rightCoins, int character1, int character2, int leftLevel, int rightLevel)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        
        this.character1 = character1;
        this.character2 = character2;
        
        this.leftCoins = leftCoins;
        this.rightCoins = rightCoins;
        
        this.leftLevel = leftLevel;
        this.rightLevel = rightLevel;
        
        background = new GreenfootImage("images/Background/customizeWorldbg.JPG");
        bg = new GreenfootImage("images/Background/characterBg.png");
        bg1 = new GreenfootImage("images/Background/characterBg.png");
        bg1.mirrorHorizontally();
        background.drawImage(bg, -25, -100);
        background.drawImage(bg1, 575, -100);
        setBackground(background);
        
        
        if (character1 == 0) {
            leftCharacter = new CharacterDisplay(0);
        } else if (character1 == 1) {
            leftCharacter = new CharacterDisplay(1);
        } else if (character1 == 2) {
            leftCharacter = new CharacterDisplay(2);
        } else {
            leftCharacter = new CharacterDisplay(3);
        }
        
        if (character2 == 0) {
            rightCharacter = new CharacterDisplay(0);
        } else if (character2 == 1) {
            rightCharacter = new CharacterDisplay(1);
        } else if (character2 == 2) {
            rightCharacter = new CharacterDisplay(2);
        } else {
            rightCharacter = new CharacterDisplay(3);
        }
        
        addObject(leftCharacter, 300, 400);
        addObject(rightCharacter, 900, 400);
        
        //determine the winner
        String leftResult;
        String rightResult;
        
        if (leftCoins > rightCoins)
        {
            leftResult = "WINNER!!";
            rightResult = "LOST :(";
        }
        else if (rightCoins > leftCoins)
        {
            leftResult = "LOST :(";
            rightResult = "WINNER!!";
        }
        else
        {
            leftResult = "DRAW";
            rightResult = "DRAW";
        }
        
        
        GreenfootImage textBg = getBackground();
        textBg.setColor(Color.BLACK);
        textBg.setFont(new Font(25)); //"FontName, bold, italic, size"
        textBg.drawString("Coin Count: " + leftCoins, 140, 545);
        textBg.drawString("Level: " + leftLevel, 140, 625);
        textBg.drawString(leftResult, 150, 705);
        textBg.drawString("Coin Count: " + rightCoins, 750, 545);
        textBg.drawString("Level: " + rightLevel, 750, 625);
        textBg.drawString(rightResult, 760, 705);
    }
}
