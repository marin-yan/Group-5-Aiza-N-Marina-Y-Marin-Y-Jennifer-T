import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Customer here.
 * 
 * @author (Jennifer, Marin) 
 * @version (a version number or a date)
 */
public class Customer extends SuperSmoothMover
{
    private static final int ENTRY_X = 405;
    private static final int ENTRY_Y = 210;
    private static final int COUNTER_X = 225;
    private static final int COUNTER_Y = 275;
    private static final double WALK_SPEED = 2.2;
    
    private boolean atCounter;
    
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

    public Customer() {
        setImage("customer.png");
    }
    
    public void addedToWorld(World world) {
        setLocation(ENTRY_X, ENTRY_Y);
    }
    
    public void act()  {
        walkToCounter();
    }
    
    private void walkToCounter() {
        if (atCounter)
        {
            return;
        }
        
        double dx = COUNTER_X - getPreciseX();
        double dy = COUNTER_Y - getPreciseY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        
        if (distance <= WALK_SPEED)
        {
            setLocation(COUNTER_X, COUNTER_Y);
            atCounter = true;
            return;
        }
        
        double stepX = (dx / distance) * WALK_SPEED;
        double stepY = (dy / distance) * WALK_SPEED;
        setLocation(getPreciseX() + stepX, getPreciseY() + stepY);
    }
    
    public void orderFood() {
        
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
