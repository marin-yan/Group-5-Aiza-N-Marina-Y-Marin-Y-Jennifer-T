import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Waiter here.
 * 
 * @author (Jennifer) 
 * @version (a version number or a date)
 */
public class Waiter extends Staff
{
    // Initializing the arrays
    GreenfootImage[] walkDown = new GreenfootImage[5];
    
    // Initial direction
    String facing = "down";
    
    // Track index of walking
    private int walkingIndex = 0;
    
    // Make the animation slower / more precise
    private int counter = 0;
    
    // Speed of the customer
    private int speed = 5;
    
    public Waiter(){
        // Walk down animation - set images
        for(int i = 0; i < walkDown.length; i++){
            walkDown[i] = new GreenfootImage("images/waiter1/down" + i + ".png");
            walkDown[i].scale(65, 90);//77,161
        }
        
        setImage(walkDown[0]);
    }
    
    public void act(){
         counter++;
        if(counter % 8 == 0){
            if(facing.equals("down")){
                walkingDown();
            } 
        }
    }

    public void walkingDown(){
        setLocation(getX(), getY() + speed);
        setImage(walkDown[walkingIndex]);
        walkingIndex = (walkingIndex + 1) % walkDown.length;
    }
}
