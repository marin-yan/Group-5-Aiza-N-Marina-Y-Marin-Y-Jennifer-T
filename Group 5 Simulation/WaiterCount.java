import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterDisplay here.
 * 
 * @author (Jennifer, Marin) 
 * @version (a version number or a date)
 */
public class WaiterCount extends Actor
{
    private String v;
    
    public WaiterCount(int num){
        if(num == 0){
            v = "1";
        }else if(num == 1){
            v = "2";
        }else if(num == 2){
            v = "3";
        }else if(num == 3){
            v = "4";
        }
        
        setImage(new GreenfootImage(v, 32, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
