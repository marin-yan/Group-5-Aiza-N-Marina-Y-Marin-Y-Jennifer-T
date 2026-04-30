import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinCounter here.
 * 
 * @author (Aiza)(Jennifer - adjust color)
 * @version (a version number or a date)
 */
public class CoinCounter extends SuperStatBar
{
    private int coins = 0;
    private GreenfootImage image;

    public CoinCounter()
    {
        updateImage();
    }

    public void addCoins(int amount)
    {
        coins += amount;
        updateImage();
    }

    public int getCoins()
    {
        return coins;
    }

    private void updateImage()
    {
        image = new GreenfootImage(150, 40);
        image.setColor(new Color(234, 219, 200));
        image.fill();

        image.setColor(new Color(75, 54, 33));
        image.setFont(new Font("Arial", true, false, 20));
        image.drawString("Coins: " + coins, 10, 25);

        setImage(image);

    }
    
    public void act()
    {
        // Add your action code here.
    }
}
