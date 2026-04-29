import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Staff here.
 * 
 * @author (Jennifer) (Stat bar additions -- Aiza)
 * @version (a version number or a date)
 */
public class Staff extends SuperSmoothMover
{
    // Initial direction
    String facing = "down";
    String lastFacing = "";
    
    // Track moving
    protected boolean moving = false;
    
    // Track index of walking
    protected int walkingIndex = 0;
    
    // Make the animation slower / more precise
    protected int counter = 0;
    
    // Speed of the customer
    protected int speed;
    protected int animationSpeed;
    
    protected int state = 0;
    
    // Two sides 
    protected boolean isLeftSide;
    
    // Initializing the arrays
    protected GreenfootImage[] walkDown;
    protected GreenfootImage[] walkUp;
    protected GreenfootImage[] walkRight;
    protected GreenfootImage[] walkLeft;
    
    //for stat bar

    
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
    
    public void move(){
        counter++;
        
        // Reset animation when direction changes 
        if(!facing.equals(lastFacing)){
            walkingIndex = 0;
            lastFacing = facing;
        }
        
        if(counter % animationSpeed == 0){
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
    
    public boolean at(int x, int y){
        return Math.abs(getPreciseX() - x) < 10 && Math.abs(getPreciseY() - y) < 10;
    }
}
