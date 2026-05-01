import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelStatBar here.
 * 
 * @author (Aiza) 
 * @version (a version number or a date)
 */
public class LevelStatBar extends SuperStatBar
{   
    //stat bar for levels variables
    private int totalCoins = 0;
    private int coinsPerLevel = 8;
    private int level = 1;
    private int maxLevel = 3;
    
    private LevelDisplay levelDisplay;

    public LevelStatBar()
    {
        super(8, 0, null, 200, 20, 0, new Color(201, 123, 99), new Color(255, 248, 240), false, new Color(45, 32, 24), 2);
    }

    public void addCoins(int amount)
    {
        totalCoins += amount;

        // Calculate level (max 3?)
        level = Math.min((totalCoins / coinsPerLevel) + 1, maxLevel);

        // Coins within level (0–8)
        int currentLevelCoins = totalCoins % coinsPerLevel;

        // Update bar fill
        update(currentLevelCoins);
        
        if (levelDisplay != null) {
            levelDisplay.setLevel(level);
        }
    }
    

    public void setLevelDisplay(LevelDisplay display)
    {
        this.levelDisplay = display;
    }

    public int getLevel()
    {
        return level;
    }

    public int getTotalCoins()
    {
        return totalCoins;
    }
    
    public boolean hasFinishedGame()
    {
        return totalCoins >= coinsPerLevel * maxLevel;
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
