import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (Aiza) (edit by Jennifer)
 * Credit: Pinterest -Saigin Ermino
 * @version (a version number or a date)
 */
public class EndScreen extends World
{   
    private GreenfootImage background;
    
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
        
        background = new GreenfootImage("images/Background/end.JPG");
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
        
        addObject(leftCharacter, 400, 350);
        addObject(rightCharacter, 800, 350);
        
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
        
        // Left side
        textBg.drawString("Coin Count: " + leftCoins, 320, 500);
        textBg.drawString("Level: " + leftLevel, 350, 540);
        textBg.drawString(leftResult, 360, 590);
        
        // Right side
        textBg.drawString("Coin Count: " + rightCoins, 720, 500);
        textBg.drawString("Level: " + rightLevel, 750, 540);
        textBg.drawString(rightResult, 760, 590);
    }
}
