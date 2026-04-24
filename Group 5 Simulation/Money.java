import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Money here.
 * 
 * @author (animation - Jennifer)
 * Credit: Pinterest "16 Bit Video Game Images - Browse 9332 Stock Photos, Vectors, and Video"
 * @version (a version number or a date)
 */
public class Money extends SuperStatBar
{
    public Money(){
        GreenfootImage[] coins = new GreenfootImage[7];
        for(int i = 0; i < coins.length; i++){
            coins[i] = new GreenfootImage("images/coin/" + i + ".png");
            //coins[i].scale(75, 75);
        }
    }
    
    public void act(){
        
    }
}
