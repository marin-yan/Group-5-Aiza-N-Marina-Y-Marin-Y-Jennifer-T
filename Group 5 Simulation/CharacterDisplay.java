import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterDisplay here.
 * 
 * @author (Jennifer) 
 * @version (a version number or a date)
 */
public class CharacterDisplay extends Actor
{
    private GreenfootImage c;
    
    public CharacterDisplay(int num){
        if(num == 0){
            c = new GreenfootImage("images/owner0/down1.png");
        }else if(num == 1){
            c = new GreenfootImage("images/owner1/down1.png");
        }else if(num == 2){
            c = new GreenfootImage("images/owner2/down1.png");
        }else if(num == 3){
            c = new GreenfootImage("images/owner3/down1.png");
        }
        
        c.scale(250, 250);
        setImage(c);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
