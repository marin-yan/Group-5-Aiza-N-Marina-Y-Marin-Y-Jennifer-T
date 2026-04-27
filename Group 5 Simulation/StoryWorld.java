import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StoryWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoryWorld extends World
{
    private int timer = 300;
    
    /**
     * Constructor for objects of class StoryWorld.
     * 
     */
    public StoryWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        setBackground(new GreenfootImage("images/Background/StoryWorld.png"));
        Greenfoot.setWorld(this);
        
        addObject (new GordonRamsay(), 350, 400);
        
        Owner owner = new Owner(0, false);
        addObject (owner, 850, 400);
        owner.getImage().scale(370, 370); // change scale of image specifically for StoryWorld

        
    }
    
    public void act() {
        timer--;
        if (timer < 0) {
            Greenfoot.setWorld(new CustomizeWorld());
        }
    }
}

