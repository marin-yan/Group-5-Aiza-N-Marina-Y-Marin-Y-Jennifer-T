import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 * 
 * @author (Jennifer) 
 * @version (a version number or a date)
 */
public class Frog extends Customer
{
    // Initializing the arrays
    GreenfootImage[] walkDown = new GreenfootImage[4];
    GreenfootImage[] walkUp = new GreenfootImage[4];
    GreenfootImage[] walkRight = new GreenfootImage[2];
    GreenfootImage[] walkLeft = new GreenfootImage[2];
    /*
    // Initial direction
    String facing = "down";
    
    // Track index of walking
    private int walkingIndex = 0;
    
    // Make the animation slower / more precise
    private int counter = 0;
    
    // Speed of the customer
    private int speed = 5;
    */
   
    // Make the animation slower / more precise
    private int counter = 0;
    public Frog(){
        // Walk down animation - set images
        for(int i = 0; i < walkDown.length; i++){
            walkDown[i] = new GreenfootImage("images/frog/down" + i + ".png");
            walkDown[i].scale(75, 75);
        }
        
        // Walk up animation - set images
        for(int i = 0; i < walkUp.length; i++){
            walkUp[i] = new GreenfootImage("images/frog/up" + i + ".png");
            walkUp[i].scale(75, 75);
        }
        
        // Walk right animation - set images
        for(int i = 0; i < walkRight.length; i++){
            walkRight[i] = new GreenfootImage("images/frog/right" + i + ".png");
            walkRight[i].scale(75, 75);
        }
        
        // Walk left animation - set images
        for(int i = 0; i < walkLeft.length; i++){
            walkLeft[i] = new GreenfootImage("images/frog/left" + i + ".png");
            walkLeft[i].scale(75, 75);
        }
        
        //For testing
        setImage(walkDown[0]);
        //setImage(walkUp[0]);
        //setImage(walkRight[0]);
        //setImage(walkLeft[0]);
    }
    
    public void act(){
        counter++;
        if(counter % 6 == 0){
            if(facing.equals("down")){
                walkingDown();
            }else if(facing.equals("up")){
                walkingUp();
            }else if(facing.equals("right")){
                walkingRight();
            }else if(facing.equals("left")){
                walkingLeft();
            }
        }
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