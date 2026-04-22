import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Staff here.
 * 
 * @author (Jennifer) 
 * @version (a version number or a date)
 */
public class Staff extends SuperSmoothMover
{
    // Initial direction
    String facing = "down";
    
    // Track index of walking
    protected int walkingIndex = 0;
    
    // Make the animation slower / more precise
    protected int counter = 0;
    
    // Speed of the customer
    protected int speed = 5;
    
    // Initializing the arrays
    protected GreenfootImage[] walkDown;
    protected GreenfootImage[] walkUp;
    protected GreenfootImage[] walkRight;
    protected GreenfootImage[] walkLeft;
    
    public void act()
    {
        // Add your action code here.
    }
       
    public void walkingDown(){
        setLocation(getX(), getY() + speed);
        setImage(walkDown[walkingIndex]);
        walkingIndex = (walkingIndex + 1) % walkDown.length;
    }
    
    public void walkingUp(){
        setLocation(getX(), getY() - speed);
        setImage(walkUp[walkingIndex]);
        walkingIndex = (walkingIndex + 1) % walkUp.length;
    }
    
    public void walkingRight(){
        move(speed);
        setImage(walkRight[walkingIndex]);
        walkingIndex = (walkingIndex + 1) % walkRight.length;
    }
    
    public void walkingLeft(){
        move(-speed);
        setImage(walkLeft[walkingIndex]);
        walkingIndex = (walkingIndex + 1) % walkLeft.length;
    }
}
