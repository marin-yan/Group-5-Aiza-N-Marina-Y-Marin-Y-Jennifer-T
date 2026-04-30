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
    private int coinsPerLevel = 20;
    private int level = 1;
    private int maxLevel = 3;

    public LevelStatBar()
    {
        super(20, 0, null, 200, 20, 0, new Color(201, 123, 99), new Color(255, 248, 240), false, new Color(45, 32, 24), 2);
    }

    public void addCoins(int amount)
    {
        totalCoins += amount;

        // Calculate level (max 3?)
        level = Math.min((totalCoins / coinsPerLevel) + 1, maxLevel);

        // Coins within level (0–49)
        int currentLevelCoins = totalCoins % coinsPerLevel;

        // Update bar fill
        update(currentLevelCoins);
    }

    public int getLevel()
    {
        return level;
    }

    public int getTotalCoins()
    {
        return totalCoins;
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
