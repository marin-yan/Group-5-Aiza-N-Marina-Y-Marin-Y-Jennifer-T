import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Money here.
 * 
 * @author (animation - Jennifer)
 * Credit: Pinterest "16 Bit Video Game Images - Browse 9332 Stock Photos, Vectors, and Video"
 * @version (a version number or a date)
 */
public class Money extends Actor
{
    // Track index of the coin
    private int coinIndex = 0;
    
    // Make the animation slower / more precise
    private int counter = 0;
    
    // Speed of the customer
    private int speed = 5;
    private int animationSpeed;
    
    private GreenfootImage[] coins;
    
    public Money(){
        coins = new GreenfootImage[7];
        for(int i = 0; i < coins.length; i++){
            coins[i] = new GreenfootImage("images/Coin/coin" + i + ".png");
            coins[i].scale(45, 45);
            if(i == 0 || i == 6){
                coins[i].scale(15, 45);
            }
            setImage(coins[3]);
        }
    }
    
    public void act(){
        counter++;
        animationSpeed = 10;
        if(counter % animationSpeed == 0){
            setImage(coins[coinIndex]);
            coinIndex = (coinIndex + 1) % coins.length;
        }
    }
}
